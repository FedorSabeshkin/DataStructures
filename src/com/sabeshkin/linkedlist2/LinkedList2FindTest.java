package com.sabeshkin.linkedlist2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedList2FindTest {
	LinkedList2 linkedlist2;
	@Test
	public void testFindFoundNodeValueIsOne() {
		linkedlist2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedlist2.addInTail(node);
		}
		Node foundNode = linkedlist2.find(1);
		assertEquals(
				1,
				foundNode.value);
	}
	
	@Test
	public void testFindFoundNodeIsNull() {
		linkedlist2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedlist2.addInTail(node);
		}
		Node foundNode = linkedlist2.find(10);
		assertEquals(
				null,
				foundNode);
	}

}
