package com.ds.binarytree;

public class MainClass
{
	public static void main(String[] args) {
		
		BinarySearchTree<Integer> treeNode = new BinarySearchTree<Integer>();

		treeNode.insert(6);
		treeNode.insert(8);
		treeNode.insert(4);
/*		treeNode.insert(3);
		treeNode.insert(9);
		treeNode.insert(7);
		treeNode.insert(5);
		treeNode.insert(10);
		treeNode.insert(12);
		treeNode.insert(11);*/
		
		treeNode.inOrder(treeNode.root);
		
		System.out.println(treeNode.root.height);

	}
}
