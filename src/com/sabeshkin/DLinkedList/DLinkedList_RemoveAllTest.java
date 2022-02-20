package com.sabeshkin.DLinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DLinkedList_RemoveAllTest {
	DLinkedList linkedList2;

	@Test
	public void testRemoveAll_NewHeadPrevIsNull() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(0);
		assertEquals(
				null,
				linkedList2.getHead().prev);
	}

	@Test
	public void testRemoveTailNewTailPrevIsNull() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(4);
		assertEquals(
				new Integer(2),
				linkedList2.getTail().prev.value);
	}

	@Test
	public void testRemoveAll_RemoveNodeFromMidle_PrevForThreeIsOne() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				new Integer(1),
				linkedList2.find(3).prev.value);
	}

	@Test
	public void testRemoveAll_RemoveNodeFromMidle_NextForOneIsThree() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				new Integer(3),
				linkedList2.find(1).next.value);
	}

	@Test
	public void testRemoveAll_RemoveNodeFromMidle_PrevIsOne() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				new Integer(1),
				linkedList2.find(3).prev.value);
	}

	@Test
	public void testRemoveAllFromListWithOnlyOneElementHeadIsNull() {
		linkedList2 = new DLinkedList();
		Node node = new Node(1);
		linkedList2.addInTail(node);
		linkedList2.removeAll(1);
		assertEquals(
				null,
				linkedList2.getHead());
	}

	@Test
	public void testRemoveAllFromListWithOnlyOneElementTailIsNull() {
		linkedList2 = new DLinkedList();
		Node node = new Node(1);
		linkedList2.addInTail(node);
		linkedList2.removeAll(1);
		assertEquals(
				null,
				linkedList2.getTail());
	}

	@Test
	public void testRemoveAllTwoEqualNumbers() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			if(i > 2){
				node = new Node(2);
			} else{
				node = new Node(i);
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				2,
				linkedList2.count);
	}

	@Test
	public void testRemoveAllValueFromeListTailIsOneHundred() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 100; i++){
			if(i == 0 || i == 99){
				node = new Node(100);
			} else{
				node = new Node(i);
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(100);
		assertEquals(
				new Integer(98),
				linkedList2.getTail().value);
	}

	@Test
	public void testRemoveAllValueFromeListHeadIsOne() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 100; i++){
			if(i == 0 || i == 99){
				node = new Node(100);
			} else{
				node = new Node(i);
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(100);
		assertEquals(
				new Integer(1),
				linkedList2.getHead().value);
	}

	@Test
	public void testRemoveAllTwoEqualNumbersFromTail() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			if(i > 2){
				node = new Node(2);
			} else{
				node = new Node(i);
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				new Integer(1),
				linkedList2.getTail().value);
	}

	@Test
	public void testRemoveAllFiveEqualNumbers() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			if(i < 5){
				node = new Node(2);
			} else{
				node = new Node(i);
			}
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				5,
				linkedList2.count);
	}

	@Test
	public void testRemoveAllTwoNumbers() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(2);
		assertEquals(
				9,
				linkedList2.count);
	}

	@Test
	public void testRemoveAll() {
		linkedList2 = new DLinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.removeAll(0);
		assertEquals(
				4,
				linkedList2.count);
	}

	@Test
	public void testRemoveAll_RemoveNumberOne() {
		linkedList2 = new DLinkedList();
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
		linkedList2 = new DLinkedList();
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
