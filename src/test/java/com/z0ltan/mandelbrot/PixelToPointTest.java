package com.z0ltan.mandelbrot;

import static org.junit.Assert.*;

import org.junit.Test;

import com.z0ltan.mandelbrot.core.Algorithm;
import com.z0ltan.mandelbrot.types.Pair;

public class PixelToPointTest {

	@Test
	public void test() {
		assertEquals(Algorithm.pixelToPoint(Pair.of(100, 100), Pair.of(25, 75), Pair.of(-1.0, 1.0), Pair.of(1.0, -1.0)),
				Pair.of(-0.5, -0.5));
	}
}
