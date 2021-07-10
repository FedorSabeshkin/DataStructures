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
			sum += (int) charArr[i] - '0';
		}
		return (sum % size);
	}

	/**
	 * 
	 * @param key
	 * @return index after check collisions
	 */
	public int generateIndex(String key) {
		int i;
		i = hashFun(key);
		// check slot by step
		while(i < size && slots[i] != null){
			if(slots[i].equals(key))
				break;
			i += step;
		}
		// check each slot
		if(i >= size){
			i = 0;
			while(i < size && slots[i] != null){
				if(slots[i].equals(key))
					break;
				i++;
			}
		}
		/**
		 * if have't free slot or already have this key
		 */
		if(i >= size)
			return -1;
		return i;
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
			for (int i = 0; i < slots.length; i++)
				if(slots[index].equals(key)){
					return true;
				}
		}
		return false;
	}

	/**
	 * Set value by key
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, T value) {
		int index = 0;
		index = generateIndex(key);
		if(index != -1){
			slots[index] = key;
			values[index] = value;
		}
	}

	/**
	 * 
	 * @param value
	 *            for search
	 * @return index of found value
	 */
	public int find(String key) {
		int i = hashFun(key);
		if(key.equals(slots[i]))
			return i;
		else{
			for (i = 0; i < size; i++)
				if(slots[i] != null && slots[i].equals(key))
					return i;
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