package com.sabeshkin.DLinkedList;

import java.util.ArrayList;


public class DLinkedList {
	private Node dummyHead;
	private Node dummyTail;
	public int count;

	public DLinkedList() {
		dummyHead = new Node(null);
		dummyTail = new Node(null);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
		count = 0;
	}

	public Node getHead() {
		if(this.dummyHead.next.value == null){
			return null;
		} else{
			return this.dummyHead.next;
		}
	}

	public Node getTail() {
		if(this.dummyTail.prev.value == null){
			return null;
		} else{
			return this.dummyTail.prev;
		}
	}

	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		if(_nodeAfter == null){
			throw new IllegalArgumentException("_nodeAfter can't be a null");
		}
		Node oldNext = _nodeAfter.next;
		oldNext.prev = _nodeToInsert;
		_nodeToInsert.next = oldNext;
		_nodeToInsert.prev = _nodeAfter;
		_nodeAfter.next = _nodeToInsert;
		this.count++;
	}

	public void addInTail(Node _item) {
		Node oldPrev = this.dummyTail.prev;
		oldPrev.next = _item;
		_item.prev = oldPrev;
		_item.next = this.dummyTail;
		this.dummyTail.prev = _item;
		this.count++;
	}

	public Node find(int _value) {
		Node node = getHead();
		if(node != null){
			while(node != null){
				if(node.value != null){
					if(node.value == _value)
						return node;
				}
				node = node.next;
			}
		}
		return null;
	}

	public ArrayList<Node> findAll(int _value) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Node node = this.getHead();
		while(node != null){
			if(node.value != null){
				if(node.value == _value){
					nodes.add(node);
				}
			}
			node = node.next;
		}
		return nodes;
	}

	private void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		this.count--;
	}

	public boolean remove(int _value) {
		Node node = this.find(_value);
		if(node != null){
			removeNode(node);
			return true;
		}
		return false;
	}
	
	public void removeAll(int _value) {
		ArrayList<Node> foundNodes = this.findAll(_value);
		for (Node node : foundNodes){
				removeNode(node);
		}
	}

	public void clear() {
		this.dummyHead.next = this.dummyTail;
		this.dummyTail.prev = this.dummyHead;
		this.count = 0;
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