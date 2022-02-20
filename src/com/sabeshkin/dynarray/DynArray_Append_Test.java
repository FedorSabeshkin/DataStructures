package com.sabeshkin.dynarray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DynArray_Append_Test {
	DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
	@Test
	public void test_append_getItemZero_isSeventySeven() {
		Integer item = new Integer(77);
		dynArray.append(item);
		assertEquals(
				new Integer(77),
				dynArray.getItem(0));
	}
	
	@Test
	public void test_append_lastItem_isNull() {
		Integer item = new Integer(77);
		dynArray.append(item);
		assertEquals(
				null,
				dynArray.getItem(dynArray.count));
	}

}
