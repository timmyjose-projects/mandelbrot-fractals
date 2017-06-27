package com.z0ltan.mandelbrot;

import java.util.Arrays;
import java.util.Optional;

import com.z0ltan.mandelbrot.core.Algorithm;
import com.z0ltan.mandelbrot.core.Parse;
import com.z0ltan.mandelbrot.types.Pair;

public class App {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		if (args.length != 4) {
			System.err.println(Arrays.toString(args));
			Algorithm.displayUsage();
			Algorithm.exitWithError();
		}

		Optional<Pair<?>> boundsCheck = Parse.parsePair(args[1], 'x');
		if (!boundsCheck.isPresent()) {
			throw new RuntimeException("error parsing image dimensions");
		}

		Pair<Integer> bounds = (Pair<Integer>) boundsCheck.get();

		Optional<Pair<?>> upperLeftCheck = Parse.parsePair(args[2], ',');
		if (!upperLeftCheck.isPresent()) {
			throw new RuntimeException("error parsing upper left corner point");
		}

		Pair<Double> upperLeft = (Pair<Double>) upperLeftCheck.get();

		Optional<Pair<?>> lowerRightCheck = Parse.parsePair(args[3], ',');
		if (!lowerRightCheck.isPresent()) {
			throw new RuntimeException("error parsing lower right corner point");
		}

		Pair<Double> lowerRight = (Pair<Double>) lowerRightCheck.get();

		int[] pixels = new int[bounds.first * bounds.second];

		Algorithm.render(pixels, bounds, upperLeft, lowerRight);

		Algorithm.writeBitmap(args[0], pixels, bounds);
	}
}
