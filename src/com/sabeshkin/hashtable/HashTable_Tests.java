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

}
