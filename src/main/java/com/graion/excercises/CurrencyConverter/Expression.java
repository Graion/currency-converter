package com.graion.excercises.CurrencyConverter;

public abstract class Expression {
	
	abstract Money reduce(Bank bank, Currency to);
	abstract Expression times(int multiplier);
	
	public Expression plus(Expression expression) {
		return new Sum(this, expression);
	}
}