package com.sabeshkin.linkedlist;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LinkedListFindAllTest {
	LinkedList linkedList;
	
	@Test
	public void testFindAllNumberOne() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		ArrayList<Node> foundedNodes = linkedList.findAll(1);
		assertEquals(
				1,
				foundedNodes.size());
	}
	
	@Test
	public void testFindAllNumberThree() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(3);
			linkedList.addInTail(node);
		}
		ArrayList<Node> foundedNodes = linkedList.findAll(3);
		assertEquals(
				5,
				foundedNodes.size());
	}
	
	@Test
	public void testFindAllNumberHundred() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(3);
			linkedList.addInTail(node);
		}
		ArrayList<Node> foundedNodes = linkedList.findAll(100);
		assertEquals(
				0,
				foundedNodes.size());
	}

}
