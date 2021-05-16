package com.sabeshkin.stack;

import java.util.*;

public class Stack<T> {
	LinkedList<T> linkedList;

	public Stack() {
		linkedList = new LinkedList<>();
	}

	public int size() {
		return linkedList.size();
	}

	public T pop() {
		try{
			return linkedList.pop();
		} catch (NoSuchElementException exception){
			return null;
		}
	}

	public void push(T val) {
		linkedList.push(val);
	}

	public T peek() {
		return linkedList.peek();
	}

	public static boolean parenthesisValidator(String inString, Stack stack) {
		int i = 0;
		Stack openParenthesisStack = new Stack();
		Stack closeParenthesisStack = new Stack();
		// Character openParenthesis = new Character('(');
		boolean isOpenParenthesis = false;
		while(i < inString.length()){
			char openParenthesis = '(';
			char closeParenthesis = ')';
			while(inString.charAt(i) == openParenthesis){
				openParenthesisStack.push(inString.charAt(i));
				isOpenParenthesis = true;
				i++;
			}
			while(isOpenParenthesis){

			}
			while(inString.charAt(i) == closeParenthesis){
				closeParenthesisStack.push(inString.charAt(i));
				i++;
			}
			stack.push(inString.charAt(i));
		}
		return (!isOpenParenthesis && (closeParenthesisStack.size() == openParenthesisStack.size()));
	}

}