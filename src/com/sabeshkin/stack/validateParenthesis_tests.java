package com.sabeshkin.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class validateParenthesis_tests {
	
	@Test
	public void test_sixth_isFalse() {
		Stack stack = new Stack();
		String string = new String("())(");
		assertEquals(
				false,
				stack.parenthesisValidator(string, stack));
	}

	@Test
	public void test_isFalse() {
		Stack stack = new Stack();
		String string = new String("())(");
		assertEquals(
				false,
				stack.parenthesisValidator(string, stack));
	}
	
	@Test
	public void test_second_isFalse() {
		Stack stack = new Stack();
		String string = new String("))((");
		assertEquals(
				false,
				stack.parenthesisValidator(string, stack));
	}
	
	@Test
	public void test_third_isFalse() {
		Stack stack = new Stack();
		String string = new String("((())");
		assertEquals(
				false,
				stack.parenthesisValidator(string, stack));
	}
	
	@Test
	public void test_fourth_isTrue() {
		Stack stack = new Stack();
		String string = new String("(()((())()))");
		assertEquals(
				true,
				stack.parenthesisValidator(string, stack));
	}
	
	@Test
	public void test_fifth_isTrue() {
		Stack stack = new Stack();
		String string = new String("()");
		assertEquals(
				true,
				stack.parenthesisValidator(string, stack));
	}
	
	@Test
	public void test_together_isTrue() {
		Stack stack = new Stack();
		String string = new String("()()");
		assertEquals(
				true,
				stack.parenthesisValidator(string, stack));
	}


}
