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

    // Exercise: (3 * 10 ARS) + 5 USD = 8USD
    public void testScalarProductMoney(){
    	assertEquals(new Money(30, Currency.ARS), new Money(10, Currency.ARS).multiply(3));
    	assertEquals(new Money(30, Currency.USD), new Money(10, Currency.USD).multiply(3));
    }
    
    public void testMoneyEquality(){
    	assertFalse(new Money(10, Currency.ARS).equals(new Money(10, Currency.USD)));
    	assertFalse(new Money(10, Currency.ARS).equals(new Money(30, Currency.ARS)));
    }
    
    public void testMoneyConversion(){
    	Converter converter = new ConverterMock();
    	assertEquals(new Money(30, Currency.ARS), new Money(3, Currency.USD).convertTo(Currency.ARS, converter));
    	assertEquals(new Money(3, Currency.USD), new Money(30, Currency.ARS).convertTo(Currency.USD, converter));
    }
}
