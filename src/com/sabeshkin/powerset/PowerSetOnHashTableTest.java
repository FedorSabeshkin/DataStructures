package com.sabeshkin.powerset;

import static org.junit.Assert.*;

import org.junit.Test;


public class PowerSetOnHashTableTest {

	@Test
	public void test_removeTwiceSameValue_SecondCallIsFalse() {
		PowerSetOnHashTable powerSetOnHashTable = new PowerSetOnHashTable();
		powerSetOnHashTable.put("Hello");
		powerSetOnHashTable.put("World");
		powerSetOnHashTable.remove("Hello");
		assertEquals(
				false,
				powerSetOnHashTable.remove("Hello"));
	}

	@Test
	public void test_removeInsertedValue_isTrue() {
		PowerSetOnHashTable powerSetOnHashTable = new PowerSetOnHashTable();
		powerSetOnHashTable.put("Hello");
		powerSetOnHashTable.put("World");
		assertEquals(
				true,
				powerSetOnHashTable.remove("Hello"));
	}
	
	@Test
	public void test_removeInsertedValue_from_20_000_list_isTrue() {
		PowerSetOnHashTable powerSetOnHashTable = new PowerSetOnHashTable();
		for (int i = 0; i < 20_000; i++){
			powerSetOnHashTable.put("World"+i);
		}
		assertEquals(
				true,
				powerSetOnHashTable.remove("World10000"));
	}
	
}
