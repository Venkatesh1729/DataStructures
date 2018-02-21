package com.ds.btree;

public class MainMethod
{
	public static void main(String[] args) {
		BTree<Integer> bTree = new BTree<>(3);
		for (int i = 10; i <= 70; i = i + 10) {
			bTree.insert(i);
		}
	}
}
