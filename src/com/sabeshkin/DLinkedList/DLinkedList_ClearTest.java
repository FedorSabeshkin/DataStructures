package com.sabeshkin.DLinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DLinkedList_ClearTest {
	DLinkedList linkedList2;
	
	@Test
	public void testClear() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.clear();
		assertEquals(
				0,
				linkedList2.count);
	}
	
	@Test
	public void testClearHeadIsNull() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.clear();
		assertEquals(
				null,
				linkedList2.getHead());
	}
	
	@Test
	public void testClearTailIsNull() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.clear();
		assertEquals(
				null,
				linkedList2.getTail());
	}

}
