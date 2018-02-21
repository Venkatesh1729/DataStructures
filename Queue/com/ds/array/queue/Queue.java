package com.ds.array.queue;

import java.util.Arrays;

public class Queue<T>
{
	private int queueSize = 10;

	private T[] queue;

	private int front = 0;

	private int end = -1;

	private boolean isEmpty = true;

	@SuppressWarnings("unchecked")
	public Queue() {
		queue = (T[]) new Object[queueSize];
	}

	@SuppressWarnings("unchecked")
	public Queue(int queueSize) {
		this.queueSize = queueSize;
		queue = (T[]) new Object[queueSize];
	}

	public void add(T data) {
		isEmpty = false;
		if (isFull()) {
			queue = Arrays.copyOfRange(queue, front, queueSize * 4);
			queueSize = queueSize * 4;
			end = end - front;
			queue[++end] = data;
		} else {
			queue[++end] = data;
		}
	}

	public T remove(){
		if (isEmpty) {
			return null;
		} else if (front == end) {
			T temp = queue[front];
			queue[front] = null;
			isEmpty = true;
			return temp;
		} else {
			T temp = queue[front];
			queue[front] = null;
			front++;
			return temp;
		}
	}
	
	public T peek(){
		return queue[front];
	}

	private boolean isFull() {
		return queueSize == end + 1 ? true : false;
	}

}
