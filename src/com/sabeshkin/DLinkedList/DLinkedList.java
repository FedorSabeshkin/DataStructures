package com.sabeshkin.DLinkedList;

public class DLinkedList {
	private Node dummyHead;
	private Node dummyTail;

	public DLinkedList() {
		dummyHead = new Node(null);
		dummyTail = new Node(null);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
	}

	public Node getHead() {
		if(this.dummyHead.next.value == null){
			return null;
		}else{
			return this.dummyHead.next;
		}
	}

	public Node getTail() {
		if(this.dummyTail.prev.value == null){
			return null;
		}else{
			return this.dummyTail.prev;
		}
	}

	
	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		if(_nodeAfter == null){
			throw new IllegalArgumentException("_nodeAfter can't be a null");
		}
		Node oldNext = _nodeAfter.next;
		oldNext.prev =  _nodeToInsert;
		_nodeToInsert.next = oldNext;
		_nodeToInsert.prev = _nodeAfter;
		_nodeAfter.next = _nodeToInsert;
	}
	
	public void addInTail(Node _item) {
		Node oldPrev = this.dummyTail.prev;
		oldPrev.next = _item;
		_item.prev = oldPrev;
		_item.next = this.dummyTail;
		this.dummyTail.prev = _item; 
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