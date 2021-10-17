package com.sabeshkin.powerset;

public class PowerSet {
	public int storeSize;
	private String[] slots;
	private int step = 3;
	private int count;

	public PowerSet() {
		storeSize = 20000;
		slots = new String[storeSize];
		count = 0;
		for (int i = 0; i < storeSize; i++){
			slots[i] = null;
		}
	}
	
	public PowerSet(int sizeOfStore) {
		storeSize = sizeOfStore;
		slots = new String[storeSize];
		count = 0;
		for (int i = 0; i < storeSize; i++){
			slots[i] = null;
		}
	}
	
	public String[] getSlots(){
		return slots;
	}

	public int size() {
		return count;
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
		return (sum % storeSize);
	}

	/**
	 * 
	 * @param value
	 * @return index after check collisions
	 */
	public int generateIndex(String value) {
		int i;
		i = hashFun(value);
		// check slot by step
		while(i < storeSize && slots[i] != null){
			if(slots[i].equals(value)){
				return -1;
			}
			i += step;
		}
		// check each slot
		if(i >= storeSize){
			i = 0;
			while(i < storeSize && slots[i] != null){
				if(slots[i].equals(value)){
					return -1;
				}
				i++;
			}
		}
		/**
		 * if have't free slot or already have this key
		 */
		if(i >= storeSize)
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
		if(slots[index] != null && slots[index].equals(key)){
			return true;
		} else{
			for (index = 0; index < slots.length; index++){
				if(slots[index] != null && slots[index].equals(key)){
					return true;
				}
			}
		}
		return false;
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
			for (i = 0; i < storeSize; i++){
				if(slots[i] != null && slots[i].equals(key))
					return i;
			}
			return -1;
		}
	}

	/**
	 * Set value to store
	 * 
	 * @param value
	 */
	public void put(String value) {
		int index = 0;
		index = generateIndex(value);
		if(index != -1){
			slots[index] = value;
			count++;
		}
	}

	/**
	 * 
	 * @param value
	 * @return true or false if key don't exist
	 */
	public boolean get(String value) {
		int index = find(value);
		if(index != (-1)){
			return true;
		} else{
			return false;
		}
	}

	public boolean remove(String value) {
		int index = find(value);
		if(index != (-1)){
			slots[index] = null;
			count--;
			return true;
		} else{
			return false;
		}
	}

	public PowerSet intersection(PowerSet set2) {
		PowerSet setOfIntersection = new PowerSet(storeSize);
		String[] slotsForInsert = getSlots();
		for (int i = 0; i < storeSize; i++){
			if(slotsForInsert[i] != null){
				if(set2.get(slotsForInsert[i])){
					setOfIntersection.put(slotsForInsert[i]);		
				}
			}
		}
		return setOfIntersection;
	}

	public PowerSet union(PowerSet set2) {
		int maxUnionedSize = 2*storeSize;
		PowerSet unionedSet = new PowerSet(maxUnionedSize);
		String[] slotsForInsert = getSlots();
		String[] slotsForInsert2 = set2.getSlots();
		for (int i = 0; i < storeSize; i++){
			if(slotsForInsert[i] != null){
				unionedSet.put(slotsForInsert[i]);	
			}
		}
		for (int i = 0; i < storeSize; i++){
			if(slotsForInsert2[i] != null){
				unionedSet.put(slotsForInsert2[i]);
			}
		}
		return unionedSet;
	}

	public PowerSet difference(PowerSet set2) {
		PowerSet setOfDifference = new PowerSet(storeSize);
		String[] slotsForInsert = getSlots();
		for (int i = 0; i < storeSize; i++){
			if(slotsForInsert[i] != null) {
				if(!set2.get(slotsForInsert[i])){
					setOfDifference.put(slotsForInsert[i]);		
				}
			}
		}
		return setOfDifference;
	}

	public boolean isSubset(PowerSet set2) {
		String[] slotsForInsert2 = set2.getSlots();
		for (int i = 0; i < 20_000; i++){
			if(slotsForInsert2[i] != null){
				if(!get(slotsForInsert2[i])){
					return false;
				}
			}
		}
		return true;
	}
}