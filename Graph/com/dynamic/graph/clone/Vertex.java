package com.dynamic.graph.clone;

import java.util.LinkedHashMap;

public class Vertex<T>
{
	public T data;

	public LinkedHashMap<Vertex<T>, Integer> edges = new LinkedHashMap<Vertex<T>, Integer>();
	
	public boolean visited;

	public Vertex(T data) {
		this.data = data;
	}

}
