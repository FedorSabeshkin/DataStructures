package com.sabeshkin.nativedictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sabeshkin.hashtable.HashTable;

public class NativeDictionaryTests {

	@Test
	public void test_get_field_value() {
		NativeDictionary nativeDictionary = new NativeDictionary(17, String.class);
		nativeDictionary.put("phrase","hello");
		nativeDictionary.put("part", "World");
		String valueByKey = (String) nativeDictionary.get("phrase");
		assertEquals(
				"hello",
				valueByKey);
	}

}
