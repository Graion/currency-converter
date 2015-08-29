package com.graion.excercises.CurrencyConverter;

public class Money {

	private double amount;
	private Currency currency;

	public Money(double amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Money times(int scalar) {
		return new Money(this.amount * scalar, this.currency);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + amount;
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
		if (amount != other.amount || currency != other.currency)
			return false;
		return true;
	}

	public Money convertTo(Currency toCurrency, Conversor conversor) {
		return new Money(this.amount * conversor.getRate(this.currency, toCurrency), toCurrency);
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

	public Sum plus(Money money) {
		return new Sum(this, money);
	}
}
