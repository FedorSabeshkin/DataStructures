package com.sabeshkin.hashtable;

public class HashTable {
	public int size;
	public int step;
	public String[] slots;

	public HashTable(int sz, int stp) {
		size = sz;
		step = stp;
		slots = new String[size];
		for (int i = 0; i < size; i++)
			slots[i] = null;
	}

	/*
	 * return index of value
	 */
	public int hashFun(String value) {
		char[] a = new char[value.length()];
		int sum = 0;
		for (int i = 0; i < value.length(); i++){
			a[i] = value.charAt(i);
			sum += a[i] - '0';
		}
		return (sum % size);
	}

	/*
	 * return index after check collisions
	 */
	public int seekSlot(String value) {
		int i;
		i = hashFun(value);
		while(i < size && slots[i] != null){
			i += step;
		}
		if(i >= size){
			i = 0;
			while(i < size && slots[i] != null)
				i++;
		}
		if(i >= size)
			return -1;
		return i;
	}

	/*
	 * put value to hash table
	 */
	public int put(String value) {
		int i;
		i = seekSlot(value);
		if(i != -1){
			slots[i] = value;
		}
		return i;
	}

	/**
	 * 
	 * @param value - for search
	 * @return index of found value
	 */
	public int find(String value) {
		int i = hashFun(value);
        if (value == slots[i])
            return i;
        else
        {
            for (i = 0; i < size; i++)
                if (slots[i] == value)
                    return i;
            return -1;
        }
	}
}