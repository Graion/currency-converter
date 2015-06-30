package com.graion.excercises.CurrencyConverter;

public class Sum implements Expression {
	
	public Expression augend;
	public Expression addend;

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

}
