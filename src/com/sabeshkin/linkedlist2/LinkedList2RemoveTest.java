package com.sabeshkin.linkedlist2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sabeshkin.linkedlist2.*;

public class LinkedList2RemoveTest {
	LinkedList2 linkedList2;
	
	@Test
	public void testRemoveHeadNewHeadPrevIsNull() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.remove(0);
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
		linkedList2.remove(4);
		assertEquals(
				2,
				linkedList2.tail.prev.value);
	}
	
	
	@Test
	public void testRemove_RemoveNodeFromMidle_PrevForThreeIsOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.remove(2);
		assertEquals(
				1,
				linkedList2.find(3).prev.value);
	}
	
	@Test
	public void testRemove_RemoveNodeFromMidle_NextForOneIsThree() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.remove(2);
		assertEquals(
				3,
				linkedList2.find(1).next.value);
	}
	
	@Test
	public void testRemove_RemoveNodeFromMidle_PrevIsOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.remove(2);
		assertEquals(
				1,
				linkedList2.find(3).prev.value);
	}
	
	
	@Test
	public void testRemoveFromListWithOnlyOneElementHeadIsNull() {
		linkedList2 = new LinkedList2();
		Node node = new Node(1);
		linkedList2.addInTail(node);
		linkedList2.remove(1);
		assertEquals(
				null,
				linkedList2.head);
	}
	
	@Test
	public void testRemoveFromListWithOnlyOneElementTailIsNull() {
		linkedList2 = new LinkedList2();
		Node node = new Node(1);
		linkedList2.addInTail(node);
		linkedList2.remove(1);
		assertEquals(
				null,
				linkedList2.tail);
	}
	
	@Test
	public void testRemoveFromEmptyList() {
		linkedList2 = new LinkedList2();
		linkedList2.remove(0);
		assertEquals(
				0,
				linkedList2.count());
	}
	
	@Test
	public void testRemoveValueFromeListTailIsOneHundred() {
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
		linkedList2.remove(100);
		assertEquals(
				100,
				linkedList2.tail.value);
	}
	
	@Test
	public void testRemoveValueFromeListHeadIsOne() {
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
		linkedList2.remove(100);
		assertEquals(
				1,
				linkedList2.head.value);
	}
	
	@Test
	public void testRemoveLastValueFromLargeList() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 1000000; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.remove(999999);
		assertEquals(
				999999,
				linkedList2.count());
	}
	
	@Test
	public void testRemoveMediumValueFromLargeList() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 1000000; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.remove(500000);
		assertEquals(
				999999,
				linkedList2.count());
	}
	
	@Test
	public void testRemove() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		linkedList2.remove(0);
		assertEquals(
				4,
				linkedList2.count());
	}

	@Test
	public void testRemoveNumberOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		assertEquals(
				true,
				linkedList2.remove(1));
	}

	@Test
	public void testRemoveNumberOneHundred() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		assertEquals(
				false,
				linkedList2.remove(100));
	}

}
