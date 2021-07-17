package com.sabeshkin.powerset;

public class PowerSetOnHashTable {
	public int storeSize;
	private String[] slots;
	private int step = 3;
	private int count;

	public PowerSetOnHashTable() {
		storeSize = 20000;
		slots = new String[storeSize];
		count = 0;
		for (int i = 0; i < storeSize; i++){
			slots[i] = null;
		}
	}
	
	public PowerSetOnHashTable(int sizeOfStore) {
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
	 * @param key
	 * @return index after check collisions
	 */
	public int generateIndex(String key) {
		int i;
		i = hashFun(key);
		// check slot by step
		while(i < storeSize && slots[i] != null){
			if(slots[i].equals(key))
				break;
			i += step;
		}
		// check each slot
		if(i >= storeSize){
			i = 0;
			while(i < storeSize && slots[i] != null){
				if(slots[i].equals(key))
					break;
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
			return true;
		} else{
			return false;
		}
	}

	public PowerSetOnHashTable intersection(PowerSetOnHashTable set2) {
		PowerSetOnHashTable powerSet = new PowerSetOnHashTable(20_000);
		String[] slotsForInsert = getSlots();
		String[] slotsForInsert2 = set2.getSlots();
		for (int i = 0; i < 20_000; i++){
			if(slotsForInsert[i] != null && slotsForInsert2[i] != null){
				if(set2.get(slotsForInsert[i])){
					powerSet.put(slotsForInsert[i]);		
				}
			}
		}
		return powerSet;
	}

	public PowerSetOnHashTable union(PowerSetOnHashTable set2) {
		PowerSetOnHashTable powerSet = new PowerSetOnHashTable(40_000);
		String[] slotsForInsert = getSlots();
		String[] slotsForInsert2 = set2.getSlots();
		for (int i = 0; i < 20_000; i++){
			if(slotsForInsert[i] != null){
				powerSet.put(slotsForInsert[i]);	
			}
		}
		for (int i = 0; i < 20_000; i++){
			if(slotsForInsert2[i] != null){
				powerSet.put(slotsForInsert2[i]);
			}
		}
		return powerSet;
	}

	public PowerSetOnHashTable difference(PowerSetOnHashTable set2) {
		PowerSetOnHashTable powerSet = new PowerSetOnHashTable(20_000);
		String[] slotsForInsert = getSlots();
		String[] slotsForInsert2 = set2.getSlots();
		for (int i = 0; i < 20_000; i++){
			if(slotsForInsert[i] != null) {
				String value = slotsForInsert[i];
				boolean isExist = set2.get(value);
				if(!isExist){
					powerSet.put(slotsForInsert[i]);		
				}
			}
		}
		return powerSet;
	}

	public boolean isSubset(PowerSetOnHashTable set2) {
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