package com.sabeshkin.DLinkedList;

public class DLinkedList {

	private Node head;
	private Node tail;

	public DLinkedList() {
		tail = new Node(null);
		head = new Node(null);
		head.next = tail;
		tail.prev = head;
	}

	public Node getHead() {
		return head.next;
	}

	public Node getTail() {
		return tail.prev;
	}

	
	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		_nodeToInsert.next = _nodeAfter.next;
		_nodeToInsert.prev = _nodeAfter;
	}
	
	public void addInTail(Node _item) {
		
		_item.next = tail;
		_item.prev = tail.prev;
		tail.prev = _item;
	}

	public Node find(int _value) {
		Node node = getTail();
		while(node != null){
			if(node.value == _value)
				return node;
			node = node.prev;
		}
		return null;
	}

	private void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public boolean remove(int _value) {
		Node node = this.find(_value);
		if(node != null){
			removeNode(node);
			return true;
		}
		return false;
	}

	public int count() {
		int count = 0;
		Node node = this.head;
		if(this.head != null){
			count = 1;
			while(node.next.value != null){
				node = node.next;
				count++;
			}
		}
		return count;
	}

	public boolean isTail(Node node) {
		if((node == this.tail.prev) && (node.value != null)){
			return true;
		} else{
			return false;
		}
	}

	public boolean isHead(Node node) {
		if((node == this.head.next) && (node.value != null)){
			return true;
		} else{
			return false;
		}
	}
}

class Node {
	public Integer value;
	public Node next;
	public Node prev;

	public Node(Integer _value) {
		value = _value;
		next = null;
		prev = null;
	}
}