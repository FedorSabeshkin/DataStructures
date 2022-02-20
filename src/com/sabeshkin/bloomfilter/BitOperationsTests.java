package com.sabeshkin.bloomfilter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BitOperationsTests {

	public int change(int filter, int n) {
	    return filter ^ n;
	}
	
	public int changeOr(int filter, int n) {
	    return filter | n;
	}
	
	@Test
	public void test_changeOr() {
		int filter = 0x0_000_000_000;
		filter = changeOr(filter, 2);
		System.out.println(Integer.toBinaryString(filter));
		assertEquals(
				0x0_000_000_000,
				Integer.toBinaryString(filter));
	}
	
	@Test
	public void test() {
		int filter = 0x0_000_000_000;
		filter = change(filter, 2);
		filter = change(filter, 4);
		System.out.println(Integer.toBinaryString(filter));
		assertEquals(
				0x0_000_000_000,
				Integer.toBinaryString(filter));
	}

}
