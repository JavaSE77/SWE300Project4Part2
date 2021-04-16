package xyz.javase.swe300.project4.part2.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xyz.javase.swe300.project4.part2.Action;
import xyz.javase.swe300.project4.part2.ContinuingFactionAction;
import xyz.javase.swe300.project4.part2.ContinuingIntegerAction;
import xyz.javase.swe300.project4.part2.InterimResult;
import xyz.javase.swe300.project4.part2.NegateAction;
import xyz.javase.swe300.project4.part2.NoAction;
import xyz.javase.swe300.project4.part2.StartFraction;
import xyz.javase.swe300.project4.part2.ValueIsDigitAction;

public class ActionTest {

	@Test
	public void testContinuingFactionAction( ) {
		Action action = new ContinuingFactionAction();
		InterimResult x = new InterimResult(0.1, 1, 0);
		
		assertEquals(action.execute(x, '9').getV(), .9, 0.001);
		assertEquals(action.execute(x, '5').getV(), .95, 0.001);
		
	}
	
	
	@Test
	public void testContinuingIntegerAction( ) {
		Action action = new ContinuingIntegerAction();
		InterimResult x = new InterimResult(0.1, 1, 0);
		
		assertEquals(action.execute(x, '9').getV(), 9, 0.001);
		assertEquals(action.execute(x, '5').getV(), 95, 0.001);
		assertEquals(action.execute(x, '2').getV(), 952, 0.001);
	}
	
	
	@Test
	public void testValueIsDigitAction( ) {
		Action action = new ValueIsDigitAction();
		InterimResult x = new InterimResult(0.1, 1, 0);
		
		assertEquals(action.execute(x, '9').getV(), 9, 0.001);
		assertEquals(action.execute(x, '5').getV(), 14, 0.001);
		assertEquals(action.execute(x, '2').getV(), 16, 0.001);
	}
	
	
	@Test
	public void testNegateAction( ) {
		Action action = new NegateAction();
		InterimResult x = new InterimResult(0.1, 1, 0);
		
		assertEquals(action.execute(x, '-').getS(), -1, 0.001);
	}	
	
	
	@Test
	public void testNoAction( ) {
		Action action = new NoAction();
		InterimResult x = new InterimResult(0.1, 1, 0);
		
		assertEquals(action.execute(x, '-').getP(), .1, 0.001);
		assertEquals(action.execute(x, '-').getS(), 1, 0.001);
		assertEquals(action.execute(x, '-').getV(), 0, 0.001);
	}	
	
	
	@Test
	public void testStartFactionAction( ) {
		Action action = new StartFraction();
		InterimResult x = new InterimResult(0.1, 1, 0);
		
		assertEquals(action.execute(x, '.').getP(), .1, 0.001);
		assertEquals(action.execute(x, '.').getS(), 1, 0.001);
		assertEquals(action.execute(x, '.').getV(), 0, 0.001);
	}
	
}
