package com.z0ltan.mandelbrot.core;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.z0ltan.mandelbrot.types.Pair;

public class Parse {

	
	/**
	 * Parse the input string into a valid pair of values around the given
	 * separator.
	 * 
	 * @param s
	 * @param separator
	 * @return Pair<T>
	 */
	public static  Optional<Pair<?>> parsePair(String s, char separator) {
		final Pattern pattern = Pattern.compile("(-?[0-9]+.?[0-9]*)" + String.valueOf(separator) + "(-?[0-9]+.?[0-9]*)");

		Matcher m = pattern.matcher(s);

		if (m.matches() && m.groupCount() == 2) {
			String x = m.group(1);
			String y = m.group(2);

			if (x.contains(".") || y.contains(".")) {
				return Optional.of(Pair.of(Double.parseDouble(x), Double.parseDouble(y)));
			} else {
				return Optional.of(Pair.of(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
			}
		}

		return Optional.empty();
	}
}
