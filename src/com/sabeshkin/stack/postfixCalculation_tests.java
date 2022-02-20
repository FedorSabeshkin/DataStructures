package com.sabeshkin.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class postfixCalculation_tests {

	@Test
	public void test() {
		assertEquals(
				59,
				Stack.postfixCalculation("8 2 + 5 * 9 + ="));
	}
	
	@Test
	public void test_second() {
		assertEquals(
				200,
				Stack.postfixCalculation("10 20 + 5 * 50 + ="));
	}

}
