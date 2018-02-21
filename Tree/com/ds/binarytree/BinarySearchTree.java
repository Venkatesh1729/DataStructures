package com.ds.binarytree;

public class BinarySearchTree<T>
{

	public TreeNode<T> root = null;

	public static int count = 0;

	public void insert(T item) {
		root = insertRec(root, item);
	}

	private TreeNode<T> insertRec(TreeNode<T> treeNode, T item) {
		if (treeNode == null) {
			TreeNode<T> newTreeNode = new TreeNode<T>(item);
			newTreeNode.height = 0;
			return newTreeNode;
		}
		if (treeNode.getData().hashCode() < item.hashCode()) {
			treeNode.height = treeNode.height + 1;
			treeNode.setRightNode(insertRec(treeNode.getRightNode(), item));
		} else {
			treeNode.height = treeNode.height + 1;
			treeNode.setLeftNode(insertRec(treeNode.getLeftNode(), item));
		}
		return treeNode;
	}

	public boolean search(T item) {
		return searchRec(root, item);
	}

	private boolean searchRec(TreeNode<T> treeNode, T item) {

		if (treeNode.getData().hashCode() == item.hashCode()) {
			return true;
		}

		if (treeNode.getData().hashCode() < item.hashCode()) {
			searchRec(treeNode.getRightNode(), item);
		} else {
			searchRec(treeNode.getLeftNode(), item);
		}

		return false;
	}

	public void delete(T item) {
		root = deleteRec(root, item);
	}

	private TreeNode<T> deleteRec(TreeNode<T> root, T item) {
		if (item.hashCode() < root.getData().hashCode()) {
			root.setLeftNode(deleteRec(root.getLeftNode(), item));
		} else if (item.hashCode() > root.getData().hashCode()) {
			root.setRightNode(deleteRec(root.getRightNode(), item));
		} else {
			if (root.getLeftNode() == null)
				return root.getRightNode();
			else if (root.getRightNode() == null)
				return root.getLeftNode();

			T minData = min(root.getRightNode(), item);

			root.setData(minData);
			root.setRightNode(deleteRec(root.getRightNode(), minData));
		}
		return root;
	}

	private T min(TreeNode<T> treeNode, T item) {

		T min = treeNode.getLeftNode().getData();

		while (treeNode.getLeftNode() != null) {
			min = treeNode.getLeftNode().getData();
			treeNode = treeNode.getLeftNode();
		}
		return min;
	}

	public void inOrder(TreeNode<T> temp) {

		if (temp == null) {
			return;
		}

		inOrder(temp.getLeftNode());
		System.out.println(temp.getData());
		inOrder(temp.getRightNode());

	}

	public void preOrder(TreeNode<T> temp) {

		if (temp == null) {
			return;
		}

		System.out.println(temp.getData());
		inOrder(temp.getLeftNode());
		inOrder(temp.getRightNode());
	}

	public void postOrder(TreeNode<T> temp) {

		if (temp == null) {
			return;
		}

		inOrder(temp.getLeftNode());
		inOrder(temp.getRightNode());
		System.out.println(temp.getData());
	}

}
