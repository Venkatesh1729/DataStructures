package com.ds.binarytree;

public class BinarySearchTreeIterative<T>
{

	public TreeNode<T> root = null;

	public static int count = 0;

	public void insert(T item) {
		if (root != null) {
			TreeNode<T> treeNode = root;
			while (treeNode != null) {
				if (treeNode.getData().hashCode() < item.hashCode()) {
					if (treeNode.getRightNode() != null) {
						treeNode = treeNode.getRightNode();
					} else {
						treeNode.setRightNode(new TreeNode<T>(item));
						break;
					}
				} else {
					if (treeNode.getLeftNode() != null) {
						treeNode = treeNode.getLeftNode();
					} else {
						treeNode.setLeftNode(new TreeNode<T>(item));
						break;
					}
				}
			}
		} else {
			root = new TreeNode<T>(item);
		}
	}

	public boolean search(T item) {
		if (root != null) {
			TreeNode<T> treeNode = root;
			while (treeNode != null) {
				if (treeNode.getData().equals(item)) {
					return true;
				} else {
					if (treeNode.getData().hashCode() < item.hashCode()) {
						treeNode = treeNode.getRightNode();
					} else {
						treeNode = treeNode.getLeftNode();
					}
				}

			}
		}
		return false;
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
