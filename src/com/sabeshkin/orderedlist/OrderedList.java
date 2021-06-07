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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(T value) {
		if(tail == null){
			addInTail(new Node(value));
		} else{
			Node<T> node = head;
			Node<T> addedNode;
			while(node != null){
				int compareResult = compare(value, node.value);
				switch (compareResult) {
				case 0:
					// when value equal actual node.value
					addedNode = new Node(value);
					insertAfter(node, addedNode);
					break;
				case (-1):
					// when value less, than actual node.value
					addedNode = new Node(value);
					insertAfter(node, addedNode);
					break;
				case 1:
					// when value bigger, than actual node.value
					addedNode = new Node(value);
					insertBefore(node,addedNode);
					break;

				}
				node = node.next;
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insertBefore(Node existingNode, Node _nodeToInsert) {
		if(this.count() > 0){
			if(isHead(existingNode)){
				insertBeforeHead(_nodeToInsert);
			} else{
				Node oldPrev = existingNode.prev;
				if(oldPrev != null){
					oldPrev.next = _nodeToInsert;
				}
				_nodeToInsert.prev = oldPrev;
				_nodeToInsert.next = existingNode;
				existingNode.prev = _nodeToInsert;
			}
		} else{
			addInTail(_nodeToInsert);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		if(this.count() > 0){
			if(isTail(_nodeAfter)){
				Node oldTail = this.tail;
				this.tail = _nodeToInsert;
				this.tail.prev = oldTail;
			}
			if(_nodeAfter != null){
				Node nodeAfterNext = _nodeAfter.next;
				if(nodeAfterNext != null){
					nodeAfterNext.prev = _nodeToInsert;
				}
				_nodeToInsert.next = nodeAfterNext;
				_nodeToInsert.prev = _nodeAfter;
				_nodeAfter.next = _nodeToInsert;
			} else{
				Node oldHead = this.head;
				_nodeToInsert.next = oldHead;
				oldHead.prev = _nodeToInsert;
				this.head = _nodeToInsert;
			}
		} else{
			addInTail(_nodeToInsert);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInTail(Node _item) {
		if(head == null){
			this.head = _item;
			this.head.next = null;
			this.head.prev = null;
		} else{
			this.tail.next = _item;
			_item.prev = tail;
		}
		this.tail = _item;
	}

	@SuppressWarnings("rawtypes")
	public void insertBeforeHead(Node nodeToInsert) {
		this.insertAfter(null, nodeToInsert);
	}

	@SuppressWarnings("rawtypes")
	public boolean isTail(Node node) {
		if(node == this.tail){
			return true;
		} else{
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public boolean isHead(Node node) {
		if(node == this.head){
			return true;
		} else{
			return false;
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