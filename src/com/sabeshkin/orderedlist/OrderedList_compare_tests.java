package com.sabeshkin.orderedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedList_compare_tests {
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
	public void test_addAscendingOrder_TenElements_headIsTen() {
		orderedList = new OrderedList(false);
		for (int i = 0; i < 10; i++){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				9,
				orderedList.head.value);
	}
}
