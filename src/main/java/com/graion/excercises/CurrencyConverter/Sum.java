package com.graion.excercises.CurrencyConverter;

public class Sum {
	private Money addend;
	private Money augend;

	public Sum (Money addend, Money augend) {
		this.addend = addend;
		this.augend = augend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addend == null) ? 0 : addend.hashCode());
		result = prime * result + ((augend == null) ? 0 : augend.hashCode());
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
		Sum other = (Sum) obj;
		if (addend == null) {
			if (other.addend != null)
				return false;
		} else if (!addend.equals(other.addend))
			return false;
		if (augend == null) {
			if (other.augend != null)
				return false;
		} else if (!augend.equals(other.augend))
			return false;
		return true;
	}
}
