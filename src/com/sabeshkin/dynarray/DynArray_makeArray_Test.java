package com.sabeshkin.dynarray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class DynArray_makeArray_Test {
	DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
	Integer item;
	@Test
	public void test_append_eightyItems_capacityIsThirtyTwo() {
		for (int i = 0; i < 18; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		assertEquals(
				32,
				dynArray.capacity);
	}
	
	@Test
	public void test_append_makeArrayCapacityTwentyOne_getItemSeventeenIsSeventeen() {
		for (int i = 0; i < 18; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		dynArray.makeArray(21);
		assertEquals(
				new Integer(17),
				dynArray.getItem(17));
	}
	
	@Test
	public void test_append_makeArrayCapacityTwentyOne_capacityIsTwentyOne() {
		for (int i = 0; i < 31; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		
		for (int i = 0; i < 16; i++){
			dynArray.remove(i);
		}
		assertEquals(
				21,
				dynArray.capacity);
	}
	
	@Test
	public void test_append_makeArrayCapacityTwentyOne_getItemTwentyOneIsThirtyOne() {
		for (int i = 0; i < 32; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		
		for (int i = 14; i >= 0; i--){
			dynArray.remove(i);
		}
		assertEquals(
				new Integer(31),
				dynArray.getItem(16));
	}

}
