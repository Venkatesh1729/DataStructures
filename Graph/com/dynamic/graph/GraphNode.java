package com.dynamic.graph;

import java.util.LinkedHashMap;

public class GraphNode<T>
{
	private T nodeData;

	protected boolean visited;

	private LinkedHashMap<GraphNode<T>, Integer> nodesConnected;

	public GraphNode() {
		nodesConnected = new LinkedHashMap<GraphNode<T>, Integer>();
	}

	protected void add(GraphNode<T> graphNode, int cost) {
		nodesConnected.put(graphNode, cost);
	}
	
	protected LinkedHashMap<GraphNode<T>, Integer> get() {
		return nodesConnected;
	}

	protected T getNodeData() {
		return nodeData;
	}

	protected void setNodeData(T nodeData) {
		this.nodeData = nodeData;
	}

}
