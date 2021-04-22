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

	public boolean remove(int _value) {
		Node node = this.head;
		while(node != null){
			if(node.value == _value){
				this.head = node.next;
				if(isTail(node)){
					this.tail = null;
				}else{
					this.head.prev = null;
				}
				return true;
			}
			if(node.next != null){
				if(node.next.value == _value){
					Node removedNode = node.next;
					Node prevRemovedNode = node;
					Node nextRemovedNode = removedNode.next;
					if(isTail(removedNode)){
						this.tail = prevRemovedNode;
					}else{
						nextRemovedNode.prev = prevRemovedNode;
					}
					prevRemovedNode.next = nextRemovedNode;
					return true;
				}
			}
			node = node.next;
		}
		return false;
	}

	public void removeAll(int _value) {
		Node node = this.head;
		while(node != null){
			if(node.value == _value){
				this.head = node.next;
				if(isTail(node)){
					this.tail = null;
				}else{
					this.head.prev = null;
				}
				node = this.head;
				continue;
			}
			if(node.next != null){
				if(node.next.value == _value){
					Node removedNode = node.next;
					Node prevRemovedNode = node;
					Node nextRemovedNode = removedNode.next;
					if(isTail(removedNode)){
						this.tail = prevRemovedNode;
					}else{
						nextRemovedNode.prev = prevRemovedNode;
					}
					prevRemovedNode.next = nextRemovedNode;
					continue;
				}
			}
			node = node.next;
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
			this.head = _nodeToInsert;
		}
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
