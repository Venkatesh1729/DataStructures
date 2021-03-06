package com.ds.list.stack;

public class StackNode<T>
{
	private T data;

	private StackNode<T> nextNode;

	public StackNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public StackNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(StackNode<T> nextNode) {
		this.nextNode = nextNode;
	}

}
