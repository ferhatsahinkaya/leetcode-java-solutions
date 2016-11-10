public class Solution {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        Stack<Integer> stack = new Stack<>();
        boolean hasClosing = false;
        for(int i=0; i<length; i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.empty()) continue;
                hasClosing = true;
                chars[stack.pop()] = chars[i] = 'k';
            }
        }
        if(!hasClosing) return 0;
        
        int maxLength = 0;
        int i = 0;
        while(i < length) {
            if(chars[i] != 'k') {
                i++;
            } else {
                int count = 0;
                while((i < length) && (chars[i] == 'k')) {
                    i++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}