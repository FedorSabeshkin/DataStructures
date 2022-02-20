package com.sabeshkin.orderedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class OrderedList_clear_test {

	@SuppressWarnings("rawtypes")
	OrderedList orderedList;

	@SuppressWarnings({ "rawtypes", "unchecked" })

	@Test
	public void testClear() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(i);
		}
		orderedList.clear(true);
		assertEquals(
				0,
				orderedList.count());
	}

	@Test
	public void testClearHeadIsNull() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(i);
		}
		orderedList.clear(true);
		assertEquals(
				null,
				orderedList.head);
	}

	@Test
	public void testClearTailIsNull() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(i);
		}
		orderedList.clear(false);
		assertEquals(
				null,
				orderedList.tail);
	}

}
