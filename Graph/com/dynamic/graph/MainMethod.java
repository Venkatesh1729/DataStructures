package com.dynamic.graph;

import com.dynamic.graph.Graph.Search;

public class MainMethod
{

	public static void main(String[] args) {

		Graph<Integer> graph = new Graph<Integer>();
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.printAllVertices(2, Search.DFS);

	}

}
