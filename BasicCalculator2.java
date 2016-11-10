public class Solution {
    public int calculate(String s) {
        return (int) calculate(s, 0, s.length()-1);
    }
    
    private long calculate(String s, int start, int end) {
        int opIndex = getNextOperatorIndex(s, start+1, end);
        if(opIndex < 0) return getValue(s, start, end);
        
        long result = getValue(s, start, opIndex-1);
        int nextOpIndex = getNextOperatorIndex(s, opIndex+1, end);
        if(nextOpIndex < 0) return apply(s.charAt(opIndex), result, getValue(s, opIndex+1, end));
        
        while(!hasMorePrecedence(s.charAt(nextOpIndex), s.charAt(opIndex))) {
            result = apply(s.charAt(opIndex), result, getValue(s, opIndex+1, nextOpIndex-1));
            opIndex = nextOpIndex;
            nextOpIndex = getNextOperatorIndex(s, opIndex+1, end);
            if(nextOpIndex < 0) return apply(s.charAt(opIndex), result, getValue(s, opIndex+1, end));
        }
        if(nextOpIndex >= 0) {
            int startIndex = opIndex+1;
            opIndex = nextOpIndex;
            nextOpIndex = getNextOperatorIndex(s, nextOpIndex+1, end);
            if(nextOpIndex < 0) return apply(s.charAt(startIndex-1), result, calculate(s, startIndex, end));

            while(hasSamePrecedence(s.charAt(opIndex), s.charAt(nextOpIndex))) {
                nextOpIndex = getNextOperatorIndex(s, nextOpIndex+1, end);
                if(nextOpIndex < 0) return apply(s.charAt(startIndex-1), result, calculate(s, startIndex, end));
            }
            return calculate(String.valueOf(result) 
                            + String.valueOf(s.charAt(startIndex-1)) 
                            + calculate(s, startIndex, nextOpIndex-1)
                            + s.substring(nextOpIndex, end+1));
        }
        return result;
    }
    
    private long getValue(String s, int start, int end) {
        return Integer.parseInt(s.substring(start, end+1).trim());
    }
    
    private int getNextOperatorIndex(String s, int start, int end) {
        for(int i=start; i<=end; i++) {
            if(isOperator(s.charAt(i))) return i;
        }
        return -1;
    }
    
    private boolean hasSamePrecedence(char operator1, char operator2) {
        return (("+-".indexOf(operator1) >= 0) && ("+-".indexOf(operator2) >= 0))
                || (("*/".indexOf(operator1) >= 0) && ("*/".indexOf(operator2) >= 0));
    }
    
    private boolean hasMorePrecedence(char operator1, char operator2) {
        return ("*/".indexOf(operator1) >= 0) && ("+-".indexOf(operator2) >= 0);
    }
    
    private long apply(char operator, long operand1, long operand2) {
        if(operator == '+') return operand1 + operand2;
        if(operator == '-') return operand1 - operand2;
        if(operator == '*') return operand1 * operand2;
        if(operator == '/') return operand1 / operand2;
        throw new IllegalArgumentException("Invalid operator " + operator);
    }
    
    private boolean isOperator(char ch) {
        return "+-*/".indexOf(ch) >= 0;
    }
}