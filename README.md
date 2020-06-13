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
`insert()` method takes a String `word` and doesn't return anything. We start from the root node and iterate over all the characters of the `word`. 

We check if the node's children array already have that character, if it does, we set our next node to that children `TrieNode`, otherwise we create a new `TrieNode` and set it to the node's children array and also set the next node to that newly created `TrieNode`

And at the end after iterating over all the characters of the input word, we set the node's `isEnd` property to true, since that node marks the end of the word in the `Trie`.


```java
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
```

**💥 👀 💥**

Note how we are checking if the `TrieNode` have a children with the same character. We are not compairing against actual character, rather we are checking, is the index pointed by that character is null or not. If its null we know that `TrieNode` doesn't have a children with the same character, otherwise if its not null then we are sure that `TrieNode` have a children with the same character.

### Implementing search(String) :

```java
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
 
       if(node == root)  // < --- This check is for handling the case when the input word is empty string
            return null;
 
       return node;
}
```
Since we need two search functionalities for the Trie, one to tell whether the word exist in the Trie and another if a given prefix exists in the Trie.

We define a helper method `searchPrefix()` which tells whether the prefix exists in the Trie or not. 

**💥 👀 💥**

Note that `searchPrefix()` returns a `TrieNode` if prefix exists and null otherwise. By defining the `searchPrefix()` we can use it in both `search()` and `startsWith()` without any code duplication. 

So the `search()` method calls the `searchPrefix()` method and if it returns `TrieNode` which is not null and also if that `TrieNode` marks the end of a word, we return true from the search method and false oherwise.

### Implementing startsWith(String) :

For `startsWith()` we just have to check, is the prefix exists in the `Trie`, the `TrieNode` doesn't have to be the end, so no need for 
`isEnd` check.

```java
public boolean startsWith(String prefix) {
       TrieNode node = searchPrefix(prefix);
       return node != null;
}
```

### All together
```java
class Trie {
    TrieNode root;
    class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;
        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new TrieNode();
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    
    private TrieNode searchPrefix(String word) {
        if(word.length() == 0) return null; // returns null for empty string
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(node.children[ch - 'a'] == null)
                return null;
            node = node.children[ch - 'a'];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

## Let's test it :

```java
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

```

## References :
**Trie Data Structure :** 
1. https://www.youtube.com/watch?v=YG6iX28hmd0
2. https://www.youtube.com/watch?v=-urNrIAQnNo

**Implement Trie :** 
1. https://leetcode.com/articles/implement-trie-prefix-tree
2. https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java

