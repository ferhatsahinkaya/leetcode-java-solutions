public class Solution {
    public boolean isSubsequence(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        
        int i = 0;
        int j = 0;
        while(i < slength) {
            char ch = s.charAt(i);
            boolean found = false;
            while(j < tlength) {
                if(ch == t.charAt(j++)) {
                    found = true;
                    break;
                }
            }
            if(!found) return false;
            i++;
        }
        return i >= slength;
    }
}