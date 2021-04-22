package com.sabeshkin.linkedlist2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedList2RemoveAllTest {
	LinkedList2 linkedList2;
	
	@Test
	public void testRemoveAllHeadNewHeadPrevIsNull() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(0);
		assertEquals(
				null,
				linkedList2.head.prev);
	}
	
	
	@Test
	public void testRemoveTailNewTailPrevIsNull() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(4);
		assertEquals(
				2,
				linkedList2.tail.prev.value);
	}
	
	
	@Test
	public void testRemoveAll_RemoveNodeFromMidle_PrevForThreeIsOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				1,
				linkedList2.find(3).prev.value);
	}
	
	@Test
	public void testRemoveAll_RemoveNodeFromMidle_NextForOneIsThree() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				3,
				linkedList2.find(1).next.value);
	}
	
	@Test
	public void testRemoveAll_RemoveNodeFromMidle_PrevIsOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				1,
				linkedList2.find(3).prev.value);
	}
	
	@Test
	public void testRemoveAllFromListWithOnlyOneElementHeadIsNull() {
		linkedList2 = new LinkedList2();
		Node node = new Node(1);
		linkedList2.addInTail(node);
		linkedList2.removeAll(1);
		assertEquals(
				null,
				linkedList2.head);
	}
	
	
	@Test
	public void testRemoveAllFromListWithOnlyOneElementTailIsNull() {
		linkedList2 = new LinkedList2();
		Node node = new Node(1);
		linkedList2.addInTail(node);
		linkedList2.removeAll(1);
		assertEquals(
				null,
				linkedList2.tail);
	}

	
	@Test
	public void testRemoveAllTwoEqualNumbers() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			if(i>2){
				node = new Node(2);
			}else{
				node = new Node(i);	
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				2,
				linkedList2.count());
	}
	
	@Test
	public void testRemoveAllValueFromeListTailIsOneHundred() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 100; i++){
			if(i==0 || i ==99){
				node = new Node(100);	
			}else{
				node = new Node(i);	
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(100);
		assertEquals(
				98,
				linkedList2.tail.value);
	}
	
	@Test
	public void testRemoveAllValueFromeListHeadIsOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 100; i++){
			if(i==0 || i ==99){
				node = new Node(100);	
			}else{
				node = new Node(i);	
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(100);
		assertEquals(
				1,
				linkedList2.head.value);
	}
	
	
	@Test
	public void testRemoveAllTwoEqualNumbersFromTail() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			if(i>2){
				node = new Node(2);
			}else{
				node = new Node(i);	
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				1,
				linkedList2.tail.value);
	}
	
	@Test
	public void testRemoveAllFiveEqualNumbers() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			if(i<5){
				node = new Node(2);
			}else{
				node = new Node(i);	
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				5,
				linkedList2.count());
	}

	@Test
	public void testRemoveAllTwoNumbers() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				9,
				linkedList2.count());
	}

	@Test
	public void testRemoveAll() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(0);
		assertEquals(
				4,
				linkedList2.count());
	}

	@Test
	public void testRemoveAll_RemoveNumberOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(1);
		assertEquals(
				null,
				linkedList2.find(1));
	}

	@Test
	public void testRemoveAll_RemoveNumberOneHundred() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(100);
		assertEquals(
				null,
				linkedList2.find(100));
	}
}
