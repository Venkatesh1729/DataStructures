package com.dynamic.graph.clone;

import com.dynamic.graph.clone.Graph.Search;

public class MainMethod
{

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>(true);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		
		graph.print(1, 6, Search.DFS);
		

	}

}
