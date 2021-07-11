package com.sabeshkin.nativedictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sabeshkin.hashtable.HashTable;

public class NativeDictionaryTests {

	@Test
	public void test_getFieldValue_isHello() {
		NativeDictionary nativeDictionary = new NativeDictionary(17, String.class);
		nativeDictionary.put("phrase","Hello");
		nativeDictionary.put("part", "World");
		String valueByKey = (String) nativeDictionary.get("phrase");
		assertEquals(
				"Hello",
				valueByKey);
	}
	
	@Test
	public void test_checkCollision_isCat() {
		NativeDictionary nativeDictionary = new NativeDictionary(17, String.class);
		nativeDictionary.put("phrase","Hello");
		nativeDictionary.put("part", "World");
		nativeDictionary.put("phrase", "Cat");
		String valueByKey = (String) nativeDictionary.get("phrase");
		assertEquals(
				"Cat",
				valueByKey);
	}
	
	@Test
	public void test_checkCollision_isNotHello() {
		NativeDictionary nativeDictionary = new NativeDictionary(17, String.class);
		nativeDictionary.put("phrase","Hello");
		nativeDictionary.put("part", "World");
		nativeDictionary.put("phrase", "Cat");
		String valueByKey = (String) nativeDictionary.get("phrase");
		assertNotEquals(
				"Hello",
				valueByKey);
	}
	
	
	@Test
	public void test_checkCollision_isHello5() {
		NativeDictionary nativeDictionary = new NativeDictionary(11, String.class);
		for(int i = 0; i<11; i++){
			if(i==10){
				int kek = 0;
			}
			nativeDictionary.put("phrase"+i,"Hello"+i);
		}
		String valueByKey = (String) nativeDictionary.get("phrase4");
		assertEquals(
				"Hello4",
				valueByKey);
	}
	
	@Test
	public void test_isKey_phrase_isTrue() {
		NativeDictionary nativeDictionary = new NativeDictionary(17, String.class);
		for(int i = 0; i<17; i++)
			nativeDictionary.put("phrase"+i,"Hello"+i);
		boolean isKey = nativeDictionary.isKey("phrase5");
		assertEquals(
				true,
				isKey);
	}
	
	@Test
	public void test_isKey_capWord_isFalse() {
		NativeDictionary nativeDictionary = new NativeDictionary(17, String.class);
		for(int i = 0; i<17; i++)
			nativeDictionary.put("phrase"+i,"Hello"+i);
		boolean  isKey = nativeDictionary.isKey("capWord");
		assertEquals(
				false,
				isKey);
	}
	
	@Test
	public void test_isKey_phrase16_isTrue() {
		NativeDictionary nativeDictionary = new NativeDictionary(17, String.class);
		for(int i = 0; i<17; i++)
			nativeDictionary.put("phrase"+i,"Hello"+i);
		boolean  isKey = nativeDictionary.isKey("phrase16");
		assertEquals(
				true,
				isKey);
	}

}
