package com.sabeshkin.orderedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class OrderedList_delete_test {

	@SuppressWarnings("rawtypes")
	OrderedList orderedList;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemoveHead_NewHeadPrevIsNull() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		orderedList.delete(0);
		assertEquals(
				null,
				orderedList.head.prev);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemoveTail_NewTailPrevIsNull() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		orderedList.delete(4);
		System.out.println(orderedList);
		assertEquals(
				2,
				orderedList.tail.prev.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemoveTail_descandentOrder_headIsThree() {
		orderedList = new OrderedList(false);
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		orderedList.delete(4);
		System.out.println(orderedList);
		assertEquals(
				3,
				orderedList.head.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemove_RemoveNodeFromMidle_PrevForThreeIsOne() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		orderedList.delete(2);
		assertEquals(
				1,
				orderedList.find(3).prev.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemove_RemoveNodeFromMidle_NextForOneIsThree() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		orderedList.delete(2);
		assertEquals(
				3,
				orderedList.find(1).next.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemove_RemoveNodeFromMidle_PrevIsOne() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		orderedList.delete(2);
		assertEquals(
				1,
				orderedList.find(3).prev.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemoveFromListWithOnlyOneElementHeadIsNull() {
		orderedList = new OrderedList(true);
		orderedList.add(new Integer(1));
		orderedList.delete(1);
		assertEquals(
				null,
				orderedList.head);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemoveFromListWithOnlyOneElementTailIsNull() {
		orderedList = new OrderedList(true);
		orderedList.add(new Integer(1));
		orderedList.delete(1);
		assertEquals(
				null,
				orderedList.tail);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemoveFromEmptyList() {
		orderedList = new OrderedList(true);
		orderedList.delete(1);
		assertEquals(
				0,
				orderedList.count());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRemove() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 5; i++){
			orderedList.add(new Integer(i));
		}
		orderedList.delete(0);
		assertEquals(
				4,
				orderedList.count());
	}

}
