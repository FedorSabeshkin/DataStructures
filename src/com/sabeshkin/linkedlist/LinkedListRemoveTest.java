package com.sabeshkin.linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sabeshkin.linkedlist.*;

public class LinkedListRemoveTest {
	LinkedList linkedList;
	
	@Test
	public void testRemoveFromListWithOnlyOneElementHeadIsNull() {
		linkedList = new LinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		linkedList.remove(1);
		assertEquals(
				null,
				linkedList.head);
	}
	
	@Test
	public void testRemoveFromListWithOnlyOneElementTailIsNull() {
		linkedList = new LinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		linkedList.remove(1);
		assertEquals(
				null,
				linkedList.tail);
	}
	
	@Test
	public void testRemoveFromEmptyList() {
		linkedList = new LinkedList();
		linkedList.remove(0);
		assertEquals(
				0,
				linkedList.count());
	}
	
	@Test
	public void testRemoveValueFromeListTailIsOneHundred() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 100; i++){
			if(i==0 || i ==99){
				node = new Node(100);	
			}else{
				node = new Node(i);	
			}
			linkedList.addInTail(node);
		}
		linkedList.remove(100);
		assertEquals(
				100,
				linkedList.tail.value);
	}
	
	@Test
	public void testRemoveValueFromeListHeadIsOne() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 100; i++){
			if(i==0 || i ==99){
				node = new Node(100);	
			}else{
				node = new Node(i);	
			}
			linkedList.addInTail(node);
		}
		linkedList.remove(100);
		assertEquals(
				1,
				linkedList.head.value);
	}
	
	@Test
	public void testRemoveLastValueFromLargeList() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10000000; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.remove(9999999);
		assertEquals(
				9999999,
				linkedList.count());
	}
	
	@Test
	public void testRemoveMediumValueFromLargeList() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10000000; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.remove(5000000);
		assertEquals(
				9999999,
				linkedList.count());
	}
	
	@Test
	public void testRemove() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.remove(0);
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
	public void testRemoveNumberOneHundred() {
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
