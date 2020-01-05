package net.mahtabalam;

public class Trie {
	private TrieNode root;
	 
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                TrieNode temp = new TrieNode();
                node.children[index]=temp;
                node = temp;
            } else {
            	node = node.children[index];
            }
        }
        node.isEnd=true;
    }
    
 
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd;
    }

	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] != null){
            	node = node.children[index];
            } else{
                return null;
            }
        }
 
        if(node == root)
            return null;
 
        return node;
	}
	
	public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
