package com.sabeshkin.DLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sabeshkin.DLinkedList.*;

public class DLinkedList_InsertAfter_Test {

	@Test
	public void testInsertAfter_TailValueIsOneHundred() {
		DLinkedList dLinkedList = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			dLinkedList.addInTail(node);
		}
		Node nodeAfter = dLinkedList.find(4);
		Node nodeToInsert = new Node(100);
		dLinkedList.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				new Integer(100),
				dLinkedList.getTail().value);
	}
	
	@Test
	public void testInsertAfter_HeadValueIsZero() {
		DLinkedList dLinkedList = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			dLinkedList.addInTail(node);
		}
		Node nodeAfter = dLinkedList.find(4);
		Node nodeToInsert = new Node(100);
		dLinkedList.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				new Integer(0),
				dLinkedList.getHead().value);
	}

/*
 * if _nodeAfter = null
 */
	
	
//	@Test
//	public void testInsertAfter_BeforeHead_HeadValueIsOneHundred() {
//		DLinkedList dLinkedList = new DLinkedList();
//		Node node;
//		for (int i = 0; i < 5; i++){
//			node = new Node(i);
//			dLinkedList.addInTail(node);
//		}
//		Node nodeAfter = null;
//		Node nodeToInsert = new Node(100);
//		dLinkedList.insertAfter(nodeAfter, nodeToInsert);
//		assertEquals(
//				new Integer(100),
//				dLinkedList.getHead().value);
//	}
//	
//	@Test
//	public void testInsertAfter_InsertIntoEmptyListAfterZero_HeadValueIsOneHundred() {
//		DLinkedList dLinkedList = new DLinkedList();
//		Node nodeAfter = null;
//		Node nodeToInsert = new Node(100);
//		dLinkedList.insertAfter(nodeAfter, nodeToInsert);
//		assertEquals(
//				new Integer(100),
//				dLinkedList.getHead().value);
//	}
}
