package com.sabeshkin.dynarray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynArray_remove_Test {

	DynArray<Integer> dynArray;
	Integer item;

	@Test
	public void test_Remove_manyTimeFirstElement_lastElementIsNotEqualPreLastElement() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		for (int i = 0; i < 2; i++){
			dynArray.remove(1);
		}
		Integer lastElement = dynArray.getItem(dynArray.count - 1);
		Integer preLastElement = dynArray.getItem(dynArray.count - 2);
		assertNotEquals(
				preLastElement,
				lastElement);
	}

	@Test
	public void test_Remove_manyTimeFirstElement_zeroElementIsZero() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		for (int i = 0; i <= 15; i++){
			dynArray.remove(1);
		}
		assertEquals(
				new Integer(0),
				dynArray.getItem(0));
	}

	@Test
	public void test_Remove_getZeroElementWithoutMethod() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(0);
		assertEquals(
				new Integer(1),
				dynArray.array[0]);
	}

	@Test
	public void test_Remove_unexistElementIndex_isIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			dynArray = new DynArray<Integer>(Integer.class);
			for (int i = 0; i < 17; i++) {
				item = new Integer(i);
				dynArray.append(item);
			}
			dynArray.remove(6);
			dynArray.remove(5);
			assertEquals(
					new Integer(23),
					dynArray.getItem(23));
		});
	}

	@Test
	public void test_Remove_capacityIsSixteen() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}

		for (int i = 10; i >= 0; i--){
			dynArray.remove(i);
		}
		assertEquals(
				16,
				dynArray.capacity);
	}

	@Test
	public void test_Remove_countIsSix() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}

		for (int i = 10; i >= 0; i--){
			dynArray.remove(i);
		}
		assertEquals(
				6,
				dynArray.count);
	}

	@Test
	public void test_Remove_zeroElementIsNull() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(0);
		assertEquals(
				new Integer(1),
				dynArray.getItem(0));
	}

	DynArray<Integer> dynArrayEmpty = new DynArray<Integer>(Integer.class);

	@Test
	public void test_Remove_fromEmptyArr_fifthElementIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			dynArrayEmpty.remove(5);
			assertEquals(
					null,
					dynArrayEmpty.getItem(5));
		});
	}

	@Test
	public void test_Remove_fifthElementIsSix() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(5);
		assertEquals(
				new Integer(6),
				dynArray.getItem(5));
	}

	@Test
	public void test_Remove_sixthElementIsEight() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 17; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(6);
		dynArray.remove(5);
		assertEquals(
				new Integer(8),
				dynArray.getItem(6));
	}

	@Test
	public void test_Remove_capacityIsTwentyOne() {
		dynArray = new DynArray<Integer>(Integer.class);
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
	public void test_Remove_seventhElementIsEight() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 18; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(7);
		assertEquals(
				new Integer(8),
				dynArray.getItem(7));
	}

	@Test
	public void test_Remove_capacityIsThirtyTwo() {
		dynArray = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 18; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.remove(6);
		assertEquals(
				32,
				dynArray.capacity);
	}

	@Test
	public void test_Remove_negativeIndex_illegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			dynArray = new DynArray<Integer>(Integer.class);
			for (int i = 0; i < 16; i++) {
				item = new Integer(i);
				dynArray.append(item);
			}
			dynArray.remove(-1);
			assertEquals(
					new Integer(10),
					dynArray.getItem(6));
		});
	}

	@Test
	public void test_Remove_oneHundredIndex_illegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			dynArray = new DynArray<Integer>(Integer.class);
			for (int i = 0; i < 16; i++) {
				item = new Integer(i);
				dynArray.append(item);
			}
			dynArray.remove(100);
			assertEquals(
					new Integer(10),
					dynArray.getItem(6));
		});
	}

	@Test
	public void test_Remove_outOfCapacityIndex_illegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			dynArray = new DynArray<Integer>(Integer.class);
			for (int i = 0; i < 16; i++) {
				item = new Integer(i);
				dynArray.append(item);
			}
			dynArray.remove(16);
			assertEquals(
					new Integer(10),
					dynArray.getItem(6));
		});
	}

}
