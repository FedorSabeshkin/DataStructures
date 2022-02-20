package com.sabeshkin.linkedlist2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedList2FindAllTest {
	LinkedList2 linkedList2;
	LinkedList2 largeLinkedList2;
	@BeforeEach
	public void setUp() throws Exception {
		largeLinkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 1000000; i++){
			node = new Node(i);
			largeLinkedList2.addInTail(node);
		}	
	}
	
	@Test
	public void testFindAll_CheckLink_LastFoundElementIsTail() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			if(i<3){
				node = new Node(0);
			}else{
				node = new Node(i);	
			}
			linkedList2.addInTail(node);
		}
		ArrayList<Node> foundNodes = linkedList2.findAll(4);
		assertEquals(
				true,
				linkedList2.isTail(foundNodes.get(0)));
	}
	
	@Test
	public void testFindAll_CheckLink_FirstFoundElementIsHead() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			if(i<3){
				node = new Node(0);
			}else{
				node = new Node(i);	
			}
			linkedList2.addInTail(node);
		}
		ArrayList<Node> foundNodes = linkedList2.findAll(0);
		assertEquals(
				true,
				linkedList2.isHead(foundNodes.get(0)));
	}

	@Test
	public void testFindAllEmptyList() {
		linkedList2 = new LinkedList2();
		ArrayList<Node> foundNodes = linkedList2.findAll(1);
		assertEquals(
				0,
				foundNodes.size());
	}
	

	@Test
	public void testFindAllOneNodeInListFound() {
		linkedList2 = new LinkedList2();
		Node node = new Node(1);
		linkedList2.addInTail(node);
		ArrayList<Node> foundNodes = linkedList2.findAll(1);
		assertEquals(
				1,
				foundNodes.size());
	}
	
	@Test
	public void testFindAllInLargeListOneNodeInListFound() {										   
		ArrayList<Node> foundNodes = largeLinkedList2.findAll(999999);
		assertEquals(
				1,
				foundNodes.size());
	}
	
	
	@Test
	public void testFindAllOneNodeInListDidNotFound() {
		linkedList2 = new LinkedList2();
		Node node = new Node(1);
		linkedList2.addInTail(node);
		ArrayList<Node> foundNodes = linkedList2.findAll(2);
		assertEquals(
				0,
				foundNodes.size());
	}
	

	@Test
	public void testFindAllNumberOne() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(i);
			linkedList2.addInTail(node);
		}
		ArrayList<Node> foundNodes = linkedList2.findAll(1);
		assertEquals(
				1,
				foundNodes.size());
	}

	
	@Test
	public void testFindAllNumberThree() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(3);
			linkedList2.addInTail(node);
		}
		ArrayList<Node> foundNodes = linkedList2.findAll(3);
		assertEquals(
				5,
				foundNodes.size());
	}

	
	@Test
	public void testFindAllNumberHundred() {
		linkedList2 = new LinkedList2();
		Node node;
		for (int i = 0; i < 5; i++){
			node = new Node(3);
			linkedList2.addInTail(node);
		}
		ArrayList<Node> foundNodes = linkedList2.findAll(100);
		assertEquals(
				0,
				foundNodes.size());
	}

}
