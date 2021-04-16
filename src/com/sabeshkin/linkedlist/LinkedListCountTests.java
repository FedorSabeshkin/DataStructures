package com.sabeshkin.linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
