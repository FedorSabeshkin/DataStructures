package com.sabeshkin.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class stack_tests {

	@Test
	public void test_cyclePush_cyclePop_cyclePush_cyclePop_sizeIsZero() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 7; i++){
			stack.pop();
		}
		assertEquals(
				0,
				stack.size());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_seventhPopIsZero() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 6; i++){
			stack.pop();
		}
		assertEquals(
				new Integer(0),
				stack.pop());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_eightPopIsNull() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 7; i++){
			stack.pop();
		}
		assertEquals(
				null,
				stack.pop());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_sizeIsEight() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		assertEquals(
				7,
				stack.size());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_popIsEight() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 6; i++){
			stack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			stack.pop();
		}
		for (int i = 6; i < 10; i++){
			stack.push(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				stack.pop());
	}

	@Test
	public void test_integer_secondPopIsEight() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10; i++){
			stack.push(new Integer(i));
		}
		stack.pop();
		assertEquals(
				new Integer(8),
				stack.pop());
	}

	@Test
	public void test_integer_popIsNine() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10; i++){
			stack.push(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				stack.pop());
	}

	@Test
	public void test_integer_peekIsNine() {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 10; i++){
			stack.push(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				stack.peek());
	}

	@Test
	public void test_emptyStack_sizeIsZero() {
		Stack stack = new Stack();
		assertEquals(
				0,
				stack.size());
	}

	@Test
	public void test_emptyStack_secondPopEqualNull() {
		Stack stack = new Stack();
		stack.pop();
		assertEquals(
				null,
				stack.pop());
	}

	@Test
	public void test_emptyStack_popEqualNull() {
		Stack<?> stack = new Stack<Object>();
		assertEquals(
				null,
				stack.pop());
	}

	@Test
	public void test_emptyStack_peekEqualNull() {
		Stack<?> stack = new Stack<Object>();
		assertEquals(
				null,
				stack.peek());
	}

	@Test
	public void test_integer_onlyOneElement() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(new Integer(0));
		assertEquals(
				new Integer(0),
				stack.peek());
	}

	@Test
	public void test_string() {
		Stack<Comparable> stack = new Stack<Comparable>();
		stack.push(new Integer(0));
		stack.push(new String("test"));
		assertEquals(
				new String("test"),
				stack.peek());
	}

}
