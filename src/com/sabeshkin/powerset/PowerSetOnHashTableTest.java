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
	
	
	@Test
	public void test_union_twoPowerSet() {
		PowerSetOnHashTable powerSetOnHashTableOne = new PowerSetOnHashTable();
		PowerSetOnHashTable powerSetOnHashTableSecond= new PowerSetOnHashTable();
		PowerSetOnHashTable powerSetUnion= new PowerSetOnHashTable();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableSecond.put("World");
		powerSetUnion = powerSetOnHashTableOne.union(powerSetOnHashTableSecond);
		assertEquals(
				true,
				powerSetUnion.get("World"));
	}
	
	@Test
	public void test_intersection_twoPowerSet() {
		PowerSetOnHashTable powerSetOnHashTableOne = new PowerSetOnHashTable();
		PowerSetOnHashTable powerSetOnHashTableSecond= new PowerSetOnHashTable();
		PowerSetOnHashTable powerSetUnion= new PowerSetOnHashTable();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableOne.put("Apple");
		powerSetOnHashTableOne.put("Orange");
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Orange");
		powerSetUnion = powerSetOnHashTableOne.intersection(powerSetOnHashTableSecond);
		assertEquals(
				true,
				powerSetUnion.get("Orange"));
	}
	
	@Test
	public void test_difference_twoPowerSet() {
		PowerSetOnHashTable powerSetOnHashTableOne = new PowerSetOnHashTable();
		PowerSetOnHashTable powerSetOnHashTableSecond= new PowerSetOnHashTable();
		PowerSetOnHashTable powerSetUnion= new PowerSetOnHashTable();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableOne.put("Apple");
		powerSetOnHashTableOne.put("Orange");
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Orange");
		powerSetUnion = powerSetOnHashTableOne.difference(powerSetOnHashTableSecond);
		assertEquals(
				false,
				powerSetUnion.get("Orange"));
	}
	
	@Test
	public void test_isSubset_twoPowerSet_isFalse() {
		PowerSetOnHashTable powerSetOnHashTableOne = new PowerSetOnHashTable();
		PowerSetOnHashTable powerSetOnHashTableSecond= new PowerSetOnHashTable();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableOne.put("Apple");
		powerSetOnHashTableOne.put("Orange");
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Orange");
		assertEquals(
				false,
				powerSetOnHashTableOne.isSubset(powerSetOnHashTableSecond));
	}
	
	@Test
	public void test_isSubset_twoPowerSet_isTrue() {
		PowerSetOnHashTable powerSetOnHashTableOne = new PowerSetOnHashTable();
		PowerSetOnHashTable powerSetOnHashTableSecond= new PowerSetOnHashTable();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableOne.put("Apple");
		powerSetOnHashTableOne.put("Orange");
		powerSetOnHashTableOne.put("World");
		powerSetOnHashTableSecond.put("Apple");
		powerSetOnHashTableSecond.put("Orange");
		assertEquals(
				true,
				powerSetOnHashTableOne.isSubset(powerSetOnHashTableSecond));
	}
	
}
