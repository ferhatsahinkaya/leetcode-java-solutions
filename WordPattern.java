public class Solution {
    public boolean wordPattern(String pattern, String str) {
        int length = pattern.length();
        String[] words = str.split(" ");
        if(length != words.length) return false;
        
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        for(int i=0; i<length; i++) {
            String existingWord = charToWord.get(pattern.charAt(i));
            if(existingWord == null) {
                charToWord.put(pattern.charAt(i), words[i]);
            } else if(!existingWord.equals(words[i])) return false;
            
            Character existingChar = wordToChar.get(words[i]);
            if(existingChar == null) {
                wordToChar.put(words[i], pattern.charAt(i));
            } else if(existingChar != pattern.charAt(i)) return false;
        }
        return true;
    }
}