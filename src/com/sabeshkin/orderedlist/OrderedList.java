package com.sabeshkin.orderedlist;

import java.util.*;

class Node<T> {
	public T value;
	public Node<T> next, prev;

	public Node(T _value) {
		value = _value;
		next = null;
		prev = null;
	}
}

public class OrderedList<T> {
	public Node<T> head, tail;
	private boolean _ascending;
	private int size;

	public OrderedList(boolean asc) {
		head = null;
		tail = null;
		_ascending = asc;
		size = 0;
	}

	public int compare(T v1, T v2) {
		int compareResult = 0;
		if(v1.getClass() == Integer.class){
			compareResult = ((Integer) v1).compareTo((Integer) v2);
		}
		return compareResult;
	}

	public void add(T value) {
		if(head == null){
			head = new Node(value);
			tail = new Node(value);
			head.next = tail;
			tail.prev = head;
		} else{
			Node<T> node = head;
			while(node != null){
				int result = compare(node.value, value);
//				switch(result){
//				0: 
//					break;
//				-1:
//					Node<T> oldNext = node.next;
//					node.next = new Node(value);
//					node.next.next = oldNext;
//					oldNext.prev = node.next;
//					break;
//				1: 
//					break;
//				
//				}
//				node = node.next;
			}
		}
	}

	public Node<T> find(T val) {
		return null; 
	}

	public void delete(T val) {
		
	}

	public void clear(boolean asc) {
		_ascending = asc;
		this.head = null;
		this.tail = null;
	}

	public int count() {
		return 0; 
	}

	ArrayList<Node<T>> getAll() {
		ArrayList<Node<T>> r = new ArrayList<Node<T>>();
		Node<T> node = head;
		while(node != null){
			r.add(node);
			node = node.next;
		}
		return r;
	}
}