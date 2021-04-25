package com.sabeshkin.DLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sabeshkin.DLinkedList.*;

public class DLinkedList_RemoveTest {
	DLinkedList linkedList;
	@Test
	public void testRemoveFromListWithOnlyOneElementHeadIsNull() {
		linkedList = new DLinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		linkedList.remove(1);
		assertEquals(
				null,
				linkedList.getHead());
	}
	
	@Test
	public void testRemoveFromListWithOnlyOneElementTailIsNull() {
		linkedList = new DLinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		linkedList.remove(1);
		assertEquals(
				null,
				linkedList.getTail());
	}
	
	@Test
	public void testRemoveFromEmptyList() {
		linkedList = new DLinkedList();
		linkedList.remove(0);
		assertEquals(
				0,
				linkedList.count);
	}
	
	@Test
	public void testRemoveValueFromeListTailIsOneHundred() {
		linkedList = new DLinkedList();
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
				new Integer(100),
				linkedList.getTail().value);
	}
	
	@Test
	public void testRemoveValueFromeListHeadIsOne() {
		linkedList = new DLinkedList();
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
				new Integer(1),
				linkedList.getHead().value);
	}
	
	@Test
	public void testRemoveLastValueFromLargeList() {
		linkedList = new DLinkedList();
		Node node;
		for (int i = 0; i < 1000000; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.remove(999999);
		assertEquals(
				999999,
				linkedList.count);
	}
	
	@Test
	public void testRemoveMediumValueFromLargeList() {
		linkedList = new DLinkedList();
		Node node;
		for (int i = 0; i < 1000000; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.remove(500000);
		assertEquals(
				999999,
				linkedList.count);
	}
	
	@Test
	public void testRemove() {
		linkedList = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.remove(0);
		assertEquals(
				4,
				linkedList.count);
	}

	@Test
	public void testRemoveNumberOne() {
		linkedList = new DLinkedList();
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
		linkedList = new DLinkedList();
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
