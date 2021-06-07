package com.sabeshkin.orderedlist;

import static org.junit.Assert.*;

import org.junit.Test;


public class OrderedList_compare_tests {
	OrderedList orderedList;
	@Test
	public void test() {
		orderedList = new OrderedList();
		Node node;
		for (int i = 0; i < 10; i++){
			node = new Node(i);
			orderedList.addInTail(node);
		}
		assertEquals(
				0,
				orderedList.count());
	}

}
