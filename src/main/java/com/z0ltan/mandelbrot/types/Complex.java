package com.z0ltan.mandelbrot.types;

import java.io.Serializable;
import java.text.MessageFormat;

import com.z0ltan.mandelbrot.core.Constants;

public class Complex<T extends Number> implements Serializable {
	private static final long serialVersionUID = -7914656203786920758L;

	private T real;
	private T imaginary;

	public T getReal() {
		return real;
	}

	public void setReal(T real) {
		this.real = real;
	}

	public T getImaginary() {
		return imaginary;
	}

	public void setImaginary(T imaginary) {
		this.imaginary = imaginary;
	}

	public Complex(T real, T imaginary) {
		super();
		this.real = real;
		this.imaginary = imaginary;
	}

	public Complex() {

	}

	// Operations
	@SuppressWarnings("unchecked")
	public Complex<T> add(Complex<T> c) {
		Complex<T> sum = null;
		Class<?> clazz = c.getReal().getClass();

		if (clazz == Double.class) {
			sum = (Complex<T>) new Complex<Double>(this.real.doubleValue() + c.getReal().doubleValue(),
					this.imaginary.doubleValue() + c.getImaginary().doubleValue());
		} else if (clazz == Float.class) {
			sum = (Complex<T>) new Complex<Float>(this.real.floatValue() + c.getReal().floatValue(),
					this.imaginary.floatValue() + c.getImaginary().floatValue());
		} else if (clazz == Integer.class) {
			sum = (Complex<T>) new Complex<Integer>(this.real.intValue() + c.getReal().intValue(),
					this.imaginary.intValue() + c.getImaginary().intValue());

		} else if (clazz == Long.class) {
			sum = (Complex<T>) new Complex<Long>(this.real.longValue() + c.getReal().longValue(),
					this.imaginary.longValue() + c.getImaginary().longValue());

		} else if (clazz == Short.class) {
			short real = (short) (this.real.shortValue() + c.getReal().shortValue());
			short imag = (short) (this.imaginary.shortValue() + c.getImaginary().shortValue());

			sum = (Complex<T>) new Complex<Short>(real, imag);
		} else if (clazz == Byte.class) {
			byte real = (byte) (this.real.shortValue() + c.getReal().shortValue());
			byte imag = (byte) (this.imaginary.shortValue() + c.getImaginary().shortValue());

			sum = (Complex<T>) new Complex<Byte>(real, imag);
		}
		return sum;
	}

	@SuppressWarnings("unchecked")
	public Complex<T> sub(Complex<T> c) {
		Complex<T> diff = null;
		Class<?> clazz = c.getReal().getClass();

		if (clazz == Double.class) {
			diff = (Complex<T>) new Complex<Double>(this.real.doubleValue() - c.getReal().doubleValue(),
					this.imaginary.doubleValue() - c.getImaginary().doubleValue());
		} else if (clazz == Float.class) {
			diff = (Complex<T>) new Complex<Float>(this.real.floatValue() - c.getReal().floatValue(),
					this.imaginary.floatValue() - c.getImaginary().floatValue());
		} else if (clazz == Integer.class) {
			diff = (Complex<T>) new Complex<Integer>(this.real.intValue() - c.getReal().intValue(),
					this.imaginary.intValue() - c.getImaginary().intValue());

		} else if (clazz == Long.class) {
			diff = (Complex<T>) new Complex<Long>(this.real.longValue() - c.getReal().longValue(),
					this.imaginary.longValue() - c.getImaginary().longValue());

		} else if (clazz == Short.class) {
			short real = (short) (this.real.shortValue() - c.getReal().shortValue());
			short imag = (short) (this.imaginary.shortValue() - c.getImaginary().shortValue());

			diff = (Complex<T>) new Complex<Short>(real, imag);
		} else if (clazz == Byte.class) {
			byte real = (byte) (this.real.shortValue() - c.getReal().shortValue());
			byte imag = (byte) (this.imaginary.shortValue() - c.getImaginary().shortValue());

			diff = (Complex<T>) new Complex<Byte>(real, imag);
		}
		return diff;
	}

