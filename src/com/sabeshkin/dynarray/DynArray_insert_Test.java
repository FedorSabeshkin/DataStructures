package com.sabeshkin.dynarray;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynArray_insert_Test {
	DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
	Integer item;
	
	@Test
	public void test_Insert_lastElementIsNine() {
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.insert(new Integer(10), 5);
		assertEquals(
				new Integer(9),
				dynArray.getItem(10));
	}
	
	@Test
	public void test_Insert_indexIsEqualCount_lastElementIsNewElement() {
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.insert(new Integer(10), 9);
		assertEquals(
				new Integer(10),
				dynArray.getItem(10));
	}
	
	@Test
	public void test_Insert_multiplyToTwo_capacityIsThirtyTwo() {
		for (int i = 0; i < 16; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.insert(new Integer(10), 5);
		assertEquals(
				32,
				dynArray.capacity);
	}
	
	@Test
	public void test_Insert_multiplyToTwo_capacityIsSixtyFour() {
		for (int i = 0; i < 32; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.insert(new Integer(10), 5);
		assertEquals(
				64,
				dynArray.capacity);
	}
	
	@Test
	public void test_Insert_minCapacity_capasityIsSixteen() {
		for (int i = 0; i < 11; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.insert(new Integer(10), 5);
		assertEquals(
				16,
				dynArray.capacity);
	}
	
	@Test
	public void test_Insert_fifthElementIsTen() {
		for (int i = 0; i < 10; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.insert(new Integer(10), 5);
		assertEquals(
				new Integer(10),
				dynArray.getItem(5));
	}

	
	@Test
	public void test_Insert_sixthElementIsTen() {
		for (int i = 0; i < 16; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.insert(new Integer(10), 6);
		assertEquals(
				new Integer(10),
				dynArray.getItem(6));
	}
}
