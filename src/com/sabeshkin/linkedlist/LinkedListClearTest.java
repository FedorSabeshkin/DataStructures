package com.sabeshkin.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LinkedListClearTest {
	LinkedList linkedList;
	
	@Test
	public void testClear() {
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
	
	@Test
	public void testClearHeadIsNull() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.clear();
		assertEquals(
				null,
				linkedList.head);
	}
	
	@Test
	public void testClearTailIsNull() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.clear();
		assertEquals(
				null,
				linkedList.tail);
	}

}
