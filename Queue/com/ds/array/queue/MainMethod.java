package com.ds.array.queue;

public class MainMethod
{
	public static void main(String[] args) throws Exception {
		Queue<String> queue = new Queue<>(4);
		queue.add("QUEUE1");
		queue.add("QUEUE2");
		queue.add("QUEUE3");
		queue.add("QUEUE4");
		queue.remove();
		queue.remove();
		queue.add("QUEUE5");
		queue.add("QUEUE6");
	}

}
