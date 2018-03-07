package com.ds.three.stack;

public class NumberStackArray<T>
{
	private Object[] values = {};

	private int[] sizes;

	private int stackCapacity;

	public NumberStackArray(int totalSize, int sizeOfStack) {
		values = new Object[totalSize];
		sizes = new int[sizeOfStack];
		stackCapacity = totalSize / sizeOfStack;
	}

	public void push(int stackNum, T data) throws Exception {
		if (isFull(stackNum)) {
			throw new Exception("Stack is full..!!");
		}
		sizes[stackNum - 1]++;
		values[arrayAt(stackNum)] = data;
	}

	public Object pop(int stackNum) throws Exception {
		if (isEmpty(stackNum)) {
			throw new Exception("Stack is empty..!!");
		}
		Object temp = values[arrayAt(stackNum)];
		values[arrayAt(stackNum)] = null;
		sizes[stackNum - 1]--;
		return temp;
	}

	private boolean isFull(int stackNum) {
		return sizes[stackNum - 1] == stackCapacity;
	}

	private boolean isEmpty(int stackNum) {
		return sizes[stackNum - 1] == 0;
	}

	private int arrayAt(int stackNum) {
		int offset = (stackNum - 1) * stackCapacity;
		return offset + sizes[stackNum - 1] - 1;
	}

}
