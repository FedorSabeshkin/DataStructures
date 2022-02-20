package com.sabeshkin.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QueueOnStacks_Tests {

	@Test
	public void test_enqueue() {
		QueueOnStacks<Integer> queue = new QueueOnStacks<Integer>();
		for (int i = 0; i < 10; i++){
			queue.enqueue(new Integer(i));
		}
		assertEquals(
				new Integer(0),
				queue.dequeue());
	}

	@Test
	public void test_dequeue() {
		QueueOnStacks<Integer> queue = new QueueOnStacks<Integer>();
		for (int i = 0; i < 10; i++){
			queue.enqueue(new Integer(i));
		}
		for (int i = 0; i < 5; i++){
			queue.dequeue();
		}
		assertEquals(
				new Integer(5),
				queue.dequeue());
	}
	
	@Test
	public void test_size() {
		QueueOnStacks<Integer> queue = new QueueOnStacks<Integer>();
		for (int i = 0; i < 10; i++){
			queue.enqueue(new Integer(i));
		}
		assertEquals(
				10,
				queue.size());
	}
	
	@Test
	public void test_size_afterFiveDequeue_isFive() {
		QueueOnStacks<Integer> queue = new QueueOnStacks<Integer>();
		for (int i = 0; i < 10; i++){
			queue.enqueue(new Integer(i));
		}
		for (int i = 0; i < 5; i++){
			queue.dequeue();
		}
		assertEquals(
				5,
				queue.size());
	}

}
