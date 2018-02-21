package com.dynamic.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.ds.list.stack.Stack;
import com.ds.stack.queue.QueueViaStack;

public class Graph<T> extends GraphNode<T>
{
	public enum Search {
		DFS, BFS
	}

	private HashMap<T, GraphNode<T>> listOfNodes;

	private List<Integer> listOfCost;

	private Stack<GraphNode<T>> stack;

	private QueueViaStack<GraphNode<T>> queue;

	public Graph() {
		listOfNodes = new HashMap<>();
		stack = new Stack<>();
		queue = new QueueViaStack<>();
		listOfCost = new ArrayList<>();
	}

	public void addEdge(T source, T destination) {
		GraphNode<T> sourceNode = returnNode(source);
		GraphNode<T> destNode = returnNode(destination);
		listOfCost.add(0);
		sourceNode.add(destNode, 0);
	}

	public void addEdgeUD(T source, T destination) {
		GraphNode<T> sourceNode = returnNode(source);
		GraphNode<T> destNode = returnNode(destination);
		listOfCost.add(0);
		sourceNode.add(destNode, 0);
		destNode.add(sourceNode, 0);
	}

	public void addEdge(T source, T destination, int cost) {
		GraphNode<T> sourceNode = returnNode(source);
		GraphNode<T> destNode = returnNode(destination);
		listOfCost.add(cost);
		sourceNode.add(destNode, cost);
	}

	public void addEdgeUD(T source, T destination, int cost) {
		GraphNode<T> sourceNode = returnNode(source);
		GraphNode<T> destNode = returnNode(destination);
		listOfCost.add(cost);
		sourceNode.add(destNode, cost);
		destNode.add(sourceNode, cost);
	}

	public void printAllVertices(T source, Search search) {
		if (checkNode(source)) {
			clearVisited();
			GraphNode<T> tempNode = returnNode(source);
			if (search == Search.BFS) {
				BFSPrint(tempNode, null, false);
			} else if (search == Search.DFS) {
				DFSPrint(tempNode, null, false);
			}
		} else {
			System.out.println("The given vertex is not found.");
		}
	}

	public boolean searchPath(T source, T destination, Search search) {
		if (checkNode(source) && checkNode(destination)) {
			clearVisited();
			GraphNode<T> tempNode = returnNode(source);
			if (search == Search.BFS) {
				return BFSPrint(tempNode, destination, true);
			} else if (search == Search.DFS) {
				return DFSPrint(tempNode, destination, true);
			}
		}
		return false;
	}

	private boolean DFSPrint(GraphNode<T> tempNode, T destNode, boolean isSearch) {
		if (!tempNode.visited) {

			if (isSearch) {
				if (tempNode.getNodeData() == destNode) {
					return true;
				}
			} else {
				System.out.println(tempNode.getNodeData());
			}

			tempNode.visited = true;
			stack.pop();

			ArrayList<GraphNode<T>> listOfKeys = new ArrayList<GraphNode<T>>(tempNode.get().keySet());
			Collections.reverse(listOfKeys);

			for (GraphNode<T> key : listOfKeys) {
				stack.push(key);
			}

			if (stack.peek() != null)
				return DFSPrint(stack.peek(), destNode, isSearch);
		} else {
			stack.pop();
			if (stack.peek() != null)
				return DFSPrint(stack.peek(), destNode, isSearch);
		}
		return false;
	}

	private boolean BFSPrint(GraphNode<T> tempNode, T destNode, boolean isSearch) {
		if (!tempNode.visited) {

			if (isSearch) {
				if (tempNode.getNodeData() == destNode) {
					return true;
				}
			} else {
				System.out.println(tempNode.getNodeData());
			}

			tempNode.visited = true;
			queue.remove();

			ArrayList<GraphNode<T>> listOfKeys = new ArrayList<GraphNode<T>>(tempNode.get().keySet());

			for (GraphNode<T> key : listOfKeys) {
				queue.add(key);
			}

			if (queue.peek() != null)
				return BFSPrint(queue.peek(), destNode, isSearch);
		} else {
			queue.remove();
			if (queue.peek() != null)
				return BFSPrint(queue.peek(), destNode, isSearch);
		}
		return false;
	}

	private GraphNode<T> returnNode(T data) {
		if (listOfNodes.get(data) == null) {
			GraphNode<T> returnNode = new GraphNode<>();
			returnNode.setNodeData(data);
			listOfNodes.put(data, returnNode);
			return returnNode;
		} else {
			return listOfNodes.get(data);
		}

	}

	private boolean checkNode(T data) {
		return listOfNodes.get(data) == null ? false : true;
	}

	private void clearVisited() {
		HashSet<T> setKeys = new HashSet<>(listOfNodes.keySet());
		for (T key : setKeys) {
			listOfNodes.get(key).visited = false;
		}
	}

}
