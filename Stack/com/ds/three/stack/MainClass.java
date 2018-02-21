package com.ds.three.stack;

import com.ds.sort.stack.SortStack;

public class MainClass
{

	public static void main(String[] args) throws Exception {
		SortStack<Integer> array = new SortStack<>(10);
		
		array.push(2);
		array.push(8);
		array.push(9);
		array.push(1);
		
		System.out.println(array.pop());
		System.out.println(array.peek());
	}

}
