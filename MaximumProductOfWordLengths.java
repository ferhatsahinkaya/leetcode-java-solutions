public class Solution {
    public int maxProduct(String[] words) {
        int length = words.length;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.signum(s2.length() - s1.length());
            }
        });
        int[] wordArray = new int[length];
        for(int i=0; i<length; i++) {
            wordArray[i] = getInteger(words[i]);
        }
        
        int max = 0;
        for(int i=0; i<length; i++) {
            int word1Length = words[i].length();
            for(int j=i+1; (j < length) && (max < word1Length * words[j].length()); j++) {
                if(!hasSameChar(wordArray[i], wordArray[j])) {
                   max = Math.max(max, word1Length * words[j].length()); 
                }
            }
        }
        return max;
    }
    private boolean hasSameChar(int word1, int word2) {
        for(int i=0; i<32; i++) {
            int mask = (1 << i);
            if(((word1 & mask) & (word2 & mask)) != 0) return true;
        }
        return false;
    }
    private int getInteger(String s) {
        int length = s.length();
        int value = 0;
        for(int i=0; i<length; i++) {
            value |= (1 << (s.charAt(i) - 'a'));
        }
        return value;
    }
}