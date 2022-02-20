package com.sabeshkin.hashtable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HashTable_Tests {

	@Test
	public void test_put_without_exception() {
		assertDoesNotThrow(() -> {
			HashTable hashTable = new HashTable(17, 3);
			hashTable.put("hello");
		});
	}
	
	@Test
	public void test_constructor_without_exception() {
		assertDoesNotThrow(() -> {
			HashTable hashTable = new HashTable(17, 3);
		});
	}
	
	@Test
	public void test_find_without_exception() {
		assertDoesNotThrow(() -> {
			HashTable hashTable = new HashTable(17, 3);
			hashTable.put("hello");
			hashTable.put("World");
			hashTable.find("hello");
		});
	}
	
	@Test
	public void test_find_hello_index() {
		HashTable hashTable = new HashTable(17, 3);
		int indexPut = hashTable.put("hello");
		hashTable.put("World");
		int indexFound = hashTable.find(new String("hello"));
		assertEquals(
				indexPut,
				indexFound);
	}
	
	@Test
	public void test_put_collisians_putIndexIsNegativeOne() {
		HashTable hashTable = new HashTable(17, 3);
		for(int i = 0; i<18; i++)
			hashTable.put("hello"+i);
		hashTable.put("World");
		int indexPut = hashTable.put("hello");
		assertEquals(
				-1,
				indexPut);
	}
	
	@Test
	public void test_put_collisians_putIndexIsNotNegativeOne() {
		HashTable hashTable = new HashTable(17, 3);
		for(int i = 0; i<18; i++)
			hashTable.put("hello");
		hashTable.put("World");
		int indexPut = hashTable.put("hello");
		assertNotEquals(
				-1,
				indexPut);
	}
	
	@Test
	public void test_put_collisians_intoWideTable_putIndexIsNegativeOne() {
		HashTable hashTable = new HashTable(173, 3);
		
		for(int i = 0; i<174; i++)
			hashTable.put("hello"+i);
		hashTable.put("World");
		int indexPut = hashTable.put("hello");
		assertEquals(
				-1,
				indexPut);
	}
}
