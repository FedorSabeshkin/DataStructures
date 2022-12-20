package com.sabeshkin.linkedlist;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListCountTests {
	LinkedList linkedList;

	@Test
	public void testCountTen() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		assertEquals(
				10,
				linkedList.count());
	}

	@Test
	public void testCountOne() {
		linkedList = new LinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		assertEquals(
				1,
				linkedList.count());
	}

	@Test
	public void testCountZero() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.clear();
		assertEquals(
				0,
				linkedList.count());
	}
}
