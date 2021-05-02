package com.sabeshkin.dynarray;

public class DynArray<T> {
	// наша базовая структура данных
	public T[] array;
	// сколько эллементов у нас в массиве
	public int count;
	// какая его максимальная емкость
	public int capacity;
	Class clazz;

	public DynArray(Class clz) {
		clazz = clz; // нужен для безопасного приведения типов
		// new DynArray<Integer>(Integer.class);
		count = 0;
		makeArray(16);
	}

	/**
	 * Update capacity value and copy
	 * 
	 * @param new_capacity
	 */
	public void makeArray(int new_capacity) {
		// array = (T[]) Array.newInstance(this.clazz, new_capacity);
		// ваш код
		int oldCapacity = this.capacity;
		if(count == 0){
			this.array = (T[]) new Class[new_capacity];
		} else{
			T[] newArray = (T[]) new Class[new_capacity];
			if(oldCapacity < new_capacity){
				System.arraycopy(this.array, 0, newArray, 0, this.array.length);
			}
			if(oldCapacity > new_capacity){
				System.arraycopy(this.array, 0, newArray, 0, newArray.length);
			}
		}
		this.capacity = new_capacity;
	}

	public T getItem(int index) {
		if(index < 0 || index >= capacity){
			throw new IllegalArgumentException("The passed index out of possible range");
		} else{
			return array[index];
		}
	}

	/**
	 * Add element to array. If capacity is exhausted, then create new array
	 * with capacity*2
	 * 
	 * @param itm
	 */
	public void append(T itm) {
		if((count + 1) > this.capacity){
			makeArray(this.capacity * 2);
		}
		array[count] = itm;
		count++;
	}

	public void insert(T itm, int index) {
		// ваш код
	}

	public void remove(int index) {
		// ваш код
	}

}