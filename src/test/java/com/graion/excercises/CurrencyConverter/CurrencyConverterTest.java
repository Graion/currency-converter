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
    
    public Money newPeso(double amount) {
    	return new Money(amount, Currency.ARS);
    }
    
    public Money newDollar(double amount) {
    	return new Money(amount, Currency.USD);
    }
    
    public void testMoneyMultiplication () {
    		assertEquals(newPeso(10).times(3), newPeso(30));
    }
    
    public void testMoneyEquality () {
    		assertFalse(newPeso(10).equals(newDollar(10)));
    		assertFalse(newPeso(10).equals(newPeso(15)));
    }
    
    public void testMoneyConversion () {
    		Conversor conversor = new ConversorMock();
    		assertEquals(newPeso(10).convertTo(Currency.USD, conversor), newDollar(1));
    		assertEquals(newDollar(10).convertTo(Currency.ARS, conversor), newPeso(100));
    }
    
    public void testMoneyAddition () {
    		assertEquals(newPeso(10).plus(newPeso(10)),
    				new Sum(newPeso(10), newPeso(10)));
    		assertEquals(newPeso(10).plus(newDollar(10)),
    				new Sum(newPeso(10), newDollar(10)));
    }
    
    public void testMoneyMultipleAddition () {
//    		// 10 ARS + 10 ARS + 10 USD
//    		assertEquals(newPeso(10)
//    			.plus(newPeso(10))
//    			.plus(newDollar(10)),
//    			new Sum(new Sum(newPeso(10), newPeso(10)),
//    					newDollar(10));
    }
    
    public void testSumConversion () {
//    	Conversor conversor = new ConversorMock();
//    	// 10 ARS + 5 USD = 6 USD (10:1 -> ARS:USD)
//    	assertEquals(newPeso(10).plus(newDollar(5)).convertTo(Currency.USD, conversor), newDollar(6));
    }
    
    public void testMultipleExpressionConversion () {
//    	Conversor conversor = new ConversorMock();
//    	// (10 ARS + 5 USD) + 5 USD = 11 USD (10:1 -> ARS:USD)
//    	assertEquals(newPeso(10).plus(newDollar(5)).plus(newDollar(5)).convertTo(Currency.USD, conversor), newDollar(11));
//    	// (10 ARS + 5 USD) + 3 = 18 USD (10:1 -> ARS:USD)
//    	assertEquals(newPeso(10).plus(newDollar(5)).times(3).convertTo(Currency.USD, conversor), newDollar(18));
    }
}
