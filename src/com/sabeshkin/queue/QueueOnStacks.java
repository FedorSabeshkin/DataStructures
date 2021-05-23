package com.sabeshkin.queue;

import java.util.LinkedList;

import com.sabeshkin.stack.ReversedStack;
import com.sabeshkin.stack.Stack;

public class QueueOnStacks<T> {
	private Stack<T> headStack;
	private ReversedStack<T> bodyStack;
	private int lenght;

	public QueueOnStacks() {
		headStack = new Stack<>();
		bodyStack = new ReversedStack<>();
		lenght = 0;
	}

	/**
	 * add in tail o(1)
	 * 
	 * @param T
	 *            item
	 */
	public void enqueue(T item) {
		if(lenght == 0){
			headStack.push(item);
		}else{
			bodyStack.push(item);
		}
		lenght++;
	}

	/**
	 * get from the head o(1)
	 * 
	 * @return T item
	 */
	public T dequeue() {
		T popedElement;
		if(lenght==1){
			popedElement = headStack.pop();
		}else{
			popedElement = headStack.pop();
			headStack.push(bodyStack.pop());
		}
		if(lenght > 0)
			lenght--;
		return popedElement;
	}

	/**
	 * get the size o(1)
	 * 
	 * @return int size
	 */
	public int size() {
		return lenght;
	}
}
