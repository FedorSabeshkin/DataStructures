package com.sabeshkin.dynarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynArray_getItem_Test {
	DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
	Integer item;

	@Test
	public void test_getItem_IllegalArgumentException() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		for (int i = 0; i < 14; i++){
			item = new Integer(i);
			dynArray.append(item);
		}
		assertEquals(
				new Integer(32),
				dynArray.getItem(17));
		});
	}

}
