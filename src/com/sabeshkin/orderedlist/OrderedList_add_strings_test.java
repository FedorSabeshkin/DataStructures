package com.sabeshkin.orderedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedList_add_strings_test {

	@SuppressWarnings("rawtypes")
	OrderedList orderedList;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addOneElement_headIsZero() {
		orderedList = new OrderedList(true);
		orderedList.add(new String("Hello"));
		assertEquals(
				"Hello",
				orderedList.head.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addDescendingOrder_TwoElements_tailIsTwo() {
		orderedList = new OrderedList(true);
		for (int i = 2; i > 0; i--){
			orderedList.add(new String("Hello" + i));
		}
		assertEquals(
				"Hello2",
				orderedList.tail.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addDescendingOrder_TenElements_headIsOne() {
		orderedList = new OrderedList(true);
		for (int i = 10; i > 0; i--){
			orderedList.add(new String("Hello" + i));
		}
		assertEquals(
				"Hello1",
				orderedList.head.value);
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addAscendingOrder_TenElements_headIsZero() {
		orderedList = new OrderedList(true);
		for (int i = 0; i < 10; i++){
			orderedList.add(new String("Hello" + i));
		}
		assertEquals(
				"Hello0",
				orderedList.head.value);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addRandomOrder_TenElements_headIsZero() {
		orderedList = new OrderedList(true);
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new String(i+ "Hello"));
		}
		for (int i = 0; i <= 10; i=i+2){
			orderedList.add(new String(i+ "Hello"));
		}
		assertEquals(
				"0Hello",
				orderedList.head.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addMoreRandomOrder_TenElements_descandent_headIsZero() {
		System.out.println("test_addMoreRandomOrder_TenElements_descandent_headIsZero");
		orderedList = new OrderedList(false);
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new String(i+ "Hello"));
			System.out.println(orderedList);
		}
		for (int i = 10; i >= 0; i=i-2){
			orderedList.add(new String(i+ "Hello"));
			System.out.println(orderedList);
		}
		assertEquals(
				"9Hello",
				orderedList.head.value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test_addRandomOrderWithDoubles_TenElements_headIsZero() {
		System.out.println("test_addRandomOrderWithDoubles_TenElements_headIsZero");
		orderedList = new OrderedList(true);
		for (int i = 3; i < 10; i=i+2){
			orderedList.add(new String( i+ "Hello"));
			System.out.println(orderedList);
		}
		orderedList.add(new String("HOllo"));
		orderedList.add(new String("HOllo"));
		orderedList.add(new String( 3+ "  Hello   "));
		orderedList.add(new String(3+ "  Hello"));
		orderedList.add(new String(22+ "    Hello"));
		orderedList.add(new String(22+ "Hello"));
		for (int i = 10; i >= 0; i=i-2){
			orderedList.add(new String( i+ "Hello"));
			System.out.println(orderedList);
		}
		assertEquals(
				"0Hello",
				orderedList.head.value);
	}

}
