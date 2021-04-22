package com.sabeshkin.linkedlist2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedList2ClearTest {
	LinkedList2 linkedList2;
	
	@Test
	public void testClear() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.clear();
		assertEquals(
				0,
				linkedList2.count());
	}
	
	@Test
	public void testClearHeadIsNull() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.clear();
		assertEquals(
				null,
				linkedList2.head);
	}
	
	@Test
	public void testClearTailIsNull() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.clear();
		assertEquals(
				null,
				linkedList2.tail);
	}

}
