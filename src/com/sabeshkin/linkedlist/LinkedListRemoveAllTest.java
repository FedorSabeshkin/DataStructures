package com.sabeshkin.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListRemoveAllTest {
	LinkedList linkedList;
	
	
	
	@Test
	public void testRemoveAllFromListWithOnlyOneElementHeadIsNull() {
		linkedList = new LinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		linkedList.removeAll(1);
		assertEquals(
				null,
				linkedList.head);
	}
	
	
	@Test
	public void testRemoveAllFromListWithOnlyOneElementTailIsNull() {
		linkedList = new LinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		linkedList.removeAll(1);
		assertEquals(
				null,
				linkedList.tail);
	}

	
	@Test
	public void testRemoveAllTwoEqualNumbers() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			if(i>2){
				node = new Node(2);
			}else{
				node = new Node(i);	
			}
			linkedList.addInTail(node);
		}
		linkedList.removeAll(2);
		assertEquals(
				2,
				linkedList.count());
	}
	
	@Test
	public void testRemoveAllValueFromeListTailIsOneHundred() {
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
		linkedList.removeAll(100);
		assertEquals(
				98,
				linkedList.tail.value);
	}
	
	@Test
	public void testRemoveAllValueFromeListHeadIsOne() {
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
		linkedList.removeAll(100);
		assertEquals(
				1,
				linkedList.head.value);
	}
	
	
	@Test
	public void testRemoveAllTwoEqualNumbersFromTail() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			if(i>2){
				node = new Node(2);
			}else{
				node = new Node(i);	
			}
			linkedList.addInTail(node);
		}
		linkedList.removeAll(2);
		assertEquals(
				1,
				linkedList.tail.value);
	}
	
	@Test
	public void testRemoveAllFiveEqualNumbers() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			if(i<5){
				node = new Node(2);
			}else{
				node = new Node(i);	
			}
			linkedList.addInTail(node);
		}
		linkedList.removeAll(2);
		assertEquals(
				5,
				linkedList.count());
	}

	@Test
	public void testRemoveAllTwoNumbers() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		linkedList.removeAll(2);
		assertEquals(
				9,
				linkedList.count());
	}

	@Test
	public void testRemoveAll() {
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
	public void testRemoveAllNumberOne() {
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
	public void testRemoveAllNumberHundred() {
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
