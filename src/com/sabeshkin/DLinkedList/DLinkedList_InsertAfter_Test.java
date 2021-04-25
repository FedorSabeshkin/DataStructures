package com.sabeshkin.DLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sabeshkin.DLinkedList.*;

public class DLinkedList_InsertAfter_Test {

	@Test
	public void testInsertAfter_TailValueIsOneHundred() {
		DLinkedList dLinkedList = new DLinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			dLinkedList.addInTail(node);
		}
		Node nodeAfter = dLinkedList.find(9);
		Node nodeToInsert = new Node(100);
		dLinkedList.insertAfter(nodeAfter, nodeToInsert);
		assertEquals(
				new Integer(100),
				dLinkedList.getTail().value);
	}
}
