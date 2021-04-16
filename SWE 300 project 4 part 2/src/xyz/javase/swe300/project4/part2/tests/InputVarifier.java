package xyz.javase.swe300.project4.part2.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xyz.javase.swe300.project4.part2.DigitInputVerifier;
import xyz.javase.swe300.project4.part2.MinusInputVerifier;
import xyz.javase.swe300.project4.part2.PeriodInputVerifier;
import xyz.javase.swe300.project4.part2.PlusInputVerifier;


public class InputVarifier {

	@Test
	public void testDigitInputVerifier() {
		DigitInputVerifier verifier = new DigitInputVerifier();
		assertTrue(verifier.meetsCriteria('8'));
		assertTrue(verifier.meetsCriteria('5'));
		assertFalse(verifier.meetsCriteria('.'));
		assertFalse(verifier.meetsCriteria('g'));
	}
	

	@Test
	public void testMinusInputVerifier() {
		MinusInputVerifier verifier = new MinusInputVerifier();
		assertTrue(verifier.meetsCriteria('-'));
		assertFalse(verifier.meetsCriteria('4'));
		assertFalse(verifier.meetsCriteria('.'));
		assertFalse(verifier.meetsCriteria('g'));
	}	

	
	@Test
	public void testPeriodInputVerifier() {
		PeriodInputVerifier verifier = new PeriodInputVerifier();
		assertTrue(verifier.meetsCriteria('.'));
		assertFalse(verifier.meetsCriteria('4'));
		assertFalse(verifier.meetsCriteria('-'));
		assertFalse(verifier.meetsCriteria('g'));
	}
	
	
	@Test
	public void testPlusInputVerifier() {
		PlusInputVerifier verifier = new PlusInputVerifier();
		assertTrue(verifier.meetsCriteria('+'));
		assertFalse(verifier.meetsCriteria('4'));
		assertFalse(verifier.meetsCriteria('.'));
		assertFalse(verifier.meetsCriteria('g'));
	}
}
