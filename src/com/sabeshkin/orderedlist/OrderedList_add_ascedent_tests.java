package com.sabeshkin.orderedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedList_add_ascedent_tests {
	@SuppressWarnings("rawtypes")
	OrderedList orderedList;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addOneElement_headIsZero() {
		orderedList = new OrderedList(true);
		orderedList.add(new Integer(0));
		assertEquals(
				0,
				orderedList.head.value);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addDescendingOrder_TwoElements_tailIsTwo() {
		orderedList = new OrderedList(true);
		for (int i = 2; i > 0; i--){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				2,
				orderedList.tail.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addDescendingOrder_TenElements_headIsOne() {
		orderedList = new OrderedList(true);
		for (int i = 10; i > 0; i--){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				1,
				orderedList.head.value);
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_headIsZero() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				0,
				orderedList.head.value);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_tailIsNotEqualPrePreTailElement() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(new Integer(i));
		}
		Node prePreTail = orderedList.tail.prev.prev;
		assertNotEquals(
				prePreTail.value,
				orderedList.tail.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_tailIsNotEqualPreTailElement() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(new Integer(i));
		}
		Node preTail = orderedList.tail.prev;
		assertNotEquals(
				preTail.value,
				orderedList.tail.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_evenElementsIsNotEqual() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(new Integer(i));
		}
		Node secondElement = orderedList.head.next;
		Node fourthElement = secondElement.next.next;
		assertNotEquals(
				secondElement.value,
				fourthElement.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addRandomOrder_TenElements_headIsZero() {
		orderedList = new OrderedList(true);
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new Integer(i));
		}
		for (int i = 0; i <= 10; i=i+2){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				0,
				orderedList.head.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addRandomOrder_TenElements_tailIsTen() {
		orderedList = new OrderedList(true);
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new Integer(i));
		}
		for (int i = 0; i <= 10; i=i+2){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				10,
				orderedList.tail.value);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_oddElementsIsNotEqual() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(new Integer(i));
		}
		Node firstElement = orderedList.head;
		Node thirdElement = firstElement.next.next;
		assertNotEquals(
				firstElement.value,
				thirdElement.value);
	}
}
