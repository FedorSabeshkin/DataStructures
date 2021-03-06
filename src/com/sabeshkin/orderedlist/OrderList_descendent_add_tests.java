package com.sabeshkin.orderedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrderList_descendent_add_tests {
	@SuppressWarnings("rawtypes")
	OrderedList orderedList;
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addOneElement_headIsZero() {
		orderedList = new OrderedList(false);
		orderedList.add(new Integer(0));
		assertEquals(
				0,
				orderedList.head.value);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addDescendingOrder_TwoElements_tailIsOne() {
		orderedList = new OrderedList(false);
		for (int i = 2; i > 0; i--){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				1,
				orderedList.tail.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addDescendingOrder_TenElements_headIsTen() {
		orderedList = new OrderedList(false);
		for (int i = 10; i > 0; i--){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				10,
				orderedList.head.value);
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_headIsNine() {
		orderedList = new OrderedList(false);
		for (int i = 0; i < 10; i++){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				9,
				orderedList.head.value);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_tailIsNotEqualPrePreTailElement() {
		orderedList = new OrderedList(false);
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
		orderedList = new OrderedList(false);
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
		orderedList = new OrderedList(false);
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
	public void test_addRandomOrder_TenElements_headIsTen() {
		orderedList = new OrderedList(false);
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new Integer(i));
			System.out.println(orderedList);
		}
		for (int i = 0; i <= 10; i=i+2){
			orderedList.add(new Integer(i));
			System.out.println(orderedList);
		}
		assertEquals(
				10,
				orderedList.head.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addRandomOrder_TenElements_tailIsZero() {
		orderedList = new OrderedList(false);
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new Integer(i));
		}
		for (int i = 0; i <= 10; i=i+2){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				0,
				orderedList.tail.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addMoreRandomOrder_TenElements_headIsZero() {
		orderedList = new OrderedList(false);
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new Integer(i));
		}
		for (int i = 10; i >= 0; i=i-2){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				0,
				orderedList.tail.value);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_oddElementsIsNotEqual() {
		orderedList = new OrderedList(false);
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
