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

	public static boolean parenthesisValidator(String inString) {
		int i = 0;
		Stack openParenthesisStack = new Stack();
		Stack closeParenthesisStack = new Stack();
		char openParenthesis = '(';
		char closeParenthesis = ')';
		Stack isOpenParenthesisStack = new Stack();
		while(i < inString.length()){
			try{
				while(inString.charAt(i) == openParenthesis){
					openParenthesisStack.push(inString.charAt(i));
					isOpenParenthesisStack.push(1);
					i = i + 1;
				}
			} catch (StringIndexOutOfBoundsException e){

			}
			try{
				while(inString.charAt(i) == closeParenthesis){
					closeParenthesisStack.push(inString.charAt(i));
					isOpenParenthesisStack.pop();
					i = i + 1;
				}
			} catch (StringIndexOutOfBoundsException e){

			}
		}
		boolean isEqualStackSize = (closeParenthesisStack.size() == openParenthesisStack.size());
		return (isOpenParenthesisStack.peek() == null && isEqualStackSize);
	}

	public static int postfixCalculation(String inString) {
		int beginIndex = 0;
		int endIndex = 0;
		int first;
		int second;
		Stack<Comparable> numbers = new Stack();
		while(beginIndex < inString.length() - 1){
			endIndex = inString.indexOf(" ", beginIndex);
			String symbol = inString.substring(beginIndex, endIndex);
			switch (symbol) {
			case "+":
				first = (int) numbers.pop();
				second = (int) numbers.pop();
				first = first + second;
				numbers.push(first);
				break;
			case "*":
				first = (int) numbers.pop();
				second = (int) numbers.pop();
				first = first * second;
				numbers.push(first);
				break;
			case "=":
				break;
			default:
				numbers.push(Integer.parseInt(symbol));
			}
			beginIndex = endIndex + 1;
		}
		return (int) numbers.pop();
	}

}