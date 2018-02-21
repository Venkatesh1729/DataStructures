package com.list.type.circularlinkedlist;

public class CircularNode<T>
{
	private T data;
	
	private CircularNode<T> nextNode;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public CircularNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(CircularNode<T> nextNode) {
		this.nextNode = nextNode;
	}

}
