package com.src.hashing;

public class HashNode<K, V>
{
	private K key;

	private V value;

	private HashNode<K, V> nextNode;

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public HashNode<K, V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(HashNode<K, V> nextNode) {
		this.nextNode = nextNode;
	}

}
