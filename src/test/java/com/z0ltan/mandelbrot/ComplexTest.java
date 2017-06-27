package com.z0ltan.mandelbrot;

import org.junit.Test;

import com.z0ltan.mandelbrot.types.Complex;

import junit.framework.TestCase;

public class ComplexTest extends TestCase {
	@Test
	public void testAddComplexDouble() {
		Complex<Double> c1 = new Complex<>(1.2, 3.1);
		Complex<Double> c2 = new Complex<>(1.2, 1.2);

		Complex<Double> sum = c1.add(c2);
		assertEquals(sum, c1.add(c2));
	}

	@Test
	public void testAddComplexLong() {
		Complex<Long> c1 = new Complex<>(1L, 2L);
		Complex<Long> c2 = new Complex<>(2L, 3L);

		assertEquals(new Complex<>(3L, 5L), c1.add(c2));
	}
}
