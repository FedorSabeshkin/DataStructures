package com.sabeshkin.nativedictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {
	public int size;
	public String[] slots;
	public T[] values;

	public NativeDictionary(int sz, Class clazz) {
		size = sz;
		slots = new String[size];
		values = (T[]) Array.newInstance(clazz, this.size);
	}

	/**
	 * 
	 * @param key
	 * @return index of slots
	 */
	public int hashFun(String key) {
		
		return 0;
	}

	/**
	 * 
	 * @param key
	 * @return check key is exist 
 	 */
	public boolean isKey(String key) {
		return false;
	}

	/**
	 * Set value by key
	 * @param key
	 * @param value
	 */
	public void put(String key, T value) {
	}

	/**
	 * 
	 * @param key
	 * @return value by key or null if key don't exit
	 */
	public T get(String key) {
		return null;
	}
}