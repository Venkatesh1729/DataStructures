package com.list.type.singlylinkedlist;

import java.util.HashSet;

import com.ds.list.stack.Stack;

public class SinglyLinkedList<T>
{
	SinglyLinkedNode<T> head = null;

	HashSet<T> uniqueList = new HashSet<T>(); 

	HashSet<SinglyLinkedNode<T>> loop = new HashSet<SinglyLinkedNode<T>>();

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

	public void reverse() {
		SinglyLinkedNode<T> currentNode = head;
		SinglyLinkedNode<T> nextNode = null;
		SinglyLinkedNode<T> prevNode = null;
		while (currentNode != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;
		}
		head = prevNode;
	}

	public void insert(SinglyLinkedNode<T> data) {

		if (head == null) {
			head = (SinglyLinkedNode<T>) data;
		} else {
			SinglyLinkedNode<T> temp = head;
			while (temp.getNextNode() != null) {
				temp = temp.getNextNode();
			}
			if (checkLoop(data)) {
				System.out.println("Loop detected @ " + data.getData() + ". Value is skipped.");
			} else {
				temp.setNextNode((SinglyLinkedNode<T>) data);
			}
		}

		SinglyLinkedNode<T> temp = data;
		while (temp != null) {
			temp = temp.getNextNode();
			length++;
		}
	}

	public SinglyLinkedNode<T> lastNode() {
		SinglyLinkedNode<T> temp = this.head;
		while (temp.getNextNode() != null) {
			temp = temp.getNextNode();
		}
		return temp;
	}

	public void removeDuplicates() {

		SinglyLinkedNode<T> temp = this.head;
		SinglyLinkedNode<T> previousNode = null;

		while (temp != null) {
			if (uniqueList.contains(temp.getData())) {
				previousNode.setNextNode(temp.getNextNode());
			} else {
				uniqueList.add(temp.getData());
				previousNode = temp;
			}
			temp = temp.getNextNode();
		}

	}

	public boolean checkLoop(SinglyLinkedNode<T> temp) {
		if (loop.contains(temp)) {
			return true;
		} else {
			loop.add(temp);
			return false;
		}
	}

	public void deleteMiddleNode() {
		double deleteNode = Math.ceil(length / 2);
		int track = 2;
		SinglyLinkedNode<T> temp = head;
		while (temp != null) {
			if ((int) deleteNode == track) {
				temp.setNextNode(temp.getNextNode().getNextNode());
				break;
			} else {
				temp = temp.getNextNode();
				track++;
			}
		}
	}

	public void sumOfThree() {
		String[] numbers = new String[length / 3];
		SinglyLinkedNode<T> temp = head;
		int counter = 0;
		int arrayCounter = 0;
		int total = 0;

		while (temp != null) {
			numbers[arrayCounter] = temp.getData().toString() + (numbers[arrayCounter] == null ? "" : numbers[arrayCounter]);
			temp = temp.getNextNode();
			counter++;
			arrayCounter = counter / 3;
		}

		for (String number : numbers) {
			total = total + Integer.parseInt(number);
		}

		System.out.println("The sum of three is : " + total);
	}

	public void findIntersect(SinglyLinkedList<?> linkedList1, SinglyLinkedList<?> linkedList2) {
		Object intesectObject = null;
		if (isIntersect(linkedList1, linkedList2)) {
			if (linkedList1.length == linkedList2.length) {
				intesectObject = intersectNode(linkedList1.head, linkedList2.head);
			} else {
				if (linkedList1.length > linkedList2.length)
					intesectObject = intersectNode(getNthNode(linkedList1, linkedList1.length - linkedList2.length), linkedList2.head);
				else
					intesectObject = intersectNode(getNthNode(linkedList2, linkedList2.length - linkedList1.length), linkedList1.head);
			}

			System.out.println("Two linked list intersect at : " + intesectObject);
		} else {
			System.out.println("Two linked list is not intersected..!!");
		}
	}

	public boolean isIntersect(SinglyLinkedList<?> linkedList1, SinglyLinkedList<?> linkedList2) {
		if (linkedList1.lastNode() == linkedList2.lastNode()) {
			return true;
		}
		return false;
	}

	public Object intersectNode(SinglyLinkedNode<?> node1, SinglyLinkedNode<?> node2) {
		SinglyLinkedNode<?> temp1 = node1;
		SinglyLinkedNode<?> temp2 = node2;
		while (temp1.getData() != temp2.getData()) {
			temp1 = temp1.getNextNode();
			temp2 = temp2.getNextNode();
		}
		return temp1.getData();
	}

	private SinglyLinkedNode<?> getNthNode(SinglyLinkedList<?> linkedList1, int length) {
		SinglyLinkedNode<?> temp1 = linkedList1.head;
		int counter = 0;
		while (counter < length) {
			temp1 = temp1.getNextNode();
			counter++;
		}
		return temp1;
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

	public boolean checkPalindrome() {

		SinglyLinkedNode<T> tempList = head;
		int middleNode = (int) Math.ceil(this.length/2);
		Stack<T> stack = new Stack<T>();

		for (int i = 0; i < middleNode; i++) {
			stack.push(tempList.getData());
			tempList = tempList.getNextNode();
		}

		if(this.length % 2 != 0){
			++middleNode;
			tempList = tempList.getNextNode();
		}
		

		for (int i = middleNode; i < this.length; i++) {
			if (!stack.pop().equals(tempList.getData())) {
				return false;
			}
			tempList = tempList.getNextNode();
		}

		return true;
	}

}
