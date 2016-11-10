public class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        
        TrieNode() {
            Arrays.fill(children, null);
        }
    }
    TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        int length = word.length();
        TrieNode runner = root;
        for(int i=0; i<length; i++) {
            TrieNode child = runner.children[word.charAt(i)-'a'];
            child = (child != null) ? child : new TrieNode();
            runner.children[word.charAt(i)-'a'] = child;
            runner = child;
        }
        runner.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int length = word.length();
        return search(word, 0, length-1, root);
    }
    private boolean search(String word, int start, int end, TrieNode root) {
        if(root == null) return false;
        if(start > end) return root.isEnd;
        
        boolean isFound = false;
        if('.' == word.charAt(start)) {
            for(int i=0; i<26 && !isFound; i++) {
                isFound = search(word, start+1, end, root.children[i]);
            }
        } else {
            isFound = search(word, start+1, end, root.children[word.charAt(start)-'a']);
        }
        return isFound;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");