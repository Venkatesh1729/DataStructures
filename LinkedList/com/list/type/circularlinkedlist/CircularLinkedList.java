package com.list.type.circularlinkedlist;

public class CircularLinkedList<T> {
	
	private CircularNode<T> start = null;

	private int length = 0;

	public void insert(T data) {

		if (start == null) {

			start = createNode(data);

		} else {

			CircularNode<T> temp = start;

			while (temp.getNextNode() != null) {
				temp = temp.getNextNode();
			}

			temp.setNextNode(createNode(data));
		}

		length++;

	}

	public void print() {

		CircularNode<T> temp = start;
		
		if(temp == null) {
			return;
		}

		do {

			System.out.println(temp.getData());

			temp = temp.getNextNode();

		} while (temp != start && temp != null);

	}

	private CircularNode<T> createNode(T data) {

		CircularNode<T> newNode = new CircularNode<>();

		newNode.setData(data);

		newNode.setNextNode(start);

		return newNode;

	}

}
