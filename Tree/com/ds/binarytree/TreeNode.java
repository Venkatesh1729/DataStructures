package com.ds.binarytree;

public class TreeNode<T> {

	private T data;
	public int height;
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;

	public TreeNode() {
		this.data = null;
	}
	
	public TreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

}
