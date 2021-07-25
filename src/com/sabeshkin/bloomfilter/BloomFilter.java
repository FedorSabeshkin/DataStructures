package com.sabeshkin.bloomfilter;

public class BloomFilter {
	public int filter_len;
	private int intOnlyFilter;
	public BloomFilter(int f_len) {
		filter_len = f_len;
		//filter = new int[filter_len];
		intOnlyFilter = 0x0_000_000_000;
	}

	public int change(int filter, int n) {
	    return filter | n;
	}
	
	public int hash1(String str1) {
		int entropy = 17;
		return hashFun(str1, entropy);
	}
	

	public int hash2(String str1) {
		int entropy = 223;
		return hashFun(str1, entropy);
	}

	/*
	 * return index of value
	 */
	public int hashFun(String value, int entropy) {
		char[] charArr = new char[value.length()];
		int sum = 0;
		for (int i = 0; i < value.length(); i++){
			charArr[i] = value.charAt(i);
			sum = ((sum*entropy) + charArr[i] - '0') % filter_len;
		}
		return sum;
	}
	
	public void add(String str1) {
		int indexFirst = hash1(str1);
		int indexSecond = hash2(str1);
		intOnlyFilter = change(intOnlyFilter, indexFirst);
		intOnlyFilter = change(intOnlyFilter, indexSecond);
	}

	public boolean isValue(String str1) {
		int indexFirst = hash1(str1);
		int indexSecond = hash2(str1);
		int mask = 0x0_000_000_000;
		mask = change(mask, indexFirst);
		mask = change(mask, indexSecond);
		if((intOnlyFilter & mask) ==  mask){
			return true;
		}else{
			return false;	
		}
	}
}
