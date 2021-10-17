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

	public static boolean parenthesisValidator(String sequenceOfParenthesis) {
		int i = 0;
		Stack stack = new Stack();
		while(i < sequenceOfParenthesis.length()){
			switch (sequenceOfParenthesis.charAt(i)) {
			case '(':
				stack.push(sequenceOfParenthesis.charAt(i));
				break;
			case ')':
				stack.pop();
				break;
			default:
				break;
			}
			i++;
		}
		return (stack.peek() == null);
	}

	public static int postfixCalculation(String postfixArithmeticExpression) {
		int positionOfSymbolStart = 0;
		int positionOfSymbolEnd = 0;
		int firstNumber;
		int secondNumber;
		Stack<Comparable> numbersForExpression = new Stack();
		while(positionOfSymbolStart < postfixArithmeticExpression.length() - 1){
			positionOfSymbolEnd = postfixArithmeticExpression.indexOf(" ", positionOfSymbolStart);
			String symbol = postfixArithmeticExpression.substring(positionOfSymbolStart, positionOfSymbolEnd);
			switch (symbol) {
			case "+":
				firstNumber = (int) numbersForExpression.pop();
				secondNumber = (int) numbersForExpression.pop();
				firstNumber = firstNumber + secondNumber;
				numbersForExpression.push(firstNumber);
				break;
			case "*":
				firstNumber = (int) numbersForExpression.pop();
				secondNumber = (int) numbersForExpression.pop();
				firstNumber = firstNumber * secondNumber;
				numbersForExpression.push(firstNumber);
				break;
			case "=":
				break;
			default:
				numbersForExpression.push(Integer.parseInt(symbol));
			}
			positionOfSymbolStart = positionOfSymbolEnd + 1;
		}
		return (int) numbersForExpression.pop();
	}

}