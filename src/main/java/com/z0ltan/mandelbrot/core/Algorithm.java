package com.z0ltan.mandelbrot.core;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;

import com.z0ltan.mandelbrot.types.Complex;
import com.z0ltan.mandelbrot.types.Pair;

public class Algorithm {
	public static void displayUsage() {
		System.err.println("Usage: Mandelbrot FILE PIXELS UPPERLEFT LOWERRIGHT");
		System.err.println("Example: Mandelbrot mandel.png 1000x750 -1.20,0.35 -1.0,0.20");
	}

	public static void exitWithError() {
		System.exit(1);
	}

	public static void complexSquareAddLoop(Complex<Double> c) {
		Complex<Double> z = new Complex<>(0.0, 0.0);

		while (true) {
			z = z.mul(z).add(c);
		}
	}

	public static Optional<Integer> escapes(Complex<Double> c, int limit) {
		Complex<Double> z = new Complex<>(0.0, 0.0);

		for (int i = 0; i < limit; i++) {
			z = z.mul(z).add(c);

			if (z.normSquare() > 4.0) {
				// System.out.println("escapes for " + c + " = " + i);
				return Optional.of(i);
			}
		}

		return Optional.empty();
	}

	public static Pair<Double> pixelToPoint(Pair<Integer> bounds, Pair<Integer> pixel, Pair<Double> upperLeft,
			Pair<Double> lowerRight) {

		double width = lowerRight.first - upperLeft.first;
		double height = upperLeft.second - lowerRight.second;

		return Pair.of(upperLeft.first + pixel.first * width / bounds.first,
				upperLeft.second - pixel.second * height / bounds.second);
	}

	/**
	 * The main rendering function.
	 * 
	 */
	public static void render(int[] pixels, Pair<Integer> bounds, Pair<Double> upperLeft, Pair<Double> lowerRight) {
		if (pixels.length != bounds.first * bounds.second) {
			throw new RuntimeException("Could not match pixels array size against the given bounds");
		}

		for (int r = 0; r < bounds.second; r++) {
			for (int c = 0; c < bounds.first; c++) {
				Pair<Double> point = pixelToPoint(bounds, Pair.of(c, r), upperLeft, lowerRight);

				int escapeValue = 0;
				int count = escapes(new Complex<>(point.first, point.second), 255).orElse(0);
				if (count != 0) {
					escapeValue = 255 - count;
				} else {
					escapeValue = 0;
				}

				pixels[r * bounds.first + c] = escapeValue;
			}
		}
	}

	/**
	 * Create the PNG file of the fractal image.
	 * 
	 * @param filename
	 * @param pixels
	 * @param bounds
	 */
	public static void writeBitmap(String filename, int[] pixels, Pair<Integer> bounds) {
		try {
			BufferedImage image = new BufferedImage(bounds.first, bounds.second, BufferedImage.TYPE_BYTE_GRAY);
			WritableRaster raster = (WritableRaster) image.getData();
			raster.setPixels(0, 0, bounds.first, bounds.second, pixels);
			image.setData(raster);

			ImageIO.write(image, "png", new File(filename));
		} catch (IOException ex) {
			throw new RuntimeException("error writing bitmap image: " + ex.getLocalizedMessage());
		}
	}
}
