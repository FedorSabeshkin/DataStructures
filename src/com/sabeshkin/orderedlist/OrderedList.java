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
		if(v1.getClass() == String.class){
			String trimedSpacesV1 = ((String) v1).trim();
			String trimedSpacesV2 = ((String) v2).trim();
			compareResult = trimedSpacesV1.compareTo(trimedSpacesV2);
		}
		return compareResult;
	}

	public void addAscendent(Node<T> node, T value) {
		while(node != null){
			Node<T> addedNode;
			Integer compareResultPrev = compare(node.value, value);
			Integer compareResultNext = 0;
			addedNode = new Node(value);
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
			addedNode = new Node(value);
			if(!isTail(node)){
				compareResultNext = compare(node.next.value, value);
			}
			if(compareResultPrev >= 0 && compareResultNext <= 0){
				insertAfter(node, addedNode);
				break;
			} else if(compareResultPrev == -1){
				if(!isHead(node)){
					addDescendent(node.prev, value);
				}else{
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