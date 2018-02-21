package com.hash.cuckoo;

public class HashMap<K, V>
{
	private int table1Size = 11;

	private int table2Size = 11;

	private Object[] hashTable1 = new Object[table1Size];

	private Object[] hashTable2 = new Object[table2Size];

	@SuppressWarnings("unchecked")
	public void put(K key, V value) {
		
		if (hashTable1[getFirstHashCode(key)] instanceof CuckooDataNode) {
			
			int firstHashCodeKey = getFirstHashCode(key);
			int secondHashCodeKey = getSecondHashCode(key);
			boolean firstHash = true;
			boolean secondHash = true;
			CuckooDataNode<K, V> temp1 = null;
			CuckooDataNode<K, V> temp2 = createNode(key, value);

			while (true) {
				if (firstHash && hashTable1[firstHashCodeKey] instanceof CuckooDataNode) {
					temp1 = (CuckooDataNode<K, V>) hashTable1[firstHashCodeKey];
					hashTable1[firstHashCodeKey] = temp2;
					firstHash = false;
					secondHash = true;
				} else if (secondHash && hashTable2[secondHashCodeKey] instanceof CuckooDataNode) {
					temp2 = (CuckooDataNode<K, V>) hashTable2[secondHashCodeKey];
					hashTable2[secondHashCodeKey] = temp1;
					firstHash = true;
					secondHash = false;
				} else {
					if (secondHash) {
						hashTable2[secondHashCodeKey] = temp1;
					} else if (firstHash) {
						hashTable1[firstHashCodeKey] = temp2;
					}
					break;
				}
			}
			
		} else {
			hashTable1[getFirstHashCode(key)] = createNode(key, value);
		}
	}

	private CuckooDataNode<K, V> createNode(K key, V value) {
		CuckooDataNode<K, V> cuckooDataNode = new CuckooDataNode<>();
		cuckooDataNode.setKey(key);
		cuckooDataNode.setValue(value);
		return cuckooDataNode;
	}

	private int getFirstHashCode(K key) {
		return key.hashCode() % table1Size;
	}

	private int getSecondHashCode(K key) {
		return (key.hashCode() / table2Size) % table2Size;
	}

}
