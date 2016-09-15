public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length <= 0) return "";
        
        int index = 0;
        while(true) {
            if(index >= strs[0].length()) break;
            
            char ch = strs[0].charAt(index);
            int i = 1;
            while(i<length) {
                if((index >= strs[i].length()) || (strs[i].charAt(index) != ch)) break;
                i++;
            }
            if(i != length) break;
            index++;
        }
        return strs[0].substring(0, index);
    }
}