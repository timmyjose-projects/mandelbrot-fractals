package com.z0ltan.mandelbrot;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

import com.z0ltan.mandelbrot.core.Parse;
import com.z0ltan.mandelbrot.types.Pair;

public class ParseTest {
	@Test
	public void test() {
		assertEquals(Parse.parsePair("", ','), Optional.empty());
		assertEquals(Parse.parsePair("10", ','), Optional.empty());
		assertEquals(Parse.parsePair(",10", ','), Optional.empty());
		assertEquals(Parse.parsePair("10,20", ','), Optional.of(Pair.of(10, 20)));
		assertEquals(Parse.parsePair("10,20xy", ','), Optional.empty());
		assertEquals(Parse.parsePair("0.5x", 'x'), Optional.empty());
		assertEquals(Parse.parsePair("0.5x1.5", 'x'), Optional.of(Pair.of(0.5, 1.5)));
	}
}
