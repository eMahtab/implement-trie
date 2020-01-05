package net.mahtabalam;

public class App {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // true
		
		System.out.println(trie.search("app"));  //  false 
		
		System.out.println(trie.startsWith("app")); // true
		
		trie.insert("app");  
		System.out.println(trie.search("app"));  // true
		
		System.out.println(trie.search("a"));    // false
		System.out.println(trie.startsWith("a")); // true
		
		System.out.println(trie.search(""));	// false
		System.out.println(trie.startsWith("")); // false
	}

}
