package com.sabeshkin.bloomfilter;

public class BloomFilter {
	public int filter_len;
	private int[] filter;
	public BloomFilter(int f_len) {
		filter_len = f_len;
		filter = new int[filter_len];
		// создаём битовый массив длиной f_len ...
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
			// cast char to int
			sum = ((sum*entropy) + charArr[i] - '0') % filter_len;
		}
		return sum;
	}
	
	public void add(String str1) {
		int indexFirst = hash1(str1);
		int indexSecond = hash2(str1);
		filter[indexFirst] = 1;
		filter[indexSecond] = 1;
		// добавляем строку str1 в фильтр
	}

	public boolean isValue(String str1) {
		// проверка, имеется ли строка str1 в фильтре
		int indexFirst = hash1(str1);
		int indexSecond = hash2(str1);
		if(filter[indexFirst]==1 && filter[indexSecond] == 1){
			return true;
		}else{
			return false;	
		}
	}
}
