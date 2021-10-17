package com.sabeshkin.powerset;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerSetOnHashTableTest {
	
	@Test
	public void test_put_countIs_2() {
		PowerSet powerSet = new PowerSet();
		powerSet.put("Hello");
		powerSet.put("World");
		powerSet.put("Hello");
		assertEquals(
				2,
				powerSet.size());
	}

	@Test
	public void test_put_countIs_10_000() {
		PowerSet powerSetOne = new PowerSet();
		for (int i = 0; i < 10_000; i++){
			powerSetOne.put("World" + i);
		}
		for (int i = 5_000; i < 10_000; i++){
			powerSetOne.put("World" + i);
		}
		assertEquals(
				10_000,
				powerSetOne.size());
	}
	
	@Test
	public void test_removeTwiceSameValue_SecondCallIsFalse() {
		PowerSet powerSet = new PowerSet();
		powerSet.put("Hello");
		powerSet.put("World");
		powerSet.remove("Hello");
		assertEquals(
				false,
				powerSet.remove("Hello"));
	}

	@Test
	public void test_removeInsertedValue_isTrue() {
		PowerSet powerSet = new PowerSet();
		powerSet.put("Hello");
		powerSet.put("World");
		assertEquals(
				true,
				powerSet.remove("Hello"));
	}
	
	@Test
	public void test_removeInsertedValue_contIsOne() {
		PowerSet powerSet = new PowerSet();
		powerSet.put("Hello");
		powerSet.put("World");
		powerSet.remove("Hello");
		assertEquals(
				1,
				powerSet.size());
	}

	@Test
	public void test_removeInsertedValue_from_20_000_list_isTrue() {
		PowerSet powerSet = new PowerSet();
		for (int i = 0; i < 20_000; i++){
			powerSet.put("World" + i);
		}
		assertEquals(
				true,
				powerSet.remove("World10000"));
	}

	@Test
	public void test_union_twoPowerSet_twiceIsNotEmpty() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOne.put("Hello");
		powerSetSecond.put("World");
		powerSetUnion = powerSetOne.union(powerSetSecond);
		assertEquals(
				true,
				powerSetUnion.get("World"));
	}

	@Test
	public void test_union_twoPowerSet_oneIsEmpty() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOne.put("Hello");
		powerSetUnion = powerSetOne.union(powerSetSecond);
		assertEquals(
				1,
				powerSetUnion.size());
	}

	@Test
	public void test_union_twoPowerSet_20_000() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		for (int i = 0; i < 10_000; i++){
			powerSetOne.put("World" + i);
		}
		for (int i = 10_000; i < 20_000; i++){
			powerSetSecond.put("World" + i);
		}
		powerSetOne.put("Hello");
		powerSetUnion = powerSetOne.union(powerSetSecond);
		assertEquals(
				20_001,
				powerSetUnion.size());
	}
	
	@Test
	public void test_union_20_000_partOneIsSubsetAnother_countIs_10_000() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		for (int i = 0; i < 10_000; i++){
			powerSetOne.put("World" + i);
		}
		for (int i = 5_000; i < 10_000; i++){
			powerSetSecond.put("World" + i);
		}
		powerSetUnion = powerSetOne.union(powerSetSecond);
		assertEquals(
				10_000,
				powerSetUnion.size());
	}

	@Test
	public void test_intersection_twoPowerSet_notEmpty() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOne.put("Hello");
		powerSetOne.put("Apple");
		powerSetOne.put("Orange");
		powerSetSecond.put("World");
		powerSetSecond.put("Orange");
		powerSetUnion = powerSetOne.intersection(powerSetSecond);
		assertEquals(
				true,
				powerSetUnion.get("Orange"));
	}
	
	@Test
	public void test_intersection_twoPowerSet_notEmpty_countIsOne() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOne.put("Hello");
		powerSetOne.put("Apple");
		powerSetOne.put("Orange");
		powerSetSecond.put("World");
		powerSetSecond.put("Orange");
		powerSetUnion = powerSetOne.intersection(powerSetSecond);
		assertEquals(
				1,
				powerSetUnion.size());
	}

	@Test
	public void test_intersection_twoPowerSet_isEmpty() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOne.put("Hello");
		powerSetOne.put("Apple");
		powerSetOne.put("Orange");
		powerSetSecond.put("World");
		powerSetSecond.put("Flower");
		powerSetUnion = powerSetOne.intersection(powerSetSecond);
		assertEquals(
				0,
				powerSetUnion.size());
	}

	@Test
	public void test_intersection_bigTwoPowerSets_countIs_15_000() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetIntersection = new PowerSet();
		for (int i = 0; i < 20_000; i++){
			powerSetOne.put("World" + i);
		}
		for (int i = 5_000; i < 20_000; i++){
			powerSetSecond.put("World" + i);
		}
		powerSetIntersection = powerSetOne.intersection(powerSetSecond);
		assertEquals(
				15000,
				powerSetIntersection.size());
	}
	
	
	@Test
	public void test_get_isFalse() {
		PowerSet powerSetSecond = new PowerSet();
		powerSetSecond.put("World");
		powerSetSecond.put("Flower");
		assertEquals(
				false,
				powerSetSecond.get("Orange"));
	}

	@Test
	public void test_get_isTrue() {
		PowerSet powerSetSecond = new PowerSet();
		powerSetSecond.put("World");
		powerSetSecond.put("Flower");
		assertEquals(
				true,
				powerSetSecond.get("Flower"));
	}

	@Test
	public void test_difference_twoPowerSet() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetDifference = new PowerSet();
		powerSetOne.put("Hello");
		powerSetOne.put("Apple");
		powerSetOne.put("Orange");
		powerSetSecond.put("World");
		powerSetSecond.put("Flower");
		powerSetDifference = powerSetOne.difference(powerSetSecond);
		assertEquals(
				3,
				powerSetDifference.size());
	}

	@Test
	public void test_difference_twoPowerSet_isEmpty() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetUnion = new PowerSet();
		powerSetOne.put("World");
		powerSetOne.put("Orange");
		powerSetSecond.put("World");
		powerSetSecond.put("Orange");
		powerSetUnion = powerSetOne.difference(powerSetSecond);
		assertEquals(
				0,
				powerSetUnion.size());
	}
	
	@Test
	public void test_difference_bigTwoPowerSets_sizeIs_5_000() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		PowerSet powerSetIntersection = new PowerSet();
		for (int i = 0; i < 20_000; i++){
			powerSetOne.put("World" + i);
		}
		for (int i = 5_000; i < 20_000; i++){
			powerSetSecond.put("World" + i);
		}
		powerSetIntersection = powerSetOne.difference(powerSetSecond);
		assertEquals(
				5000,
				powerSetIntersection.size());
	}

	@Test
	public void test_isSubset_notAllElementsOfParameterIncludesInPoserSet() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		powerSetOne.put("Hello");
		powerSetOne.put("Apple");
		powerSetOne.put("Orange");
		powerSetSecond.put("World");
		powerSetSecond.put("Orange");
		assertEquals(
				false,
				powerSetOne.isSubset(powerSetSecond));
	}

	@Test
	public void test_isSubset_allElementsOfParameterIncludesInPoserSet() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		powerSetOne.put("Hello");
		powerSetOne.put("Apple");
		powerSetOne.put("Orange");
		powerSetOne.put("World");
		powerSetSecond.put("Apple");
		powerSetSecond.put("Orange");
		assertEquals(
				true,
				powerSetOne.isSubset(powerSetSecond));
	}

	@Test
	public void test_isSubset_twoPowerSet_allElementsOfPowerSetIncludesInParameter() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		powerSetOne.put("Hello");
		powerSetOne.put("Apple");
		powerSetOne.put("Orange");
		powerSetSecond.put("World");
		powerSetSecond.put("Hello");
		powerSetSecond.put("Apple");
		powerSetSecond.put("Orange");
		powerSetSecond.put("Flower");
		assertEquals(
				false,
				powerSetOne.isSubset(powerSetSecond));
	}
	
	@Test
	public void test_isSubset_bigTwoPowerSets_true() {
		PowerSet powerSetOne = new PowerSet();
		PowerSet powerSetSecond = new PowerSet();
		for (int i = 0; i < 20_000; i++){
			powerSetOne.put("World" + i);
		}
		for (int i = 5_000; i < 20_000; i++){
			powerSetSecond.put("World" + i);
		}
		assertEquals(
				true,
				powerSetOne.isSubset(powerSetSecond));
	}

}
