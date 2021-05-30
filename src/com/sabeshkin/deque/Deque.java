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
		}
		catch(NoSuchElementException exception){
			return null;
		}
	}

	public T removeTail() {
		// удаление из хвоста
		try{
			element = linkedList.removeLast();
			count--;
			return element;
		}
		catch(NoSuchElementException exception){
			return null;
		}
	}

	public int size() {
		return count; // размер очереди
	}
}