package com.ds.sort.stack;

import com.ds.array.stack.Stack;

public class SortStack<T> extends Stack<T>
{
	private T[] values;

	private int top = -1;

	@SuppressWarnings("unchecked")
	public SortStack(int size) {
		super(size);
		values = (T[]) new Object[size];
	}

	public void push(T data){
		if (top == -1 || peek().hashCode() > data.hashCode()) {
			values[++top] = data;
			if (super.top != -1) {
				push(super.pop());
			}
		} else {
			super.push(pop());
			push(data);
		}

	}

	public T pop() {
		T temp = values[top];
		values[top] = null;
		top--;
		return temp;
	}

	public T peek() {
		return values[top];
	}
}
