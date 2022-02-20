package com.sabeshkin.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListFindAllTest {
	LinkedList linkedList;
	LinkedList largeLinkedList;
	@BeforeEach
	public void setUp() throws Exception {
		largeLinkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 1000000; i++){
			node = new Node(i);
			largeLinkedList.addInTail(node);
		}	
	}

	@Test
	public void testFindAllEmptyList() {
		linkedList = new LinkedList();
		ArrayList<Node> foundNodes = linkedList.findAll(1);
		assertEquals(
				0,
				foundNodes.size());
	}
	

	@Test
	public void testFindAllOneNodeInListFound() {
		linkedList = new LinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		ArrayList<Node> foundNodes = linkedList.findAll(1);
		assertEquals(
				1,
				foundNodes.size());
	}
	
	@Test
	public void testFindAllInLargeListOneNodeInListFound() {										   
		ArrayList<Node> foundNodes = largeLinkedList.findAll(999999);
		assertEquals(
				1,
				foundNodes.size());
	}
	
	
	@Test
	public void testFindAllOneNodeInListDidNotFound() {
		linkedList = new LinkedList();
		Node node = new Node(1);
		linkedList.addInTail(node);
		ArrayList<Node> foundNodes = linkedList.findAll(2);
		assertEquals(
				0,
				foundNodes.size());
	}
	

	@Test
	public void testFindAllNumberOne() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList.addInTail(node);
		}
		ArrayList<Node> foundNodes = linkedList.findAll(1);
		assertEquals(
				1,
				foundNodes.size());
	}

	
	@Test
	public void testFindAllNumberThree() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(3);
			linkedList.addInTail(node);
		}
		ArrayList<Node> foundNodes = linkedList.findAll(3);
		assertEquals(
				5,
				foundNodes.size());
	}

	
	@Test
	public void testFindAllNumberHundred() {
		linkedList = new LinkedList();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(3);
			linkedList.addInTail(node);
		}
		ArrayList<Node> foundNodes = linkedList.findAll(100);
		assertEquals(
				0,
				foundNodes.size());
	}

}
