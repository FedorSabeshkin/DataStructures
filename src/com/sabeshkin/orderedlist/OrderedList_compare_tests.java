package com.sabeshkin.orderedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedList_compare_tests {
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
	public void test() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(new Integer(i));
		}
		assertEquals(
				1,
				orderedList.tail.value);
	}

}
