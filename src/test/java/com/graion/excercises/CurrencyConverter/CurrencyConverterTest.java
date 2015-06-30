package com.graion.excercises.CurrencyConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CurrencyConverterTest extends TestCase
{
    public CurrencyConverterTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( CurrencyConverterTest.class );
    }

    public void testMoneyAddition()
    {
    	Money five = Money.dollar(5);
    	Sum sum = five.plus(five);
    	Bank bank = new Bank();
    	Money reducedSum = bank.convert(sum, Currency.USD);
    	assertEquals(Money.dollar(10), reducedSum);
    }
    
    public void testMoneyMultiplication()
    {
    	Money five = new Money(5, Currency.USD);
    	assertEquals(new Money(5 * 3, Currency.USD), five.times(3));
    	assertEquals(new Money(5 * 4, Currency.USD), five.times(4));
    }
    
    public void testEquality() {
    	assertEquals(new Money(5, Currency.USD), new Money(5, Currency.USD));
    	assertNotSame(new Money(5, Currency.USD), new Money(6, Currency.USD));
    	assertEquals(new Money(5, Currency.ARS), new Money(5, Currency.ARS));
    	assertNotSame(new Money(5, Currency.USD), new Money(5, Currency.ARS));
    }
    
    public void testMultiCurrencyAddition()
    {
    	Money five = Money.dollar(5);
    	Money tenPesos = Money.pesos(100);
    	Sum sum = five.plus(tenPesos);
    	Bank bank = new Bank();
    	bank.addRate(Currency.ARS, Currency.USD, 10);
    	Money reducedSum = bank.convert(sum, Currency.USD);
    	assertEquals(Money.dollar(5 + 100 / 10), reducedSum);
    }
    
    public void testAdditionReturnsSum()
    {
    	Money five = Money.dollar(5);
    	Sum sum = five.plus(five);
    	assertEquals(sum.augend, five);
    	assertEquals(sum.addend, five);
    }
    
    public void testCurrencyConversion()
    {
    	Money fivePesos = Money.pesos(50);
    	Bank bank = new Bank();
    	bank.addRate(Currency.ARS, Currency.USD, 10);
    	assertEquals(Money.dollar(5), bank.convert(fivePesos, Currency.USD));
    }
    
    public void testSumTimes()
    {
    	Money five = Money.dollar(5);
    	Sum sum = five.plus(five);
    	Bank bank = new Bank();
    	bank.addRate(Currency.ARS, Currency.USD, 10);
    	assertEquals(Money.dollar(5 + 5).times(3), sum.times(3).reduce(bank, Currency.USD));
    }
}
