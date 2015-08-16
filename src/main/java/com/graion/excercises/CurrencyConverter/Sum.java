package com.graion.excercises.CurrencyConverter;

public class Sum extends Expression {
	
	private Expression augend;
	private Expression addend;

	public Sum(Expression augend, Expression addend) {
		super();
		this.augend = augend;
		this.addend = addend;
	}

	public Money reduce(Bank bank, Currency to)
	{
		return new Money(
				augend.reduce(bank, to).amount() +
				addend.reduce(bank, to).amount(),
				to);
	}

	public Expression times(int multiplier) {
		return new Sum(augend.times(multiplier), addend.times(multiplier));
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
