package com.ds.stack.queue;

import com.ds.list.stack.Stack;

public class QueueViaStack<T>
{
	Stack<T> stack = new Stack<T>();

	Stack<T> tempStack = new Stack<T>();

	public void add(T data) {
		stack.push(data);
	}

	public T remove() {
		if (stack != null) {
			this.convert();
			return tempStack.pop();
		}
		return null;
	}

	public T peek() {
		this.convert();
		return tempStack.peek();
	}

	public void convert() {
		if (tempStack.peek() == null) {
			while (stack.peek() != null) {
				tempStack.push(stack.pop());
			}
		}
	}

}
