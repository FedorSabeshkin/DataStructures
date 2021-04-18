package com.sabeshkin.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListSumEachNodeTest {
	LinkedList firstList;
	LinkedList secondList;
	
	@Test
	public void testSumEachNodeTailIsFour() {
		firstList = new LinkedList();
		secondList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			firstList.addInTail(node);
			secondList.addInTail(node);
		}
		firstList = LinkedList.sumEachNode(firstList, secondList);
		assertEquals(
				18,
				firstList.tail.value);
	}
	
	@Test
	public void testSumEachNodeHeadIsZero() {
		firstList = new LinkedList();
		secondList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			firstList.addInTail(node);
			secondList.addInTail(node);
		}
		firstList = LinkedList.sumEachNode(firstList, secondList);
		assertEquals(
				0,
				firstList.head.value);
	}
	
	
	@Test
	public void testSumEachNodeSomeNodeIsTwentyFive() {
		firstList = new LinkedList();
		secondList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			firstList.addInTail(node);
			secondList.addInTail(node);
		}
		firstList = LinkedList.sumEachNode(firstList, secondList);
		assertEquals(
				14,
				firstList.find(14).value);
	}
	
	@Test
	public void testSumEachNodeWithDifferentValueInLists() {
		firstList = new LinkedList();
		secondList = new LinkedList();
		Node nodeForFirstList;
		Node nodeForSecondList;
		for (int i = 0; i < 10; i++){
			nodeForFirstList = new Node(i);
			nodeForSecondList = new Node(i+3);
			firstList.addInTail(nodeForFirstList);
			secondList.addInTail(nodeForSecondList);
		}
		firstList = LinkedList.sumEachNode(firstList, secondList);
		assertEquals(
				21,
				firstList.tail.value);
	}


}
