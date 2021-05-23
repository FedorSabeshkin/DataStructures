package com.sabeshkin.queue;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sabeshkin.queue.Queue;

public class Queue_Tests {

	@Test
	public void test_cycle() {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 10; i++){
			queue.enqueue(new Integer(i));
		}
		queue.queueCycle(5);
		assertEquals(
				new Integer(5),
				queue.dequeue());
	}
	
	@Test
	public void test_full_cycle() {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 10; i++){
			queue.enqueue(new Integer(i));
		}
		queue.queueCycle(10);
		assertEquals(
				new Integer(0),
				queue.dequeue());
	}
	
	@Test
	public void test_fife_full_cycles() {
		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 10; i++){
			queue.enqueue(new Integer(i));
		}
		queue.queueCycle(50);
		assertEquals(
				new Integer(0),
				queue.dequeue());
	}

}
