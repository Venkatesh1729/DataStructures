package com.ds.trie;

public class TrieNode
{
	TrieNode[] children;

	boolean isEnd;
	
	char character;

	public TrieNode() {
		children = new TrieNode[26];
	}
}
