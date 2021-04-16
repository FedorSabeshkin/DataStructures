package com.sabeshkin.linkedlist;

import java.util.*;

public class LinkedList {
	public Node head;
	public Node tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	public void addInTail(Node item) {
		if(this.head == null)
			this.head = item;
		else
			this.tail.next = item;
		this.tail = item;
	}

	public Node find(int value) {
		Node node = this.head;
		while(node != null){
			if(node.value == value)
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
		if(node.value == _value){
				this.head = node.next;
				return true;
		}
		while(node != null){
			if(node.next != null){
				if(node.next.value == _value){
					Node removedNode = node.next;
					Node prevRemovedNode = node;
					Node nextRemovedNode = removedNode.next;
					prevRemovedNode.next = removedNode.next;
					return true;	
				}
			}
			node = node.next;
		}
		// здесь будет ваш код удаления одного узла по заданному значению
		return false; // если узел был удалён
	}

	public void removeAll(int _value) {
		// здесь будет ваш код удаления всех узлов по заданному значению
	}

	public void clear() {
		this.head=null;
	}

	public int count() {
		int count = 0;
		Node node = this.head;
		if(this.head != null){
			count = 1;
			while (node.next != null){
				node = node.next;
				count++;
			}	
		}
		return count; 
	}

	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		if(_nodeAfter != null){
			Node nodeAfter = _nodeAfter.next;
			_nodeToInsert.next = nodeAfter;
			_nodeAfter.next = _nodeToInsert;	
		}else{
			this.head = _nodeToInsert;
		}
	}

}

class Node {
	public int value;
	public Node next;

	public Node(int _value) {
		value = _value;
		next = null;
	}
	
}