	@SuppressWarnings("unchecked")
	public Complex<T> mul(Complex<T> c) {
		Complex<T> prod = null;
		Class<?> clazz = c.getReal().getClass();

		if (clazz == Double.class) {
			double real = this.real.doubleValue() * c.getReal().doubleValue()
					- this.imaginary.doubleValue() * c.getImaginary().doubleValue();
			double imag = this.real.doubleValue() * c.getImaginary().doubleValue()
					+ this.imaginary.doubleValue() * c.getReal().doubleValue();

			prod = (Complex<T>) new Complex<Double>(real, imag);
		} else if (clazz == Float.class) {
			int real = this.real.intValue() * c.getReal().intValue()
					- this.imaginary.intValue() * c.getImaginary().intValue();
			int imag = this.real.intValue() * c.getImaginary().intValue()
					+ this.imaginary.intValue() * c.getReal().intValue();

			prod = (Complex<T>) new Complex<Integer>(real, imag);
		} else if (clazz == Integer.class) {
			double real = this.real.doubleValue() * c.getReal().doubleValue()
					- this.imaginary.doubleValue() * c.getImaginary().doubleValue();
			double imag = this.real.doubleValue() * c.getImaginary().doubleValue()
					+ this.imaginary.doubleValue() * c.getReal().doubleValue();

			prod = (Complex<T>) new Complex<Double>(real, imag);
		} else if (clazz == Long.class) {
			long real = this.real.longValue() * c.getReal().longValue()
					- this.imaginary.longValue() * c.getImaginary().longValue();
			long imag = this.real.longValue() * c.getImaginary().longValue()
					+ this.imaginary.longValue() * c.getReal().longValue();

			prod = (Complex<T>) new Complex<Long>(real, imag);
		} else if (clazz == Short.class) {
			short real = (short) (this.real.shortValue() * c.getReal().shortValue()
					- this.imaginary.shortValue() * c.getImaginary().shortValue());
			short imag = (short) (this.real.shortValue() * c.getImaginary().shortValue()
					+ this.imaginary.shortValue() * c.getReal().shortValue());

			prod = (Complex<T>) new Complex<Short>(real, imag);
		} else if (clazz == Byte.class) {
			byte real = (byte) (this.real.byteValue() * c.getReal().byteValue()
					- this.imaginary.byteValue() * c.getImaginary().byteValue());
			byte imag = (byte) (this.real.byteValue() * c.getImaginary().byteValue()
					+ this.imaginary.byteValue() * c.getReal().byteValue());

			prod = (Complex<T>) new Complex<Byte>(real, imag);
		}

		return prod;
	}

	public double normSquare() {
		double r = 0.0;

		Class<?> clazz = this.getReal().getClass();

		if (clazz == Double.class) {
			double real = this.real.doubleValue();
			double imag = this.imaginary.doubleValue();

			r = real * real + imag * imag;
		} else if (clazz == Float.class) {
			float real = this.real.floatValue();
			float imag = this.imaginary.floatValue();

			r = (double)(real * real + imag * imag);

		} else if (clazz == Integer.class) {
			int real = this.real.intValue();
			int imag = this.imaginary.intValue();

			r = (double)(real * real + imag * imag);
		} else if (clazz == Long.class) {
			long real = this.real.longValue();
			long imag = this.imaginary.longValue();

			r = Math.sqrt(real * real + imag * imag);
		} else if (clazz == Short.class) {
			short real = this.real.shortValue();
			short imag = this.imaginary.shortValue();

			r = (double)(real * real + imag * imag);
		} else if (clazz == Byte.class) {
			byte real = this.real.byteValue();
			byte imag = this.imaginary.byteValue();

			r = (double)(real * real + imag * imag);
		}

		return r;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Complex)) {
			return false;
		}

		@SuppressWarnings("unchecked")
		Complex<T> c = (Complex<T>) other;

		if (this.real.getClass() != c.getReal().getClass()) {
			return false;
		}

		Class<?> clazz = this.getReal().getClass();

		// add tolerance levels for Double and Float types
		if (clazz == Byte.class || clazz == Short.class || clazz == Long.class || clazz == Integer.class) {
			return this.getReal() == c.getReal() && this.imaginary == c.getImaginary();
		} else if (clazz == Double.class) {
			return Math.abs(this.real.doubleValue() - c.getReal().doubleValue()) < Constants.EPS
					&& Math.abs(this.imaginary.doubleValue() - c.getImaginary().doubleValue()) < Constants.EPS;
		} else {
			return Math.abs(this.real.floatValue() - c.getReal().floatValue()) < Constants.EPS
					&& Math.abs(this.imaginary.floatValue() - c.getImaginary().floatValue()) < Constants.EPS;
		}
	}

	@Override
	public int hashCode() {
		return this.real.hashCode() + this.imaginary.hashCode();
	}

	@Override
	public String toString() {
		Class<?> clazz = this.real.getClass();

		MessageFormat formatter = new MessageFormat("Complex ( real : {0}, imag: {1} )");
		String string = null;

		if (clazz == Double.class) {
			string = formatter.format(new Double[] { this.real.doubleValue(), this.imaginary.doubleValue() });
		} else if (clazz == Float.class) {
			string = formatter.format(new Float[] { this.real.floatValue(), this.imaginary.floatValue() });
		} else if (clazz == Integer.class) {
			string = formatter.format(new Integer[] { this.real.intValue(), this.imaginary.intValue() });
		} else if (clazz == Long.class) {
			string = formatter.format(new Long[] { this.real.longValue(), this.imaginary.longValue() });
		} else if (clazz == Short.class) {
			string = formatter.format(new Short[] { this.real.shortValue(), this.imaginary.shortValue() });
		} else if (clazz == Byte.class) {
			string = formatter.format(new Byte[] { this.real.byteValue(), this.imaginary.byteValue() });
		}

		return string;
	}
}
