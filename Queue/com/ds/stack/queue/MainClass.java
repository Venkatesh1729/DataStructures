package com.ds.stack.queue;

public class MainClass
{
	public static void main(String[] args) {
		QueueViaStack<String> queue = new QueueViaStack<>();
		queue.add("venkatesh");
		queue.add("sethu");
		queue.add("hari");
		queue.add("ragu");
		
		queue.remove();
		
		System.out.println(queue.peek());
		
		queue.add("senthil");
		
	}

}
