package com.sabeshkin.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashTable_Tests {

	@Test(expected = Test.None.class /* no exception expected */)
	public void test_put_without_exception() {
		HashTable hashTable = new HashTable(17, 3);
		hashTable.put("hello");
	}
	
	@Test(expected = Test.None.class)
	public void test_constructor_without_exception() {
		HashTable hashTable = new HashTable(17, 3);
	}
	
	@Test(expected = Test.None.class)
	public void test_find_without_exception() {
		HashTable hashTable = new HashTable(17, 3);
		hashTable.put("hello");
		hashTable.put("World");
		hashTable.find("hello");
	}
	
	@Test
	public void test_find_hello_index() {
		HashTable hashTable = new HashTable(17, 3);
		int indexPut = hashTable.put("hello");
		hashTable.put("World");
		int indexFound = hashTable.find("hello");
		assertEquals(
				indexPut,
				indexFound);
	}

	@Test
	public void test_put_collisians_putIndexIsNegativeOne() {
		HashTable hashTable = new HashTable(17, 3);
		
		for(int i = 0; i<18; i++)
			hashTable.put("hello");
		hashTable.put("World");
		int indexPut = hashTable.put("hello");
		assertEquals(
				-1,
				indexPut);
	}
	
	@Test
	public void test_put_collisians_intoWideTable_putIndexIsNegativeOne() {
		HashTable hashTable = new HashTable(173, 3);
		
		for(int i = 0; i<174; i++)
			hashTable.put("hello");
		hashTable.put("World");
		int indexPut = hashTable.put("hello");
		assertEquals(
				-1,
				indexPut);
	}
}
