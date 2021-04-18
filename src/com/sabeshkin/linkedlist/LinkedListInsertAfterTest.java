package com.sabeshkin.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListInsertAfterTest {
	LinkedList linkedList;

	@Test
	public void testInsertAfterCount() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		int countBeforeInsert = linkedList.count();
		Node nodeAfter = linkedList.find(1);
		Node nodeToInsert = new Node(100);
		linkedList.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				countBeforeInsert + 1,
				linkedList.count());
	}
	
	@Test
	public void testInsertAfterTailValueIsOneHundred() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		Node nodeAfter = linkedList.find(9);
		Node nodeToInsert = new Node(100);
		linkedList.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				100,
				linkedList.tail.value);
	}

	@Test
	public void testInsertAfterInEmptyList() {
		linkedList = new LinkedList();
		int countBeforeInsert = linkedList.count();
		Node nodeAfter = null;
		Node nodeToInsert = new Node(100);
		linkedList.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				countBeforeInsert + 1,
				linkedList.count());
	}
	
	@Test
	public void testInsertAfterInEmptyListTailValueIsOneHundred() {
		linkedList = new LinkedList();
		Node nodeAfter = null;
		Node nodeToInsert = new Node(100);
		linkedList.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				100,
				linkedList.tail.value);
	}
	
	@Test
	public void testInsertAfterInEmptyListHeadValueIsOneHundred() {
		linkedList = new LinkedList();
		Node nodeAfter = null;
		Node nodeToInsert = new Node(100);
		linkedList.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				100,
				linkedList.tail.value);
	}

}
