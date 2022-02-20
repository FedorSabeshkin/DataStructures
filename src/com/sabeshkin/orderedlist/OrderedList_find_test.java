package com.sabeshkin.orderedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class OrderedList_find_test {
	@SuppressWarnings("rawtypes")
	OrderedList orderedList;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testFindFoundNodeValueIsOne() {
		orderedList = new  OrderedList(true);;
		Node node;
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		Node foundNode = orderedList.find(1);
		assertEquals(
				1,
				foundNode.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testFindFoundNodeIsNull() {
		orderedList = new  OrderedList(true);
		Node node;
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		Node foundNode = orderedList.find(10);
		assertEquals(
				null,
				foundNode);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_find_string_FoundNodeIsWorld() {
		orderedList = new  OrderedList(true);
		Node node;
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new String(i+ "Hello"));
		}
		orderedList.add(new String("World"));
		for (int i = 0; i <= 10; i=i+2){
			orderedList.add(new String(i+ "Hello"));
		}
		Node foundNode = orderedList.find("World");
		System.out.println(orderedList);
		assertEquals(
				"World",
				foundNode.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_descadentOrder_find_string_FoundNodeIsWorld() {
		orderedList = new  OrderedList(false);
		Node node;
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new String(i+ "Hello"));
		}
		orderedList.add(new String("5World"));
		for (int i = 0; i <= 10; i=i+2){
			orderedList.add(new String(i+ "Hello"));
		}
		Node foundNode = orderedList.find("5World");
		System.out.println(orderedList);
		assertEquals(
				"5World",
				foundNode.value);
	}

}
