package com.graion.excercises.CurrencyConverter;

public class Money extends Expression {

	public static Money dollar(int amount) {
		return new Money(amount, Currency.USD);
	}
	public static Money pesos(int amount) {
		return new Money(amount, Currency.ARS);
	}

	private double amount;
	private Currency currency;

	public Money(double amount, Currency currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}

	public double amount() {
		return this.amount;
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
		return amount == other.amount && currency == other.currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + amount;
		return (int)result;
	}
	
	public Sum plus(Money addend) {
		return new Sum(this, addend);
	}

	public Money reduce(Bank bank, Currency to) {
		double rate = bank.getRate(this.currency, to);
		return new Money(this.amount / rate, to);
	}

	public Expression times(int multiplier) {
		return new Money(this.amount * multiplier, this.currency);
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
}
