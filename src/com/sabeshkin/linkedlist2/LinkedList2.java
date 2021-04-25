package com.sabeshkin.linkedlist2;

import java.util.*;

public class LinkedList2 {
	public Node head;
	public Node tail;

	public LinkedList2() {
		head = null;
		tail = null;
	}

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

	public Node find(int _value) {
		Node node = this.head;
		while(node != null){
			if(node.value == _value)
				return node;
			node = node.next;
		}
		return null;
	}

	public ArrayList<Node> findAll(int _value) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Node node = this.head;
		while(node != null){
			if(node.value == _value){
				nodes.add(node);
			}
			node = node.next;
		}
		return nodes;
	}
	
	private void removeNode(Node node){
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
		this.head = null;
		this.tail = null;
	}

	public int count() {
		int count = 0;
		Node node = this.head;
		if(this.head != null){
			count = 1;
			while(node.next != null){
				node = node.next;
				count++;
			}
		}
		return count;
	}

	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		if(this.count()>0){
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
		}else{
			addInTail(_nodeToInsert);
		}
	}
	
	public void insertBeforeHead(Node nodeToInsert){
		this.insertAfter(null, nodeToInsert);
	}

	public boolean isTail(Node node) {
		if(node == this.tail){
			return true;
		} else{
			return false;
		}
	}

	public boolean isHead(Node node) {
		if(node == this.head){
			return true;
		} else{
			return false;
		}
	}
}

class Node {
	public int value;
	public Node next;
	public Node prev;

	public Node(int _value) {
		value = _value;
		next = null;
		prev = null;
	}
}
