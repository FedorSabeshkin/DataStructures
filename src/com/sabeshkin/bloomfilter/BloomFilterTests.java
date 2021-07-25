package com.sabeshkin.bloomfilter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BloomFilterTests {

	
	public static String moveChain(String str){
		String lastLetter = str.substring(str.length()-1);
		String movedChain = lastLetter + str.substring(0, str.length()-1);
		return movedChain;
	}
	
	@Test
	public void test_add_isValue_true() {
		BloomFilter bloomFilter = new BloomFilter(32);
		bloomFilter.add("0123456789");
		assertEquals(
				true,
				bloomFilter.isValue("0123456789"));
	}
	
	@Test
	public void test_add_isValue_false() {
		BloomFilter bloomFilter = new BloomFilter(32);
		bloomFilter.add("0123456789");
		assertEquals(
				false,
				bloomFilter.isValue("7123456789"));
	}
	
	@Test
	public void test_add_tenDifferentValues_isValue_true() {
		BloomFilter bloomFilter = new BloomFilter(32);
		String str = "0123456789";
		bloomFilter.add(str);
		for(int i = 0; i<9; i++){
			str = moveChain(str);
			bloomFilter.add(str);
		}	
		assertEquals(
				true,
				bloomFilter.isValue("8901234567"));
	}
	
	@Test
	public void test_add_tenDifferentValues_differentOrder_isValue_true() {
		BloomFilter bloomFilter = new BloomFilter(32);
		String str = "0123456789";
		bloomFilter.add(str);
		for(int i = 9; i>0; i--){
			str = moveChain(str);
			bloomFilter.add(str);
		}	
		assertEquals(
				true,
				bloomFilter.isValue("8901234567"));
	}
	
	@Test
	public void test_isValue_checkAllRight_true() {
		BloomFilter bloomFilter = new BloomFilter(32);
		String str = "0123456789";
		bloomFilter.add(str);
		for(int i = 9; i>0; i--){
			str = moveChain(str);
			bloomFilter.add(str);
		}	
		boolean isAllInBloomFilter = true;
		for(int i = 0; i<10; i++){
			isAllInBloomFilter = bloomFilter.isValue(str)&&isAllInBloomFilter;
			str = moveChain(str);
		}	
		assertEquals(
				true,
				isAllInBloomFilter);
	}
	
	@Test
	public void test_add_tenDifferentValues_isValue_false() {
		BloomFilter bloomFilter = new BloomFilter(32);
		String str = "0123456789";
		bloomFilter.add(str);
		for(int i = 0; i<8; i++){
			str = moveChain(str);
			bloomFilter.add(str);
		}	
		assertEquals(
				false,
				bloomFilter.isValue("1234567890"));
	}
	
}
