package com.graion.excercises.CurrencyConverter;

public class ConverterMock implements Converter {

	public double getRate(Currency from, Currency to) {
		if (from == to) return 1;
		if (from == Currency.ARS) return 0.1;
		if (from == Currency.USD) return 10;
		return 0; //TODO: throw new Exception("Unknown Currency [from= " + from + ", to=" + to + "]");
	}

}
