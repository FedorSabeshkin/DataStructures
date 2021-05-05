package com.sabeshkin.dynarray;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynArray_remove_Test {

	DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
	Integer item;
	
	@Test
	public void test_Remove_getZeroElementWithoutMethod() {
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(0);
		assertEquals(
				null,
				dynArray.array[0]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_Remove_unexistElementIndex_isIllegalArgumentException() {
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(6);
		dynArray.remove(5);
		assertEquals(
				new Integer(23),
				dynArray.getItem(23));
	}
	
	@Test
	public void test_Remove_capacityIsSixteen() {
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		
		for (int i = 0; i < 10; i++){
			dynArray.remove(i);
		}
		assertEquals(
				16,
				dynArray.capacity);
	}
	
	@Test
	public void test_Remove_countIsSeven() {
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		
		for (int i = 0; i < 10; i++){
			dynArray.remove(i);
		}
		assertEquals(
				7,
				dynArray.count);
	}

	@Test
	public void test_Remove_zeroElementIsNull() {
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(0);
		assertEquals(
				null,
				dynArray.getItem(0));
	}

	DynArray<Integer> dynArrayEmpty = new DynArray<Integer>(Integer.class);

	@Test
	public void test_Remove_fromEmptyArr_fifthElementIsNull() {
		dynArrayEmpty.remove(5);
		assertEquals(
				null,
				dynArrayEmpty.getItem(5));
	}

	@Test
	public void test_Remove_fifthElementIsNull() {
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(5);
		assertEquals(
				null,
				dynArray.getItem(5));
	}

	@Test
	public void test_Remove_sixthElementIsNull() {
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(6);
		dynArray.remove(5);
		assertEquals(
				null,
				dynArray.getItem(6));
	}

	@Test
	public void test_Remove_capacityIsTwentyOne() {
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(6);
		dynArray.remove(5);
		assertEquals(
				21,
				dynArray.capacity);
	}

	@Test
	public void test_Remove_seventhElementIsNull() {
		for (int i = 0; i < 18; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(7);
		assertEquals(
				null,
				dynArray.getItem(7));
	}

	@Test
	public void test_Remove_capacityIsThirtyTwo() {
		for (int i = 0; i < 18; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(6);
		assertEquals(
				32,
				dynArray.capacity);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Remove_negativeIndex_illegalArgumentException() {
		for (int i = 0; i < 16; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(-1);
		assertEquals(
				new Integer(10),
				dynArray.getItem(6));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Remove_oneHundredIndex_illegalArgumentException() {
		for (int i = 0; i < 16; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(100);
		assertEquals(
				new Integer(10),
				dynArray.getItem(6));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Remove_outOfCapacityIndex_illegalArgumentException() {
		for (int i = 0; i < 16; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(16);
		assertEquals(
				new Integer(10),
				dynArray.getItem(6));
	}

}
