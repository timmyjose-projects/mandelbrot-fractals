package com.z0ltan.mandelbrot.types;

import com.z0ltan.mandelbrot.core.Constants;

public class Pair<T extends Number> {
	public T first;
	public T second;

	private Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public static <T extends Number> Pair<T> of(T first, T second) {
		return new Pair<>(first, second);
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}

		@SuppressWarnings("unchecked")
		Pair<T> p = (Pair<T>) other;

		if (p.first.getClass() == Double.class) {
			return Math.abs(this.first.doubleValue() - p.first.doubleValue()) < Constants.EPS
					&& Math.abs(this.second.doubleValue() - p.second.doubleValue()) < Constants.EPS;
		} else if (p.first.getClass() == Float.class) {
			return Math.abs(this.first.floatValue() - p.first.floatValue()) < Constants.EPS
					&& Math.abs(this.second.floatValue() - p.second.floatValue()) < Constants.EPS;
		}

		return this.first == p.first && this.second == p.second;
	}

	@Override
	public int hashCode() {
		return this.first.hashCode() + this.second.hashCode();
	}
}
