package com.sabeshkin.dynarray;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynArray_getItem_Test {
	DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
	Integer item;
	
	@Test(expected = IllegalArgumentException.class)
	public void test_getItem_IllegalArgumentException() {
		for (int i = 0; i < 14; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		assertEquals(
				new Integer(32),
				dynArray.getItem(17));
	}

}
