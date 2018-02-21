
package com.ds.doublyllinkedlist;

public class DoublyLinkedList<T>
{
	private int length = 0;

	private DoublyLinkedNode<T> head = null;

	private DoublyLinkedNode<T> tail = null;

	public void insertFirst(T data) {

		DoublyLinkedNode<T> doublyLinkedListNode = createNode(data);
		doublyLinkedListNode.setNextNode(head);
		doublyLinkedListNode.setPrevNode(null);
		if (head != null) {
			head.setPrevNode(doublyLinkedListNode);
		}
		head = doublyLinkedListNode;
		if (tail == null) {
			tail = doublyLinkedListNode;
		}
		length++;

	}

	public void removeFirst() {

		head = head.getNextNode();
		head.setPrevNode(null);

		length--;

	}

	public void insertLast(T data) {

		if (head != null) {
			DoublyLinkedNode<T> doublyLinkedListNode = createNode(data);
			doublyLinkedListNode.setNextNode(null);
			doublyLinkedListNode.setPrevNode(tail);

			if (tail != null) {
				tail.setNextNode(doublyLinkedListNode);
			}

			tail = doublyLinkedListNode;

			length++;
		} else {
			insertFirst(data);
		}

	}

	public void removeLast() {

		tail = tail.getPrevNode();
		tail.setNextNode(null);

		length--;

	}

	public void traverseForward() {
		if (head != null) {
			DoublyLinkedNode<T> traverseNode = head;
			while (traverseNode != null) {
				if (traverseNode.getNextNode() != null) {
					System.out.print(traverseNode.getData() + " -> ");
				} else {
					System.out.println(traverseNode.getData());
				}
				traverseNode = traverseNode.getNextNode();
			}
		} else {
			System.out.println("No data avaiable");
		}
	}

	public void traverseBackward() {
		if (tail != null) {
			DoublyLinkedNode<T> traverseNode = tail;
			while (traverseNode != null) {
				if (traverseNode.getPrevNode() != null) {
					System.out.print(traverseNode.getData() + " -> ");
				} else {
					System.out.println(traverseNode.getData());
				}
				traverseNode = traverseNode.getPrevNode();
			}
		} else {
			System.out.println("No data avaiable");
		}
	}

	private DoublyLinkedNode<T> createNode(T data) {
		return new DoublyLinkedNode<T>(data);
	}

	public boolean isPalindrome() {

		DoublyLinkedNode<T> tempHead = this.head;
		DoublyLinkedNode<T> tempTail = this.tail;

		if (tempHead == null || tempTail == null) {
			System.out.println("Data is unavailable..!!");
			return false;
		}

		while (tempHead != null && tempTail != null) {
			if (tempHead.getData().equals(tempTail.getData())) {
				tempHead = tempHead.getNextNode();
				tempTail = tempTail.getPrevNode();
			} else {
				return false;
			}
		}
		return true;
	}
}
