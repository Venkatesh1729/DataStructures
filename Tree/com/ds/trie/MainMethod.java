package com.ds.trie;

public class MainMethod
{
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello");
		trie.insert("hi");
		trie.insert("hie");
		trie.insert("hiaer");
		trie.insert("aie");
		trie.insert("here");
		trie.insert("hir");
		
		trie.suggestion("hi");
	}

}
