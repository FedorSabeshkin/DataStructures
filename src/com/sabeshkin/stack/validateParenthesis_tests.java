package com.sabeshkin.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class validateParenthesis_tests {
	
	@Test
	public void test_sixth_isFalse() {
		String string = new String("())(()");
		assertEquals(
				false,
				Stack.parenthesisValidator(string));
	}

	@Test
	public void test_isFalse() {
		String string = new String("())(");
		assertEquals(
				false,
				Stack.parenthesisValidator(string));
	}
	
	@Test
	public void test_second_isFalse() {
		String string = new String("))((");
		assertEquals(
				false,
				Stack.parenthesisValidator(string));
	}
	
	@Test
	public void test_third_isFalse() {
		String string = new String("((())");
		assertEquals(
				false,
				Stack.parenthesisValidator(string));
	}
	
	@Test
	public void test_fourth_isTrue() {
		String string = new String("(()((())()))");
		assertEquals(
				true,
				Stack.parenthesisValidator(string));
	}
	
	@Test
	public void test_fifth_isTrue() {
		String string = new String("()");
		assertEquals(
				true,
				Stack.parenthesisValidator(string));
	}
	
	@Test
	public void test_together_isTrue() {
		String string = new String("()()");
		assertEquals(
				true,
				Stack.parenthesisValidator(string));
	}


}
