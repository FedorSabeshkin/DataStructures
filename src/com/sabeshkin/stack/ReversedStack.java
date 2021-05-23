package com.sabeshkin.stack;
import java.util.*;
public class ReversedStack<T> {
	LinkedList<T> linkedList;
	public ReversedStack() {
		linkedList = new LinkedList<>();
	}

	public int size() {
		return linkedList.size();
	}

	public T pop() {
		try{
			return linkedList.removeFirst();
		}catch(NoSuchElementException exception){
			return null;
		}
	}

	public void push(T val) {
		linkedList.addFirst(val);
	}

	public T peek() {
		return linkedList.peekFirst();
	}
}
