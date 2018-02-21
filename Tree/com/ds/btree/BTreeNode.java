package com.ds.btree;

public class BTreeNode<T>
{
	public T data;

	public BTreeArray<T> leftArray;

	public BTreeArray<T> rightArray;

	public BTreeNode(T data) {
		this.data = data;
	}
	

}
