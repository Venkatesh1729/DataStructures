package com.dynamic.graph.clone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.ds.array.queue.Queue;
import com.ds.array.stack.Stack;

public class Graph<T>
{
	private HashMap<T, Vertex<T>> setOfVertices;

	private Stack<T> stack;

	private Queue<T> queue;

	boolean directedGraph = false;

	public Graph(boolean directedGraph) {
		this.directedGraph = directedGraph;
		setOfVertices = new HashMap<>();
		stack = new Stack<>();
		queue = new Queue<>();
	}

	public enum Search {
		BFS, DFS;
	}

	public void addEdge(T source, T destination) {
		returnVertex(source).edges.put(returnVertex(destination), 0);
		if (!this.directedGraph)
			returnVertex(destination).edges.put(returnVertex(source), 0);
	}

	public void addEdge(T source, T destination, int weight) {
		returnVertex(source).edges.put(returnVertex(destination), weight);
		if (!this.directedGraph)
			returnVertex(destination).edges.put(returnVertex(source), weight);
	}

	public boolean search(T source, T destination, Search search) {

		if (source.equals(destination))
			return true;
		else if (search == Search.BFS)
			return BFS(source, destination, true);
		else
			return DFS(source, destination, true);

	}

	public void print(T source, T destination, Search search) {
		if (search == Search.BFS)
			BFS(source, destination, false);
		else
			DFS(source, destination, false);
	}

	private boolean BFS(T source, T destination, boolean search) {
		if (!returnVertex(source).visited) {

			if (search && source == destination) {
				return true;
			} else {
				System.out.println(source);
			}

			if (queue.peek() != null)
				queue.remove();

			returnVertex(source).visited = true;

			ArrayList<Vertex<T>> list = new ArrayList<>(returnVertex(source).edges.keySet());

			for (Vertex<T> addVertex : list) {
				queue.add(addVertex.data);
			}
			if (queue.peek() != null)
				BFS(queue.peek(), destination, search);
		} else {
			queue.remove();
			if (queue.peek() != null)
				BFS(queue.peek(), destination, search);
		}
		return false;
	}

	private boolean DFS(T source, T destination, boolean search) {
		if (!returnVertex(source).visited) {

			if (search && source == destination) {
				return true;
			} else {
				System.out.println(source);
			}

			if (stack.peek() != null)
				stack.pop();

			returnVertex(source).visited = true;

			ArrayList<Vertex<T>> list = new ArrayList<>(returnVertex(source).edges.keySet());
			Collections.reverse(list);

			for (Vertex<T> addVertex : list) {
				stack.push(addVertex.data);
			}
			if (stack.peek() != null)
				DFS(stack.peek(), destination, search);
		} else {
			stack.pop();
			if (stack.peek() != null)
				DFS(stack.peek(), destination, search);
		}
		return false;

	}

	private Vertex<T> returnVertex(T data) {
		if (setOfVertices.containsKey(data)) {
			return setOfVertices.get(data);
		} else {
			Vertex<T> temp = new Vertex<T>(data);
			setOfVertices.put(data, temp);
			return temp;
		}
	}

}
