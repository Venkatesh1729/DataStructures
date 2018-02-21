package com.list.type.singlylinkedlist;

public class SinglyLinkedNode<T> {

	private T data;
	private SinglyLinkedNode<T> nextNode;

	public SinglyLinkedNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SinglyLinkedNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(SinglyLinkedNode<T> nextNode) {
		this.nextNode = nextNode;
	}
}
