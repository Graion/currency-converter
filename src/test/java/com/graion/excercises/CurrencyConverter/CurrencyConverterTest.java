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

    //(10ARS + 5USD) * 3 = 18USD
    
    public void testScalarProductPeso(){
    	assertEquals(new Money(30, Currency.ARS), new Money(10, Currency.ARS).multiply(3));
    }
    
    public void testScalarProductDollar(){
    	assertEquals(new Money(30, Currency.USD), new Money(10, Currency.USD).multiply(3));
    }
    
    public void testMoneyEquality(){
    	assertFalse(new Money(10, Currency.ARS).equals(new Money(10, Currency.USD)));
    	assertFalse(new Money(10, Currency.ARS).equals(new Money(30, Currency.ARS)));
    }
}
