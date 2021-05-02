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

}
