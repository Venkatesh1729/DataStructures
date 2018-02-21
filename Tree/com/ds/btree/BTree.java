package com.ds.btree;

public class BTree<T>
{
	private BTreeArray<T> root;

	private int arraySize = 0;

	public BTree(int size) {
		arraySize = 2 * size - 1;
		root = new BTreeArray<T>(arraySize);
	}

	public void insert(T data) {
		root = insert(data, root);
	}

	public BTreeArray<T> insert(T data, BTreeArray<T> tempNode) {
		if (arraySize > tempNode.filledSize && tempNode.filledSize != 0 && tempNode.bTreeArray[0] != null && tempNode.bTreeArray[0].leftArray != null && tempNode.bTreeArray[0].rightArray != null) {

			int index = 0;

			for (int i = 0, j = 1; i < tempNode.filledSize || j < tempNode.filledSize; i++, j++) {
				if (tempNode.bTreeArray[j] == null) {
					index = i;
					break;
				} else if (data.hashCode() > tempNode.bTreeArray[i].data.hashCode() && data.hashCode() < tempNode.bTreeArray[j].data.hashCode()) {
					index = i;
					break;
				}
			}

			if (data.hashCode() < tempNode.bTreeArray[index].data.hashCode())
				insert(data, tempNode.bTreeArray[index].leftArray);
			else
				insert(data, tempNode.bTreeArray[index].rightArray);

		} else if (arraySize > tempNode.filledSize && tempNode.bTreeArray[tempNode.filledSize] == null) {
			tempNode.bTreeArray[tempNode.filledSize++] = returnBTreeNode(data);
		} else {
			tempNode = splitArray(data, tempNode);
			insert(data, tempNode);
		}
		return tempNode;
	}

	private BTreeNode<T> returnBTreeNode(T data) {
		return new BTreeNode<T>(data);
	}

	private BTreeArray<T> splitArray(T data, BTreeArray<T> tempNode) {

		BTreeNode<T> spiltNode = tempNode.bTreeArray[tempNode.filledSize / 2];

		spiltNode.leftArray = new BTreeArray<T>(this.arraySize);
		for (int i = 0; i < tempNode.filledSize / 2; i++) {
			spiltNode.leftArray.bTreeArray[i] = tempNode.bTreeArray[i];
		}
		spiltNode.leftArray.filledSize = arraySize / 2;

		spiltNode.rightArray = new BTreeArray<T>(this.arraySize);
		for (int i = tempNode.filledSize / 2 + 1, j = 0; i < tempNode.filledSize; i++, j++) {
			spiltNode.rightArray.bTreeArray[j] = tempNode.bTreeArray[i];
		}
		spiltNode.rightArray.filledSize = arraySize / 2;

		if (tempNode.filledSize == 5) {
			BTreeNode<T> temp = tempNode.bTreeArray[arraySize / 2];
			tempNode = new BTreeArray<T>(this.arraySize);
			tempNode.filledSize = 0;
			tempNode.bTreeArray[tempNode.filledSize++] = temp;
		} else if (tempNode.filledSize < 5) {
			tempNode.bTreeArray[tempNode.filledSize++] = tempNode.bTreeArray[arraySize / 2];
			tempNode.bTreeArray[tempNode.filledSize - 2].rightArray = tempNode.bTreeArray[tempNode.filledSize - 1].leftArray;
		}
		return tempNode;

	}

}
