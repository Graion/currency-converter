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
    
    public void testMoneyMultiplication () {
    		assertEquals(new Money(10, Currency.ARS).times(3), new Money(30, Currency.ARS));
    }
    
    public void testMoneyEquality () {
    		assertFalse(new Money(10, Currency.ARS).equals(new Money(10, Currency.USD)));
    		assertFalse(new Money(10, Currency.ARS).equals(new Money(15, Currency.ARS)));
    }
    
    public void testMoneyConversion () {
    		Conversor conversor = new ConversorMock();
    		assertEquals(new Money(10, Currency.ARS).convertTo(Currency.USD, conversor), new Money(1, Currency.USD));
    		assertEquals(new Money(10, Currency.USD).convertTo(Currency.ARS, conversor), new Money(100, Currency.ARS));
    }
    
    public void testMoneyAddition () {
    		assertEquals(new Money(10, Currency.ARS).plus(new Money(10, Currency.ARS)),
    				new Sum(new Money(10, Currency.ARS), new Money(10, Currency.ARS)));
    		assertEquals(new Money(10, Currency.ARS).plus(new Money(10, Currency.USD)),
    				new Sum(new Money(10, Currency.ARS), new Money(10, Currency.USD)));
    }
}
