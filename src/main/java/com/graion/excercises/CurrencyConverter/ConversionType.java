package com.graion.excercises.CurrencyConverter;

public class ConversionType {
	
	private Currency from;
	private Currency to;

	public ConversionType(Currency from, Currency to) {
		super();
		this.from = from;
		this.to = to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		ConversionType other = (ConversionType) obj;
		return from.equals(other.from) && to.equals(other.to); 
	}

}
