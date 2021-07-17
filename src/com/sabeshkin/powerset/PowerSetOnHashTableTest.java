package com.sabeshkin.powerset;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerSetOnHashTableTest {

	@Test
	public void test_removeTwiceSameValue_SecondCallIsFalse() {
		PowerSet powerSetOnHashTable = new PowerSet();
		powerSetOnHashTable.put("Hello");
		powerSetOnHashTable.put("World");
		powerSetOnHashTable.remove("Hello");
		assertEquals(
				false,
				powerSetOnHashTable.remove("Hello"));
	}

	@Test
	public void test_removeInsertedValue_isTrue() {
		PowerSet powerSetOnHashTable = new PowerSet();
		powerSetOnHashTable.put("Hello");
		powerSetOnHashTable.put("World");
		assertEquals(
				true,
				powerSetOnHashTable.remove("Hello"));
	}
	
	@Test
	public void test_removeInsertedValue_contIsOne() {
		PowerSet powerSetOnHashTable = new PowerSet();
		powerSetOnHashTable.put("Hello");
		powerSetOnHashTable.put("World");
		powerSetOnHashTable.remove("Hello");
		assertEquals(
				1,
				powerSetOnHashTable.size());
	}

	@Test
	public void test_removeInsertedValue_from_20_000_list_isTrue() {
		PowerSet powerSetOnHashTable = new PowerSet();
		for (int i = 0; i < 20_000; i++){
			powerSetOnHashTable.put("World" + i);
		}
		assertEquals(
				true,
				powerSetOnHashTable.remove("World10000"));
	}

	@Test
	public void test_union_twoPowerSet_twiceIsNotEmpty() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableSecond.put("World");
		powerSetUnion = powerSetOnHashTableOne.union(powerSetOnHashTableSecond);
		assertEquals(
				true,
				powerSetUnion.get("World"));
	}

	@Test
	public void test_union_twoPowerSet_oneIsEmpty() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOnHashTableOne.put("Hello");
		powerSetUnion = powerSetOnHashTableOne.union(powerSetOnHashTableSecond);
		assertEquals(
				1,
				powerSetUnion.size());
	}

	@Test
	public void test_union_twoPowerSet_20_000() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		for (int i = 0; i < 10_000; i++){
			powerSetOnHashTableOne.put("World" + i);
		}
		for (int i = 10_000; i < 20_000; i++){
			powerSetOnHashTableOne.put("World" + i);
		}
		powerSetOnHashTableOne.put("Hello");
		powerSetUnion = powerSetOnHashTableOne.union(powerSetOnHashTableSecond);
		assertEquals(
				20000,
				powerSetUnion.size());
	}

	@Test
	public void test_intersection_twoPowerSet_notEmpty() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
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
	public void test_intersection_twoPowerSet_isEmpty() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableOne.put("Apple");
		powerSetOnHashTableOne.put("Orange");
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Flower");
		powerSetUnion = powerSetOnHashTableOne.intersection(powerSetOnHashTableSecond);
		assertEquals(
				0,
				powerSetUnion.size());
	}

	@Test
	public void test_get_isFalse() {
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Flower");
		assertEquals(
				false,
				powerSetOnHashTableSecond.get("Orange"));
	}

	@Test
	public void test_get_isTrue() {
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Flower");
		assertEquals(
				true,
				powerSetOnHashTableSecond.get("Flower"));
	}

	@Test
	public void test_difference_twoPowerSet() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		PowerSet powerSetDifference = new PowerSet();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableOne.put("Apple");
		powerSetOnHashTableOne.put("Orange");
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Flower");
		powerSetDifference = powerSetOnHashTableOne.difference(powerSetOnHashTableSecond);
		assertEquals(
				3,
				powerSetDifference.size());
	}

	@Test
	public void test_difference_twoPowerSet_isEmpty() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOnHashTableOne.put("World");
		powerSetOnHashTableOne.put("Orange");
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Orange");
		powerSetUnion = powerSetOnHashTableOne.difference(powerSetOnHashTableSecond);
		assertEquals(
				0,
				powerSetUnion.size());
	}

	@Test
	public void test_isSubset_notAllElementsOfParameterIncludesInPoserSet() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
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
	public void test_isSubset_allElementsOfParameterIncludesInPoserSet() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
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

	@Test
	public void test_isSubset_twoPowerSet_allElementsOfPowerSetIncludesInParameter() {
		PowerSet powerSetOnHashTableOne = new PowerSet();
		PowerSet powerSetOnHashTableSecond = new PowerSet();
		powerSetOnHashTableOne.put("Hello");
		powerSetOnHashTableOne.put("Apple");
		powerSetOnHashTableOne.put("Orange");
		powerSetOnHashTableSecond.put("World");
		powerSetOnHashTableSecond.put("Hello");
		powerSetOnHashTableSecond.put("Apple");
		powerSetOnHashTableSecond.put("Orange");
		powerSetOnHashTableSecond.put("Flower");
		assertEquals(
				false,
				powerSetOnHashTableOne.isSubset(powerSetOnHashTableSecond));
	}

}
