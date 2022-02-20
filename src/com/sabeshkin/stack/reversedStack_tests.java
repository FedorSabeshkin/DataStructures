package com.sabeshkin.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class reversedStack_tests {

	@Test
	public void test_cyclePush_cyclePop_cyclePush_cyclePop_sizeIsZero() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		for (int i = 0; i < 6; i++){
			reversedStack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			reversedStack.pop();
		}
		for (int i = 6; i < 10; i++){
			reversedStack.push(new Integer(i));
		}
		for (int i = 0; i < 7; i++){
			reversedStack.pop();
		}
		assertEquals(
				0,
				reversedStack.size());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_seventhPopIsZero() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		for (int i = 0; i < 6; i++){
			reversedStack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			reversedStack.pop();
		}
		for (int i = 6; i < 10; i++){
			reversedStack.push(new Integer(i));
		}
		for (int i = 0; i < 6; i++){
			reversedStack.pop();
		}
		assertEquals(
				new Integer(0),
				reversedStack.pop());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_eightPopIsNull() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		for (int i = 0; i < 6; i++){
			reversedStack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			reversedStack.pop();
		}
		for (int i = 6; i < 10; i++){
			reversedStack.push(new Integer(i));
		}
		for (int i = 0; i < 7; i++){
			reversedStack.pop();
		}
		assertEquals(
				null,
				reversedStack.pop());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_sizeIsEight() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		for (int i = 0; i < 6; i++){
			reversedStack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			reversedStack.pop();
		}
		for (int i = 6; i < 10; i++){
			reversedStack.push(new Integer(i));
		}
		assertEquals(
				7,
				reversedStack.size());
	}

	@Test
	public void test_cyclePush_cyclePop_cyclePush_popIsEight() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		for (int i = 0; i < 6; i++){
			reversedStack.push(new Integer(i));
		}
		for (int i = 0; i < 3; i++){
			reversedStack.pop();
		}
		for (int i = 6; i < 10; i++){
			reversedStack.push(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				reversedStack.pop());
	}

	@Test
	public void test_integer_secondPopIsEight() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		for (int i = 0; i < 10; i++){
			reversedStack.push(new Integer(i));
		}
		reversedStack.pop();
		assertEquals(
				new Integer(8),
				reversedStack.pop());
	}

	@Test
	public void test_integer_popIsNine() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		for (int i = 0; i < 10; i++){
			reversedStack.push(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				reversedStack.pop());
	}

	@Test
	public void test_integer_peekIsNine() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		for (int i = 0; i < 10; i++){
			reversedStack.push(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				reversedStack.peek());
	}

	@Test
	public void test_emptyReversedStack_sizeIsZero() {
		ReversedStack reversedStack = new ReversedStack();
		assertEquals(
				0,
				reversedStack.size());
	}

	@Test
	public void test_emptyReversedStack_secondPopEqualNull() {
		ReversedStack reversedStack = new ReversedStack();
		reversedStack.pop();
		assertEquals(
				null,
				reversedStack.pop());
	}

	@Test
	public void test_emptyReversedStack_popEqualNull() {
		ReversedStack<?> reversedStack = new ReversedStack<Object>();
		assertEquals(
				null,
				reversedStack.pop());
	}

	@Test
	public void test_emptyReversedStack_peekEqualNull() {
		ReversedStack<?> reversedStack = new ReversedStack<Object>();
		assertEquals(
				null,
				reversedStack.peek());
	}

	@Test
	public void test_integer_onlyOneElement() {
		ReversedStack<Integer> reversedStack = new ReversedStack<Integer>();
		reversedStack.push(new Integer(0));
		assertEquals(
				new Integer(0),
				reversedStack.peek());
	}

	@Test
	public void test_string() {
		ReversedStack<Comparable> reversedStack = new ReversedStack<Comparable>();
		reversedStack.push(new Integer(0));
		reversedStack.push(new String("test"));
		assertEquals(
				new String("test"),
				reversedStack.peek());
	}

}
