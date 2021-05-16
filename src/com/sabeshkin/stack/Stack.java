package com.sabeshkin.stack;

import java.util.*;

public class Stack<T> {
	LinkedList<T> linkedList;
	public Stack() {
		// инициализация внутреннего хранилища стека
		linkedList = new LinkedList<>();
	}
	
	public int size() {
		return linkedList.size();
	}

	public T pop() {
		try{
			return linkedList.pop();
		}catch(NoSuchElementException exception){
			return null;
		}
		// return null; // если стек пустой
	}

	public void push(T val) {
		linkedList.push(val);
		// ваш код
	}

	public T peek() {
		return linkedList.peek();
		// return null; // если стек пустой
	}
}