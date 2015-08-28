package com.graion.excercises.CurrencyConverter;

public class Peso {

	private int amount;

	public Peso(int amount) {
		this.amount = amount;
	}

	public Peso times(int scalar) {
		return new Peso(this.amount * scalar);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peso other = (Peso) obj;
		if (amount != other.amount)
			return false;
		return true;
	}
}
