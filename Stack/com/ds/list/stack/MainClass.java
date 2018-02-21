package com.ds.list.stack;

public class MainClass
{
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(6);
		stack.push(1);
		stack.push(2);
		stack.push(7);
		
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.min());

	}

}
