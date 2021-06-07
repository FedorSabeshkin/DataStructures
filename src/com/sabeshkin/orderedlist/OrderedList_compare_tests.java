package com.sabeshkin.orderedlist;

import static org.junit.Assert.*;

import org.junit.Test;


public class OrderedList_compare_tests {
	@SuppressWarnings("rawtypes")
	OrderedList orderedList;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test() {
		orderedList = new OrderedList(true);
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			orderedList.add(node);
		}
		assertEquals(
				0,
				orderedList.head.value);
	}

}
