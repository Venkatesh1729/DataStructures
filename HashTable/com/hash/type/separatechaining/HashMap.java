package com.hash.type.separatechaining;

public class HashMap<K, V> {

	private int size = 20;

	private Object[] objectArray = new Object[size];

	@SuppressWarnings("unchecked")
	public void put(K key, V value) {

		int hashCode = key.hashCode() % size;

		if (objectArray[hashCode] instanceof HashNode) {

			HashNode<K, V> temp = (HashNode<K, V>) objectArray[hashCode];

			while (temp != null) {

				if (temp.getKey().equals(key)) {

					((HashNode<K, V>) objectArray[hashCode]).setValue(value);
					break;

				} else if (temp.getNextNode() == null) {

					temp.setNextNode(createNode(key, value));
					break;

				}

				temp = temp.getNextNode();
			}

		} else {

			objectArray[hashCode] = createNode(key, value);

		}

	}

	@SuppressWarnings("unchecked")
	public V get(K key) {

		if (objectArray[key.hashCode() % size] != null) {

			HashNode<K, V> temp = ((HashNode<K, V>) objectArray[key.hashCode() % size]);

			K keyObject = temp.getKey();

			V valueObject = temp.getValue();

			while (temp != null && keyObject != key) {

				keyObject = temp.getNextNode() != null ? temp.getNextNode().getKey() : null;

				valueObject = temp.getNextNode() != null ? temp.getNextNode().getValue() : null;

				temp = temp.getNextNode();

			}

			if (temp != null && keyObject.equals(key)) {

				return (V) valueObject;

			} else {

				return null;

			}
		}

		return null;
	}

	public HashNode<K, V> createNode(K key, V value) {

		HashNode<K, V> linkedList = new HashNode<K, V>();

		linkedList.setKey(key);

		linkedList.setValue(value);

		return linkedList;

	}
}
