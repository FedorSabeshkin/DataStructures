package com.sabeshkin.linkedlist;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sabeshkin.linkedlist.*;


public class LinkedListRemoveTest {
	LinkedList linkedList;

	@Test
	public void testRemove() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.remove(0);
		linkedList.count();
		assertEquals(
				4,
				linkedList.count());
	}
	
	@Test
	public void testRemoveNumberOne() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		assertEquals(
				true,
				linkedList.remove(1));
	}
	
	@Test
	public void testRemoveNumberHundred() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		assertEquals(
				false,
				linkedList.remove(100));
	}


}
