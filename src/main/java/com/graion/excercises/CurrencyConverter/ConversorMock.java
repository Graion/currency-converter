package com.graion.excercises.CurrencyConverter;

public class ConversorMock implements Conversor {

	public double getRate(Currency from, Currency to) {
		if (from == Currency.USD) return 10;
		if (from == Currency.ARS) return 0.1;
		return 1;
	}

}
