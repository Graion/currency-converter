package com.graion.excercises.CurrencyConverter;

public interface Expression {
	
	Money reduce(Bank bank, Currency to);
	Expression times(int multiplier);
	
}