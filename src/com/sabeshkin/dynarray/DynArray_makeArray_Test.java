package com.sabeshkin.dynarray;

import static org.junit.Assert.*;

import org.junit.Test;


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

}
