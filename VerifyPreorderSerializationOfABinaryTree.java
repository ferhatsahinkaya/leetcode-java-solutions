public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] values = preorder.split(",");
        
        int length = values.length;
        if(length <= 0) return false;
        if(length == 1) return isNull(values[0]);
        
        Stack<String> stack = new Stack<>();
        for(int i=0; i<length; i++) {
            if(stack.empty() || !isNull(values[i])) {
                stack.push(values[i]);
            } else {
                boolean hasCompleteSibling = !stack.empty() && isNull(stack.peek());
                do {
                    while(hasCompleteSibling && !stack.empty() && isNull(stack.peek())) {
                        stack.pop();
                    }
                    if(hasCompleteSibling) {
                        if(stack.empty() || isNull(stack.peek())) return false;
                        stack.pop();
                    }
                } while(hasCompleteSibling && !stack.empty() && isNull(stack.peek()));
                
                stack.push(hasCompleteSibling ? "-" : "#");
            }
        }
        
        return (stack.size() == 1) && (isNull(stack.pop()));
    }
    private boolean isNull(String value) {
        return value.equals("#") || value.equals("-");
    }
}