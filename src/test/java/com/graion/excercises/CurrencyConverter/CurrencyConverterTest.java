package com.graion.excercises.CurrencyConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CurrencyConverterTest extends TestCase
{
	Money fiveDollars;
	Bank bank;
	
    public CurrencyConverterTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( CurrencyConverterTest.class );
    }
    
    public void setUp() {
    	fiveDollars = Money.dollar(5);
    	bank = new Bank();
    	bank.addRate(Currency.ARS, Currency.USD, 10);
    	bank.addRate(Currency.USD, Currency.ARS, 0.1);
    }
    
    public void testMoneyMultiplication()
    {
    	assertEquals(new Money(5 * 3, Currency.USD), fiveDollars.times(3));
    	assertEquals(new Money(5 * 4, Currency.USD), fiveDollars.times(4));
    }
    
    public void testEquality() {
    	assertEquals(new Money(5, Currency.USD), new Money(5, Currency.USD));
    	assertNotSame(new Money(5, Currency.USD), new Money(6, Currency.USD));
    	assertEquals(new Money(5, Currency.ARS), new Money(5, Currency.ARS));
    	assertNotSame(new Money(5, Currency.USD), new Money(5, Currency.ARS));
    }
    
    public void testMoneyAddition()
    {
    	Sum sum = fiveDollars.plus(fiveDollars);
    	Bank bank = new Bank();
    	Money reducedSum = bank.convert(sum, Currency.USD);
    	assertEquals(Money.dollar(10), reducedSum);
    }
    
    public void testMultiCurrencyAdditionUSD()
    {
    	Money tenPesos = Money.pesos(100);
    	Sum sum = fiveDollars.plus(tenPesos);
    	Money reducedSum = bank.convert(sum, Currency.USD);
    	assertEquals(Money.dollar(5 + 100 / 10), reducedSum);
    }
    
    public void testMultiCurrencyAdditionARS()
    {
    	Money tenPesos = Money.pesos(100);
    	Sum sum = fiveDollars.plus(tenPesos);
    	Money reducedSum = bank.convert(sum, Currency.ARS);
    	assertEquals(Money.pesos(5 * 10 + 100), reducedSum);
    }
    
    public void testAdditionReturnsSum()
    {
    	Sum sum = fiveDollars.plus(fiveDollars);
    	assertEquals(sum, new Sum(fiveDollars, fiveDollars));
    }
    
    public void testMoneyConversion()
    {
    	Money fiftyPesos = Money.pesos(50);
    	assertEquals(Money.dollar(5), bank.convert(fiftyPesos, Currency.USD));
    }
    
    public void testSumReduction()
    {
    	Money fiftyPesos = Money.pesos(50);
    	Sum sum = fiftyPesos.plus(fiftyPesos);
    	assertEquals(Money.dollar(10), sum.reduce(bank, Currency.USD));
    }
    
    public void testSumTimes()
    {
    	Sum sum = fiveDollars.plus(fiveDollars);
    	assertEquals(Money.dollar(5 + 5).times(3), sum.times(3).reduce(bank, Currency.USD));
    }
    
    public void testSumTimesMultiCurrency()
    {
    	assertEquals(Money.pesos(5 * 10 + 10).times(2),
    			fiveDollars.plus(Money.pesos(10)).times(2).reduce(bank, Currency.ARS));
    }
    
    public void testMultiSums()
    {
    	assertEquals(Money.dollar(5 + 50 / 10 + 5),
    			fiveDollars.plus(Money.pesos(50)).plus(fiveDollars).reduce(bank, Currency.USD));
    }
}
