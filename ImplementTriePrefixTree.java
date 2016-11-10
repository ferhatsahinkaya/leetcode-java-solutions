class TrieNode {
    boolean isEnd = false;
    TrieNode[] children = new TrieNode[26];

    // Initialize your data structure here.
    public TrieNode() {
        Arrays.fill(children, null);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode runner = root;
        for(char ch : word.toCharArray()) {
            if(runner.children[ch - 'a'] == null) {
                runner.children[ch - 'a'] = new TrieNode();
            }
            runner = runner.children[ch - 'a'];
        }
        runner.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode foundNode = findNode(word);
        return (foundNode != null)
                && foundNode.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode foundNode = findNode(prefix);
        return foundNode != null;
    }
    
    private TrieNode findNode(String word) {
        TrieNode runner = root;
        for(char ch : word.toCharArray()) {
            if(runner.children[ch - 'a'] == null) return null;
            runner = runner.children[ch - 'a'];
        }
        return runner;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");