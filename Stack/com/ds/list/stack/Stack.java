package com.ds.list.stack;

public class Stack<T>
{
	private int length = 0;

	private StackNode<T> peek = null;

	private StackNode<T> min = null;

	public void push(T data) {
		if (peek == null) {
			peek = new StackNode<T>(data);
			min = new StackNode<T>(data);
		} else {
			StackNode<T> tempStack = peek;
			peek = new StackNode<T>(data);
			peek.setNextNode(tempStack);

			if (min.getData().hashCode() > data.hashCode()) {
				StackNode<T> tempMinStack = min;
				min = new StackNode<T>(data);
				min.setNextNode(tempMinStack);
			}

		}
		length++;
	}

	public T peek() {
		if(peek == null)
			return null;
		return peek.getData();
	}

	public T pop() {
		if (peek == null)
			return null;
		else {
			StackNode<T> tempStack = peek;
			peek = peek.getNextNode();
			length--;

			if (tempStack.getData() == min.getData()) {
				min = min.getNextNode();
			}

			return tempStack.getData();
		}
	}

	public T min() {
		return min.getData();
	}

	public int length() {
		return length;
	}

}
