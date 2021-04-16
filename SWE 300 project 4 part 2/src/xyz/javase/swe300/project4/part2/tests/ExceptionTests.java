package xyz.javase.swe300.project4.part2.tests;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xyz.javase.swe300.project4.part2.ConvertingMachine;


public class ExceptionTests {
	

	private ConvertingMachine m = new ConvertingMachine();

	@Test
	public void testInt() {
		int testValue = 1;
		double test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = 12;
		test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = 8234167;
		test = m.parse("" + testValue);
		assertTrue(testValue == test);
	}
	
	
	@Test
	public void testNegative() {
		double testValue = -1;
		double test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = -12;
		test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = -8234167;
		test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = -82.167;
		test = m.parse("" + testValue);
		assertTrue(testValue == test);
	}	
	
	
	@Test
	public void testDecimal() {
		double testValue = .1;
		double test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = .12;
		test = m.parse("" + testValue);
		System.out.println("@DEBUG " + test + " " + testValue);
		assertEquals(testValue, test,  0.001);
		
		testValue = 1.12;
		test = m.parse("" + testValue);
		assertEquals(testValue, test,  0.001);
		
		testValue = .8234167;
		test = m.parse("" + testValue);
		assertEquals(testValue, test,  0.001);		
	}
	
	
	@Test
	public void testPositive() {
		double testValue = +1;
		double test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = +12;
		test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = +8234167;
		test = m.parse("" + testValue);
		assertTrue(testValue == test);
		
		testValue = +82.167;
		test = m.parse("" + testValue);
		assertTrue(testValue == test);
	}
	
	
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter()
	{
		String testValue = "+1e";
		double test = m.parse(testValue);
	}
	
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter2()
	{
		String testValue = "01+2";
		double test = m.parse(testValue);
	}
	
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter3()
	{
		String testValue = "reg";
		double test = m.parse(testValue);
	}	
	
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter4()
	{
		String testValue = "";
		double test = m.parse(testValue);
	}
	
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter5()
	{
		String testValue = "1-04";
		double test = m.parse(testValue);
	}
	
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter6()
	{
		String testValue = "\0";
		double test = m.parse(testValue);
	}
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter7()
	{
		String testValue = ".e";
		double test = m.parse(testValue);
	}
	
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter8()
	{
		String testValue = "1.e";
		double test = m.parse(testValue);
	}
	
	/**
	 * if it isn't a number, we should see the exception
	 */
	@Test(expected = NumberFormatException.class)
	public void illegalCharacter9()
	{
		String testValue = ".1-04";
		double test = m.parse(testValue);
	}
	
	
//	@Test
//	public void testBadInput() {
//		Context context = new Context();
//		String testValue = "+1e";
//		double test = context.parse(testValue);
//		assertTrue(0 == test);
//		
//		testValue = "01+2";
//		test = context.parse(testValue);
//		assertTrue(0 == test);
//		
//		testValue = "reg";
//		test = context.parse(testValue);
//		assertTrue(0 == test);
//
//		testValue = "";
//		test = context.parse(testValue);
//		assertTrue(0 == test);
//		
//		testValue = "1-04";
//		test = context.parse(testValue);
//		assertTrue(0 == test);
//		
//		testValue = "\0";
//		test = context.parse(testValue);
//		assertTrue(0 == test);
//		
//		testValue = ".e";
//		test = context.parse(testValue);
//		assertTrue(0 == test);	
//		
//		testValue = "1.e";
//		test = context.parse(testValue);
//		assertTrue(0 == test);
//		
//		testValue = ".1-04";
//		test = context.parse(testValue);
//		assertTrue(0 == test);
//	}
	

	
}
