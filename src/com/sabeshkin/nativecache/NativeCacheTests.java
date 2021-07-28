package com.sabeshkin.nativecache;

import static org.junit.Assert.*;

import org.junit.Test;

public class NativeCacheTests {

	@Test
	public void test_isKey_phrase16_isFalse() {
		NativeCache nativeCache = new NativeCache(17, String.class);
		for (int i = 0; i < 17; i++)
			nativeCache.put("phrase" + i, "Hello" + i);

		for (int i = 0; i < 16; i++)
			nativeCache.get("phrase" + i);
		nativeCache.put("newKey", "Bob");
		boolean isKey = nativeCache.isKey("phrase16");
		assertEquals(
				false,
				isKey);
	}

	@Test
	public void test_twoRequests_isKey_phrase16_isFalse() {
		NativeCache nativeCache = new NativeCache(17, String.class);
		for (int i = 0; i < 17; i++)
			nativeCache.put("phrase" + i, "Hello" + i);

		for (int i = 0; i < 17; i++)
			nativeCache.get("phrase" + i);
		for (int i = 0; i < 16; i++)
			nativeCache.get("phrase" + i);
		nativeCache.put("newKey", "Bob");
		boolean isKey = nativeCache.isKey("phrase16");
		assertEquals(
				false,
				isKey);
	}

	@Test
	public void test_elevenRequests_isKey_phrase11_isFalse() {
		NativeCache nativeCache = new NativeCache(17, String.class);
		for (int i = 0; i < 17; i++){
			nativeCache.put("phrase" + i, "Hello" + i);
		}
		// require all keys ten times
		for (int k = 0; k < 10; k++){
			for (int i = 0; i < 17; i++){
				nativeCache.get("phrase" + i);
			}
		}
		// require all keys exclude "phrase11"
		for (int i = 0; i < 11; i++)
			nativeCache.get("phrase" + i);
		for (int i = 12; i < 17; i++)
			nativeCache.get("phrase" + i);
		nativeCache.put("newKey", "Bob");
		boolean isKey = nativeCache.isKey("phrase11");
		assertEquals(
				false,
				isKey);
	}

	@Test
	public void test_getFieldValue_isHello() {
		NativeCache nativeCache = new NativeCache(17, String.class);
		nativeCache.put("phrase", "Hello");
		nativeCache.put("part", "World");
		String valueByKey = (String) nativeCache.get("phrase");
		assertEquals(
				"Hello",
				valueByKey);
	}

	@Test
	public void test_checkCollision_isCat() {
		NativeCache nativeCache = new NativeCache(17, String.class);
		nativeCache.put("phrase", "Hello");
		nativeCache.put("part", "World");
		nativeCache.put("phrase", "Cat");
		String valueByKey = (String) nativeCache.get("phrase");
		assertEquals(
				"Cat",
				valueByKey);
	}

	@Test
	public void test_checkCollision_isNotHello() {
		NativeCache nativeCache = new NativeCache(17, String.class);
		nativeCache.put("phrase", "Hello");
		nativeCache.put("part", "World");
		nativeCache.put("phrase", "Cat");
		String valueByKey = (String) nativeCache.get("phrase");
		assertNotEquals(
				"Hello",
				valueByKey);
	}

	@Test
	public void test_checkCollision_isHello5() {
		NativeCache nativeCache = new NativeCache(11, String.class);
		for (int i = 0; i < 11; i++){
			if(i == 10){
				int kek = 0;
			}
			nativeCache.put("phrase" + i, "Hello" + i);
		}
		String valueByKey = (String) nativeCache.get("phrase4");
		assertEquals(
				"Hello4",
				valueByKey);
	}

	@Test
	public void test_isKey_phrase_isTrue() {
		NativeCache nativeCache = new NativeCache(17, String.class);
		for (int i = 0; i < 17; i++)
			nativeCache.put("phrase" + i, "Hello" + i);
		boolean isKey = nativeCache.isKey("phrase5");
		assertEquals(
				true,
				isKey);
	}

	@Test
	public void test_isKey_capWord_isFalse() {
		NativeCache nativeCache = new NativeCache(17, String.class);
		for (int i = 0; i < 17; i++)
			nativeCache.put("phrase" + i, "Hello" + i);
		boolean isKey = nativeCache.isKey("capWord");
		assertEquals(
				false,
				isKey);
	}
}
