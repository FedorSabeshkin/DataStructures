package com.sabeshkin.nativedictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {
	public int size;
	public String[] slots;
	public T[] values;
	public int step = 3;

	public NativeDictionary(int sz, Class clazz) {
		size = sz;
		slots = new String[size];
		values = (T[]) Array.newInstance(clazz, this.size);
		for (int i = 0; i < size; i++)
			slots[i] = null;
	}

	/**
	 * 
	 * @param key
	 * @return index of slots
	 */
	public int hashFun(String key) {
		char[] charArr = new char[key.length()];
		int sum = 0;
		for (int i = 0; i < key.length(); i++){
			charArr[i] = key.charAt(i);
			// cast char to int
			sum += charArr[i] - '0';
		}
		return (sum % size);
	}



	/**
	 * 
	 * @param key
	 * @return check key is exist
	 */
	public boolean isKey(String key) {
		int index = 0;
		index = hashFun(key);
		if(slots[index] == key){
			return true;
		} else{
			return false;
		}
		
	}

	/**
	 * Set value by key
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, T value) {
		int index = 0;
		index = hashFun(key);
		slots[index] = key;
		values[index] = value;
	}

	/**
	 * 
	 * @param value
	 *            for search
	 * @return index of found value
	 */
	public int find(String value) {
		int i = hashFun(value);
		if(value == slots[i])
			return i;
		else{
			return -1;
		}
	}

	/**
	 * 
	 * @param key
	 * @return value by key or null if key don't exit
	 */
	public T get(String key) {
		int index = find(key);
		if(index != (-1)){
			return values[index];
		} else{
			return null;
		}
	}
}