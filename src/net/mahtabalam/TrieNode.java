package net.mahtabalam;

public class TrieNode {
	TrieNode[] children;
	boolean isEnd;

	public TrieNode() {
		this.children = new TrieNode[26];
	}
}
