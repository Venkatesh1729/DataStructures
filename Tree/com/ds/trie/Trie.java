package com.ds.trie;

import java.util.ArrayList;
import java.util.Collections;

import com.ds.array.stack.Stack;

public class Trie
{
	private TrieNode root;

	private Stack<TrieNode> stack;

	private String prefix = "";

	private String suggest = "";

	public Trie() {
		root = new TrieNode();
		stack = new Stack<>();
	}

	public void insert(String key) {
		TrieNode temp = root;
		int length = key.length();
		for (int i = 0; i < length; i++) {
			int index = key.charAt(i) - 'a';
			if (temp.children[index] == null)
				temp.children[index] = new TrieNode();
			temp = temp.children[index];
			temp.character = key.charAt(i);
		}
		temp.isEnd = true;
	}

	public boolean search(String key) {
		TrieNode temp = root;
		int length = key.length();
		for (int i = 0; i < length; i++) {
			int index = key.charAt(i) - 'a';
			if (temp.children[index] == null)
				return false;
			temp = temp.children[index];
		}
		return true;
	}

	public void suggestion(String key) {
		prefix = key;
		suggest = key.substring(0, key.length()-1);
		TrieNode temp = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			temp = temp.children[index];
		}
		DFS(temp);
	}

	private void DFS(TrieNode node) {
		if (node != null) {
			suggest = suggest + node.character;
			if (node.isEnd) {
				System.out.println(suggest);
				suggest = prefix;
			}
			ArrayList<TrieNode> list = new ArrayList<>();
			for (int i = 0; i < 26; i++) {
				if (node.children[i] != null)
					list.add(node.children[i]);
			}
			Collections.reverse(list);
			for (TrieNode tempTrieNode : list) {
				stack.push(tempTrieNode);
			}
			DFS(stack.pop());
		}
	}

}
