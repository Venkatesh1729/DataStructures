package com.ds.array.stack;

import java.util.Arrays;

public class Stack<T>
{
	private int stackSize = 10;

	private T[] stack;

	protected int top;

	@SuppressWarnings("unchecked")
	public Stack() {
		this.stack = (T[]) new Object[stackSize];
		this.top = -1;
	}

	@SuppressWarnings("unchecked")
	public Stack(int stackSize) {
		this.stackSize = stackSize;
		this.stack = (T[]) new Object[stackSize];
		this.top = -1;
	}

	@SuppressWarnings("unchecked")
	public void setSize(int stackSize) {
		this.stackSize = stackSize;
		this.stack = (T[]) new Object[stackSize];
		this.top = -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isFull() {
		return top == stackSize - 1 ? true : false;
	}

	public boolean isEmpty() {
		return top == -1 ? true : false;
	}

	public T peek() {
		if (top == -1)
			return null;
		return stack[top];
	}

	public void push(T data) {
		if (!isFull()) {
			stack[++top] = data;
		} else {
			stack = Arrays.copyOf(stack, stackSize * 7);
			stackSize = stackSize * 7;
			stack[++top] = data;
		}
	}

	public T pop() {
		if (!isEmpty()) {
			return stack[top--];
		} else {
			return null;
		}
	}

}
