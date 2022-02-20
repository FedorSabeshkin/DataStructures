package com.sabeshkin.linkedlist2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LinkedList2InsertAfterTest {
	LinkedList2 linkedList2;
	
	@Test
	public void testInsertAfter_InsertBeforeHead_HeadNextNextIsOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(null, nodeToInsert);
		Node oldHead = linkedList2.head.next;
		assertEquals(
				1,
				oldHead.next.value);
	}
	
	@Test
	public void testInsertAfter_InsertBeforeHead_HeadIsTen() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(null, nodeToInsert);
		assertEquals(
				10,
				linkedList2.head.value);
	}
	
	@Test
	public void testInsertAfter_InsertBeforeHead_HeadNextIsZero() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(null, nodeToInsert);
		assertEquals(
				0,
				linkedList2.head.next.value);
	}
	
	@Test
	public void testInsertAfter_NextNewNode_IsSix() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeAfter = linkedList2.find(5);
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				6,
				linkedList2.find(10).next.value);
	}
	
	@Test
	public void testInsertAfter_PrevNewNode_IsFive() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeAfter = linkedList2.find(5);
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				5,
				linkedList2.find(10).prev.value);
	}
	
	@Test
	public void testInsertAfter_PrevNewHead_IsNull() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeAfter = linkedList2.find(0);
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				null,
				linkedList2.head.prev);
	}
	
	@Test
	public void testInsertAfter_PrevTailValue_IsNine() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeAfter = linkedList2.find(9);
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				9,
				linkedList2.tail.prev.value);
	}
	
	@Test
	public void testInsertAfter_TailValueIsTen() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeAfter = linkedList2.find(9);
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				10,
				linkedList2.tail.value);
	}
	
	@Test
	public void testInsertAfter_HeadValueIsZero() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeAfter = linkedList2.find(0);
		Node nodeToInsert = new Node(10);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				0,
				linkedList2.head.value);
	}

	@Test
	public void testInsertAfter_Count() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		int countBeforeInsert = linkedList2.count();
		Node nodeAfter = linkedList2.find(1);
		Node nodeToInsert = new Node(100);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				countBeforeInsert + 1,
				linkedList2.count());
	}
	
	@Test
	public void testInsertAfter_TailValueIsOneHundred() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		Node nodeAfter = linkedList2.find(9);
		Node nodeToInsert = new Node(100);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				100,
				linkedList2.tail.value);
	}
	
	@Test
	public void testInsertAfter_InEmptyListHeadIsOneHundred() {
		linkedList2 = new LinkedList2();
		Node nodeAfter = null;
		Node nodeToInsert = new Node(100);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				100,
				linkedList2.head.value);
	}
	
	@Test
	public void testInsertAfter_InEmptyListTailIsOneHundred() {
		linkedList2 = new LinkedList2();
		Node nodeAfter = null;
		Node nodeToInsert = new Node(100);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				100,
				linkedList2.tail.value);
	}

	@Test
	public void testInsertAfter_InEmptyList() {
		linkedList2 = new LinkedList2();
		int countBeforeInsert = linkedList2.count();
		Node nodeAfter = null;
		Node nodeToInsert = new Node(100);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				countBeforeInsert + 1,
				linkedList2.count());
	}
	
	@Test
	public void testInsertAfter_InEmptyListTailValueIsOneHundred() {
		linkedList2 = new LinkedList2();
		Node nodeAfter = null;
		Node nodeToInsert = new Node(100);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				100,
				linkedList2.tail.value);
	}
	
	@Test
	public void testInsertAfter_InEmptyListHeadValueIsOneHundred() {
		linkedList2 = new LinkedList2();
		Node nodeAfter = null;
		Node nodeToInsert = new Node(100);
		linkedList2.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				100,
				linkedList2.tail.value);
	}

}
