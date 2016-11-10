public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        
        int step = 2;
        
        LinkedList<String> level = new LinkedList<>();
        level.add(beginWord);
        
        Set<String> used = new HashSet<>();
        used.add(beginWord);
        
        int wordLength = beginWord.length();
        
        while(!level.isEmpty()) {
            LinkedList<String> nextLevel = new LinkedList<>();
            
            while(!level.isEmpty()) {
                String word = level.removeFirst();
                char[] chars = word.toCharArray();
                for(int i=0; i<wordLength; i++) {
                    char originalChar = chars[i];
                    for(char ch='a'; ch<='z'; ch++) {
                        if(ch == originalChar) continue;
                        chars[i] = ch;
                        
                        String newWord = new String(chars);
                        if(newWord.equals(endWord)) return step;
                        
                        if(wordList.contains(newWord) && !used.contains(newWord)) {
                            nextLevel.add(newWord);
                            used.add(newWord);
                        }
                    }
                    chars[i] = originalChar;
                }
            }
            level = nextLevel;
            step++;
        }
        return 0;
    }
}