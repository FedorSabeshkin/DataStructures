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

	// O(n)
	/**
	 * Update capacity value and copy
	 * 
	 * @param new_capacity
	 */
	@SuppressWarnings("unchecked")
	public void makeArray(int new_capacity) {
		// array = (T[]) Array.newInstance(this.clazz, new_capacity);
		int oldCapacity = this.capacity;
		if(count == 0){
			this.array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
		} else{
			T[] newArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
			if(oldCapacity < new_capacity){
				System.arraycopy(this.array, 0, newArray, 0, this.array.length);
			}
			if(oldCapacity > new_capacity){
				System.arraycopy(this.array, 0, newArray, 0, newArray.length);
			}
			this.array = newArray;
		}
		this.capacity = new_capacity;
	}

	public T getItem(int index) {
		if(index < 0 || index >= capacity){
			throw new IllegalArgumentException("The passed index out of possible range");
		} else{
			return this.array[index];
		}
	}

	/**
	 * Add element to array. If capacity is exhausted, then create new array
	 * with capacity*2
	 * 
	 * @param itm
	 */
	public void append(T itm) {
		if((this.count + 1) > this.capacity){
			makeArray(this.capacity * 2);
		}
		this.array[count] = itm;
		this.count++;
	}

	// O(n)
	public void insert(T itm, int index) {
		if(index < 0 || index >= (capacity + 2)){
			throw new IllegalArgumentException("The passed index out of possible range");
		}
		if((this.count + 1) > this.capacity){
			makeArray(this.capacity * 2);
		}
		if(index == (this.count - 1)){
			append(itm);
		} else{
			// создание копии элементов, которые будут сдвигаться
			int sizeOfThePart = this.count - index;
			@SuppressWarnings("unchecked")
			T[] copyPartOfArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, sizeOfThePart);
			System.arraycopy(this.array, index, copyPartOfArray, 0, sizeOfThePart);
			// создание resultArr
			int newCapacity = ((this.count + 1) > this.capacity) ? this.capacity * 2 : this.capacity;
			// O(n)
			if(newCapacity != this.capacity){
				makeArray(newCapacity);
			}
			this.array[index] = itm;
			// склеивание значений из части исходного массива + новый элемент
			// и массива в котором хранил копии элементов из исходного
			System.arraycopy(copyPartOfArray, 0, this.array, index + 1, sizeOfThePart);
			this.count++;
		}
	}

	// TODO: Выполнять смещение эллементов с права на лево
	// после удаления элемента

	// O(n)
	public void remove(int index) {
		// O(1)
		if(index < 0 || index >= this.capacity){
			throw new IllegalArgumentException("The passed index out of possible range");
		}

		// создание копии элементов, которые будут сдвигаться
		int sizeOfThePart = this.count - index -1;
		if(sizeOfThePart < 1){
			sizeOfThePart = this.capacity - this.count;
		}
		@SuppressWarnings("unchecked")
		T[] copyPartOfArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, sizeOfThePart);
		System.arraycopy(this.array, index + 1, copyPartOfArray, 0, sizeOfThePart);
		this.array[index] = null;
		// склеивание значений из части исходного массива, с окошком на месте
		// удаленного
		// и массива в котором хранил копии элементов из исходного
		System.arraycopy(copyPartOfArray, 0, this.array, index, sizeOfThePart);
		// O(1)
		if(this.count - 1 < (this.capacity / 2)){
			// O(1)
			int newCapacity = (int) ((this.capacity / 1.5 < 16) ? 16 : this.capacity / 1.5);
			// O(n)
			makeArray(newCapacity);
		}
		this.count--;

	}

}