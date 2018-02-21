package com.ds.list.stack;

import java.util.ArrayList;
import java.util.List;

public class ListStack<T>
{
	private int limit = 5;

	private List<Stack<T>> listOfStacks;

	ListStack() {
		listOfStacks = new ArrayList<Stack<T>>();
	}

	public void push(T item) {
		if (listOfStacks.size() == 0 || listOfStacks.get(listOfStacks.size() - 1).length() == limit) {
			Stack<T> stack = new Stack<>();
			stack.push(item);
			listOfStacks.add(stack);
		} else {
			listOfStacks.get(listOfStacks.size() - 1).push(item);
		}
	}

	public T pop() {
		return listOfStacks.get(listOfStacks.size() - 1).pop();
	}

	public T peek() {
		return listOfStacks.get(listOfStacks.size() - 1).peek();
	}

}
