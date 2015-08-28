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
}
