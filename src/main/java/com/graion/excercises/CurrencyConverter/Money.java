package com.graion.excercises.CurrencyConverter;

public class Money {

	private double amount;
	private Currency currency;

	public Money(double amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Money multiply(int factor) {
		return new Money(this.amount * factor, this.currency);
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + amount;
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return (int) result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount != other.amount)
			return false;
		if (currency != other.currency)
			return false;
		return true;
	}

	public Money convertTo(Currency currency, Converter converter) {
		return new Money(amount * converter.getRate(this.currency, currency), currency);
	}
}
