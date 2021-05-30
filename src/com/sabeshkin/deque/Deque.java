package com.sabeshkin.deque;

import java.util.*;

public class Deque<T> {
	LinkedList<T> linkedList;
	T element;
	int count;

	public Deque() {
		linkedList = new LinkedList<>();
		count = 0;
	}

	public void addFront(T item) {
		linkedList.addFirst(item);
		count++;
	}

	public void addTail(T item) {
		linkedList.addLast(item);
		count++;
	}

	public T removeFront() {
		try{
			element = linkedList.removeFirst();
			count--;
			return element;
		} catch (NoSuchElementException exception){
			return null;
		}
	}

	public T removeTail() {
		try{
			element = linkedList.removeLast();
			count--;
			return element;
		} catch (NoSuchElementException exception){
			return null;
		}
	}

	public int size() {
		return count;
	}

	public static boolean isPalindrom(String str) {
		Deque<String> deque = new Deque<>();
		str = str.toLowerCase();
		String[] stringArr = str.split("");
		for (int i = 0; i < str.length(); i++){
			deque.addTail(stringArr[i]);
		}
		while((deque.removeTail().equals(deque.removeFront())) && deque.size() > 0){
			continue;
		}
		if(deque.size() == 0 || deque.size() == 1)
			return true;

		return false;
	}
}