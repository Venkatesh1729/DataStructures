package com.ds.array.stack;

public class MainClass
{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<>(3);
		stack.push("PUSH1");
		stack.push("PUSH2");
		stack.push("PUSH3");
		stack.push("PUSH4");
		stack.push("PUSH5");
		
		System.out.println(stack.pop());
		
		
	}

}
