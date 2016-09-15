public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<length; i++) {
            if(isOpening(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()) return false;
                if(!isMatching(stack.pop(), s.charAt(i))) return false;
            }
        }
        return stack.empty();
    }
    private boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}');
    }
    private boolean isOpening(char ch) {
        return (ch == '(' || ch == '[' || ch == '{');
    }
}