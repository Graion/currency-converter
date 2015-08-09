package com.graion.excercises.CurrencyConverter;

import java.util.Hashtable;

public class Bank {
	
	private Hashtable<ConversionType, Double> rates;
	
	public Bank() {
		super();
		this.rates = new Hashtable<ConversionType, Double>();
	}

	public Money convert(Expression expression, Currency to) {
		return expression.reduce(this, to);
	}

	public void addRate(Currency from, Currency to, double rate) {
		rates.put(new ConversionType(from, to), new Double(rate));
	}

	public double getRate(Currency from, Currency to) {
		if (from.equals(to)) return 1;
		return rates.get(new ConversionType(from, to)).doubleValue();
	}

}
