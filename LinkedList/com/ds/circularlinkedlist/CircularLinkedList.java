package com.ds.circularlinkedlist;

public class CircularLinkedList<T>
{
	private CircularNode<T> start = null;

	private int length = 0;

	public void insert(T data) {
		if (start == null) {
			start = createNode(data);
		} else {
			CircularNode<T> temp = start;
			while (temp.getNextNode() != start) {
				temp = temp.getNextNode();
			}
			temp.setNextNode(createNode(data));
		}
		length++;
	}

	private CircularNode<T> createNode(T data) {
		CircularNode<T> newNode = new CircularNode<>();
		newNode.setData(data);
		newNode.setNextNode(start);
		return newNode;
	}

}
