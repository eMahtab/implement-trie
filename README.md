# Trie Implementation
## https://leetcode.com/problems/implement-trie-prefix-tree

Implement a trie with insert, search, and startsWith methods.

```
Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
```

**Note:**
1. You may assume that all inputs are consist of lowercase letters a-z.
2. All inputs are guaranteed to be non-empty strings.


## Approach :
So we have to implement trie with `insert()`, `search()` and `startsWith()` functionalities. We are given that the, input consists of only lowercase letters `a-z` so each `TrieNode` can have at most 26 children (not more than that). So we will have two properties in the `TrieNode` class, an array of `TrieNode` called children and a boolean `isEnd` (which tells whether this TrieNode marks the end of a word)

```java
public class TrieNode {
	TrieNode[] children;
	boolean isEnd;

	public TrieNode() {
		this.children = new TrieNode[26];
	}
}
```
Now lets define the `Trie` class, below is the skeleton of the `Trie` class. Trie class hold the TrieNode which refers to the root of the Trie.
Note that Trie will be instantiated as `Trie trie = new Trie()` from outside, so initially all 26 entries in children array will be null for root node, which means initially there won't be any children in `Trie` but just a `TrieNode` root. 

```java
public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
       
    }
   
    public boolean search(String word) {
       
    }

    public boolean startsWith(String prefix) {
       
    }
}
```

### Implementing insert(String) 


## Implementation :


## References :
**Trie Data Structure :** 
1. https://www.youtube.com/watch?v=YG6iX28hmd0
2. https://www.youtube.com/watch?v=-urNrIAQnNo

**Implement Trie :** 
1. https://leetcode.com/articles/implement-trie-prefix-tree
2. https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java

