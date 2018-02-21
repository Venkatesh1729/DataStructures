package com.hash.cuckoo;

public class CuckooDataNode<K,V>
{
	private K key;
	private V value;
	private CuckooDataNode<K, V> backup;
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public CuckooDataNode<K, V> getBackup() {
		return backup;
	}

	public void setBackup(CuckooDataNode<K, V> backup) {
		this.backup = backup;
	}
}
