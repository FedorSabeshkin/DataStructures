package com.sabeshkin.queue;

import java.util.*;

public class Queue<T> {
	private LinkedList<T> queue;

	public Queue() {
		queue = new LinkedList<>();
	}

	/**
	 * add in tail
	 * o(1)
	 * @param T item
	 */
	public void enqueue(T item) {
		queue.add(item);
	}
	
	/**
	 * get from the head
	 * o(1)
	 * @return T item
	 */
	public T dequeue() {
		return queue.pollFirst();
	}

	/**
	 * get the size
	 * o(1)
	 * @return int size
	 */
	public int size() {
		return queue.size(); 
	}

}