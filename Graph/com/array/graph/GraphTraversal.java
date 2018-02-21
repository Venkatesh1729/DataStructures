package com.array.graph;

import java.util.LinkedList;

import com.ds.list.stack.Stack;
import com.ds.stack.queue.QueueViaStack;

public class GraphTraversal
{

	LinkedList<Integer>[] listOfNodes;

	int[] flagArray;

	Stack<Integer> stack = new Stack<>();

	QueueViaStack<Integer> queue = new QueueViaStack<>();

	int numberOfVertices = 0;

	@SuppressWarnings("unchecked")
	GraphTraversal(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		listOfNodes = new LinkedList[numberOfVertices];
		flagArray = new int[numberOfVertices];
		for (int i = 0; i < listOfNodes.length; i++) {
			listOfNodes[i] = new LinkedList<Integer>();
			flagArray[i] = 0;
		}
	}

	public void addEdge(int source, int destination) {
		listOfNodes[source].add(destination);
	}

	public void addEdgeUD(int source, int destination) {
		listOfNodes[source].add(destination);
		listOfNodes[destination].add(source);
	}

	public void DFS(int source) {
		if (flagArray[source] == 0) {
			System.out.println(source);
			flagArray[source] = 1;
			stack.pop();
			for (int i = listOfNodes[source].size() - 1; i >= 0; i--) {
				stack.push(listOfNodes[source].get(i));
			}
			if (stack.peek() != null)
				DFS(stack.peek());
		} else {
			stack.pop();
			if (stack.peek() != null)
				DFS(stack.peek());
		}
	}

	public void BFS(int source) {
		if (flagArray[source] == 0) {
			System.out.println(source);
			flagArray[source] = 1;
			queue.remove();
			for (int i = 0; i < listOfNodes[source].size(); i++) {
				queue.add(listOfNodes[source].get(i));
			}
			if (queue.peek() != null)
				BFS(queue.peek());
		} else {
			stack.pop();
			if (stack.peek() != null)
				DFS(stack.peek());
		}
	}

}
