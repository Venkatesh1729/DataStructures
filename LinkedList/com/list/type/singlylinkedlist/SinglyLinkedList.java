package com.list.type.singlylinkedlist;

public class SinglyLinkedList<T> {

	SinglyLinkedNode<T> head = null;

	int length = 0;

	public void insert(T data) {

		if (head == null) {

			head = createNoode(data);

		} else {

			SinglyLinkedNode<T> temp = head;

			while (temp.getNextNode() != null) {
				temp = temp.getNextNode();
			}

			temp.setNextNode(createNoode(data));
		}

		length++;

	}

	public void delete(T data) {

		SinglyLinkedNode<T> temp = head;

		SinglyLinkedNode<T> prev = null;

		while (temp != null) {

			if (temp.getData().equals(data)) {

				if (prev == null) {
					head = temp.getNextNode();
					return;
				} else {
					prev.setNextNode(temp.getNextNode());
					return;
				}

			} else {

				prev = temp;
				temp = temp.getNextNode();

			}

		}
	}

	public boolean contains(T data) {

		SinglyLinkedNode<T> temp = head;

		if (data == null || temp == null) {
			return false;
		}

		while (temp != null) {

			if (temp.getData().equals(data)) {
				return true;
			}

			temp = temp.getNextNode();

		}

		return false;

	}

	public T getByIndex(int length) {

		SinglyLinkedNode<T> temp = head;

		int counter = 0;

		while (temp != null && counter < length) {

			if (temp.getNextNode() == null) {
				return null;
			}

			temp = temp.getNextNode();
			counter++;
		}

		return temp.getData();
	}

	public void print() {

		SinglyLinkedNode<T> temp = head;

		while (temp != null) {

			System.out.print(temp.getData() + (temp.getNextNode() != null ? " -> " : ""));

			temp = temp.getNextNode();

		}

		System.out.println("");
	}

	private SinglyLinkedNode<T> createNoode(T data) {

		return new SinglyLinkedNode<T>(data);

	}

	public int size() {
		return this.length;
	}

}
