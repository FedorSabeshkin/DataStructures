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
		while(node != null){
			if(node.value == _value){
				this.head = node.next;
				return true;
			}
			if(node.next != null){
				if(node.next.value == _value){
					Node removedNode = node.next;
					Node prevRemovedNode = node;
					Node nextRemovedNode = removedNode.next;
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
			if(this.head.value == _value){
				this.head = node.next;
				node = this.head;
				continue;
			}
			if(node.next != null){
				if(node.next.value == _value){
					Node removedNode = node.next;
					Node prevRemovedNode = node;
					Node nextRemovedNode = removedNode.next;
					prevRemovedNode.next = nextRemovedNode;
					continue;
				}
			}
			node = node.next;
		}
	}

	public void clear() {
		this.head = null;
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
		if(_nodeAfter != null){
			Node nodeAfter = _nodeAfter.next;
			_nodeToInsert.next = nodeAfter;
			_nodeAfter.next = _nodeToInsert;
		} else{
			this.head = _nodeToInsert;
		}
	}

	public static LinkedList multiplyEachNode(LinkedList firstList, LinkedList secondList) {
		if(firstList.count() == secondList.count()){
			Node nodeFromFirstList = firstList.head;
			Node nodeFromSecondList = secondList.head;
			while(nodeFromFirstList != null){
				nodeFromFirstList.value = nodeFromFirstList.value * nodeFromSecondList.value;
				nodeFromFirstList = nodeFromFirstList.next;
				nodeFromSecondList = nodeFromSecondList.next;
			}
			return firstList;
		}else{
			throw new IllegalArgumentException("Передаваемые LinkedList'ы должны быть одинаковой длины");
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