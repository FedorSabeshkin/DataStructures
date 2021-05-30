package com.sabeshkin.deque;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sabeshkin.queue.QueueOnStacks;

public class DequeTests {

	@Test
	public void addFront_test_removeFront_isNine() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++){
			deque.addFront(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				deque.removeFront());
	}

	@Test
	public void addFront_test_size_isTen() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++){
			deque.addFront(new Integer(i));
		}
		assertEquals(
				10,
				deque.size());
	}

	@Test
	public void addFront_test_removeFront_size_isTen() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++){
			deque.addFront(new Integer(i));
		}
		deque.removeFront();
		assertEquals(
				9,
				deque.size());
	}

	@Test
	public void addFront_test_removeFront_FiveTimes_size_isFive() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++){
			deque.addFront(new Integer(i));
		}
		for (int i = 0; i < 5; i++){
			deque.removeFront();
		}
		assertEquals(
				5,
				deque.size());
	}

	@Test
	public void addFront_test_removeTail_FiveTimes_size_isFive() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++){
			deque.addFront(new Integer(i));
		}
		for (int i = 0; i < 5; i++){
			deque.removeTail();
		}
		assertEquals(
				5,
				deque.size());
	}

	@Test
	public void addFront_test_removeTail_size_isNine() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++){
			deque.addFront(new Integer(i));
		}
		deque.removeTail();
		assertEquals(
				9,
				deque.size());
	}
	
	@Test
	public void addFront_test_removeTail_isZero() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++){
			deque.addFront(new Integer(i));
		}
		assertEquals(
				new Integer(0),
				deque.removeTail());
	}
	
	@Test
	public void addTail_test_removeTail_isNine() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++){
			deque.addTail(new Integer(i));
		}
		assertEquals(
				new Integer(9),
				deque.removeTail());
	}

}
