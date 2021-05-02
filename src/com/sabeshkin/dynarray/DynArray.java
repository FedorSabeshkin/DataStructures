package com.sabeshkin.dynarray;

public class DynArray<T> {
	// наша базовая структура данных
	public T[] array;
	// сколько элементов у нас в массиве
	public int count;
	// какая его максимальная емкость
	public int capacity;
	/*
	 * Нужен для внутренней работы, что бы мы после инициалищации объекта не
	 * смогли добавлять элементы другого типа
	 */
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
		int oldCapacity = this.capacity;
		if(count == 0){
			this.array = (T[]) new Object[new_capacity];
		} else{
			T[] newArray = (T[]) new Object[new_capacity];
			if(oldCapacity < new_capacity){
				System.arraycopy(this.array, 0, newArray, 0, this.array.length);
			}
			if(oldCapacity > new_capacity){
				System.arraycopy(this.array, 0, newArray, 0, newArray.length);
			}
			array = newArray;
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
		this.array[count] = itm;
		this.count++;
	}

	public void insert(T itm, int index) {
		if(index < 0 || index >= (capacity + 2)){
			throw new IllegalArgumentException("The passed index out of possible range");
		}
		if((count + 1) > this.capacity){
			makeArray(this.capacity * 2);
		}
		if(index == (count - 1)){
			append(itm);
		} else{
			// создание копии элементов, которые будут сдвигаться
			int sizeOfThePart = this.count - index;
			T[] copyPartOfArray = (T[]) new Object[sizeOfThePart];
			System.arraycopy(this.array, index, copyPartOfArray, 0, sizeOfThePart);
			// создание resultArr
			int sizeOfResultArr = ((count + 1) > this.capacity) ? this.capacity * 2 : this.capacity;
			T[] resultArr = (T[]) new Object[sizeOfResultArr];
			this.array[index] = itm;
			// склеивание значений из части исходного массива + новый элемент
			// и массива в котором хранил копии элементов из исходного
			System.arraycopy(this.array, 0, resultArr, 0, index + 1);
			System.arraycopy(copyPartOfArray, 0, resultArr, index + 1, sizeOfThePart);
			this.array = resultArr;
			this.count++;
		}
	}

	public void remove(int index) {
		if(index < 0 || index >= capacity){
			throw new IllegalArgumentException("The passed index out of possible range");
		}
		// проверь услови при котором смогу сюда заходить
		if(count - 1 < (this.capacity / 2)){
			int newCapacity = (int) ((this.capacity / 1.5 < 16) ? 16 : this.capacity / 1.5);
			makeArray(newCapacity);
		}
		this.array[index] = null;
		this.count--;

	}

}