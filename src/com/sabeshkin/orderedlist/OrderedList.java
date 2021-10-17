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
	
	// worst O(n)
	// if we work with array, we can use binary search O(log(n)) 
	public Node<T> find(T val) {
		Node<T> node = this.head;
		while(node != null){
			Integer resultOfCompare = compare(node.value, val);
			Integer compareResultNext = 0;
			if(!isTail(node)){
				compareResultNext = compare(node.next.value, val);
			}
			if(resultOfCompare < 0 && compareResultNext > 0){
				// found nothing 
				return null;
			} else if(resultOfCompare == 0){
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public void delete(T val) {
		Node<T> node = find(val);
		if(node != null){
			removeNode(node);
			size--;
		}
	}
	
	private void removeNode(Node<T> node){
		if(node.prev != null){
			node.prev.next = node.next;
		}
		if(node.next != null){
			node.next.prev = node.prev;
		}
		// check head case
		if(isHead(node)){
			if(node.next != null){
				this.head = node.next;
				this.head.prev = null;
			} else{
				this.head = null;
			}
		}
		// check tail case
		if(isTail(node)){
			if(node.prev != null){
				this.tail = node.prev;
				this.tail.next = null;
			} else{
				this.tail = null;
			}
		}
	}

	public void clear(boolean asc) {
		_ascending = asc;
		this.head = null;
		this.tail = null;
		size=0;
	}

	public int count() {
		return size;
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

	public int compare(T v1, T v2) {
		int resultOfCompare = 0;
		if(v1.getClass() == Integer.class){
			resultOfCompare = ((Integer) v1).compareTo((Integer) v2);
		}
		if(v1.getClass() == String.class){
			String trimedSpacesV1 = ((String) v1).trim();
			String trimedSpacesV2 = ((String) v2).trim();
			resultOfCompare = trimedSpacesV1.compareTo(trimedSpacesV2);
		}
		if(resultOfCompare > 0){
			resultOfCompare = 1;
		} else if(resultOfCompare < 0){
			resultOfCompare = -1;
		}

		return resultOfCompare;
	}

	public void addAscendent(Node<T> node, T value) {
		while(node != null){
			Node<T> addedNode;
			addedNode = new Node<T>(value);
			Integer compareResultPrev = compare(node.value, value);
			Integer compareResultNext = 0;
			if(!isTail(node)){
				compareResultNext = compare(node.next.value, value);
			}
			if(compareResultPrev <= 0 && compareResultNext >= 0){
				insertAfter(node, addedNode);
				break;
			} else if(compareResultPrev == 1){
				insertBefore(node, addedNode);
				break;
			} else{
				node = node.next;
			}
		}
	}

	public void addDescendent(Node<T> node, T value) {
		while(node != null){
			Node<T> addedNode;
			Integer compareResultPrev = compare(node.value, value);
			Integer compareResultNext = 0;
			addedNode = new Node<T>(value);
			if(!isTail(node)){
				compareResultNext = compare(node.next.value, value);
			}
			if(compareResultPrev >= 0 && compareResultNext <= 0){
				insertAfter(node, addedNode);
				break;
			} else if(compareResultPrev == -1){
				if(!isHead(node)){
					addDescendent(node.prev, value);
				} else{
					insertBefore(node, addedNode);
				}
				break;
			} else{
				node = node.next;
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(T value) {
		if(tail == null){
			addInTail(new Node(value));
		} else{
			Node<T> node = head;
			if(_ascending){
				addAscendent(node, value);
			} else{
				addDescendent(node, value);
			}
		}
		size++;
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

	@Override
	public String toString() {
		String outStr = "size=" + size;
		Node<T> node = head;
		while(node != null){
			outStr = outStr + "\n" + node.value;
			node = node.next;
		}
		return outStr;
	}

}