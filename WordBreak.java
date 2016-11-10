public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int length = s.length();
        boolean[] canBreak = new boolean[length];
        for(int i=0; i<length; i++) {
            boolean breakable = false;
            for(int j=i; j>=0 && !breakable; j--) {
                boolean prevBreakable = (j == 0) || canBreak[j-1];
                if(prevBreakable) {
                    breakable = wordDict.contains(s.substring(j, i+1));
                }
            }
            canBreak[i] = breakable;
        }
        return canBreak[length-1];
    }
}