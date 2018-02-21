package com.ds.btree;

public class BTreeArray<T>
{
	public BTreeNode<T>[] bTreeArray;
	
	public int filledSize;

	@SuppressWarnings("unchecked")
	public BTreeArray(int size) {
		this.bTreeArray = new BTreeNode[size];
	}

}
