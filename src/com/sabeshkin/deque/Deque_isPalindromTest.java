package com.sabeshkin.deque;

import static org.junit.Assert.*;

import org.junit.Test;

public class Deque_isPalindromTest {

	@Test
	public void test() {
		assertEquals(
				true,
				Deque.isPalindrom("шалаш"));
	}
	
	@Test
	public void test_isFalse() {
		assertEquals(
				false,
				Deque.isPalindrom("room"));
	}
	
	@Test
	public void test_isTrue() {
		assertEquals(
				false,
				Deque.isPalindrom("Mr. Owl ate my metal worm"));
	}

}
