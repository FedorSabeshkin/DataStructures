package com.sabeshkin.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListMultiplyEachNodeTest {
	LinkedList firstList;
	LinkedList secondList;
	@Test
	public void testMultiplyEachNodeTailIsFour() {
		firstList = new LinkedList();
		secondList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			firstList.addInTail(node);
			secondList.addInTail(node);
		}
		firstList = LinkedList.multiplyEachNode(firstList, secondList);
		assertEquals(
				81,
				firstList.tail.value);
	}
	
	
	@Test
	public void testMultiplyEachNodeHeadIsZero() {
		firstList = new LinkedList();
		secondList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			firstList.addInTail(node);
			secondList.addInTail(node);
		}
		firstList = LinkedList.multiplyEachNode(firstList, secondList);
		assertEquals(
				0,
				firstList.head.value);
	}
	
	
	@Test
	public void testMultiplyEachNodeSomeNodeIsTwentyFive() {
		firstList = new LinkedList();
		secondList = new LinkedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			firstList.addInTail(node);
			secondList.addInTail(node);
		}
		firstList = LinkedList.multiplyEachNode(firstList, secondList);
		assertEquals(
				25,
				firstList.find(25).value);
	}
	
	@Test
	public void testMultiplyEachNodeWithDifferentValueInLists() {
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
		firstList = LinkedList.multiplyEachNode(firstList, secondList);
		assertEquals(
				108,
				firstList.tail.value);
	}

}
