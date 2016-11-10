public class Solution {
    public int calculate(String s) {
        return (int) calculate(s, 0, s.length()-1);
    }
    
    private long calculate(String s, int start, int end) {
        int opIndex = getNextNonNumber(s, start, end);
        if(opIndex < 0) return getValue(s, start, end);
        
        if(isOpeningParanthesis(s.charAt(opIndex))) {
            int closingIndex = getClosingParanthesis(s, opIndex+1, end);
            return calculate(s.substring(opIndex+1, closingIndex) + s.substring(closingIndex+1, end+1));
        }
        
        long result = getValue(s, start, opIndex-1);
        int nextOpIndex = getNextNonNumber(s, opIndex+1, end);
        if(nextOpIndex < 0) return apply(s.charAt(opIndex), result, getValue(s, opIndex+1, end));
        while(!isOpeningParanthesis(s.charAt(nextOpIndex))) {
            result = apply(s.charAt(opIndex), result, getValue(s, opIndex+1, nextOpIndex-1));
            opIndex = nextOpIndex;
            nextOpIndex = getNextNonNumber(s, nextOpIndex+1, end);
            if(nextOpIndex < 0) return apply(s.charAt(opIndex), result, getValue(s, opIndex+1, end));
        }
        if(nextOpIndex >= 0) {
            int closingIndex = getClosingParanthesis(s, nextOpIndex+1, end);
            return calculate(String.valueOf(result)
                            + s.charAt(opIndex)
                            + calculate(s.substring(nextOpIndex+1, closingIndex))
                            + s.substring(closingIndex+1, end+1));
        }
        return 0;
    }
    
    private long apply(char operator, long operand1, long operand2) {
        if(operator == '+') return operand1 + operand2;
        if(operator == '-') return operand1 - operand2;
        throw new IllegalArgumentException("Invalid operator " + operator);
    }
    
    private int getNextNonNumber(String s, int start, int end) {
        boolean numFound = false;
        for(int i=start; i<=end; i++) {
            if((numFound && isOperator(s.charAt(i))) || isOpeningParanthesis(s.charAt(i))) return i;
            numFound = true;
        }
        return -1;
    }
    
    private int getClosingParanthesis(String s, int start, int end) {
        int depth = 1;
        for(int i=start; i<=end; i++) {
            if(isClosingParanthesis(s.charAt(i))) {
                depth--;
                if(depth == 0) return i;
            } else if(isOpeningParanthesis(s.charAt(i))) {
                depth++;
            }
        }
        return -1;
    }
    
    private boolean isOpeningParanthesis(char ch) {
        return ch == '(';
    }
    
    private boolean isClosingParanthesis(char ch) {
        return ch == ')';
    }
    
    private boolean isOperator(char operator) {
        return ("+-".indexOf(operator) >= 0);
    }
    
    private long getValue(String s, int start, int end) {
        return Integer.parseInt(s.substring(start, end+1).trim());
    }
}