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
    
    public void testPesoMultiplication () {
    		assertEquals(new Peso(30), new Peso(10).times(3));
    }
}
