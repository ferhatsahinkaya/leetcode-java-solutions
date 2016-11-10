public class Solution {
    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<length; i++) {
            if(isOperator(tokens[i])) {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                stack.push(apply(tokens[i], leftOperand, rightOperand));
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    private int apply(String operator, int leftOperand, int rightOperand) {
        if("+".equals(operator)) return leftOperand + rightOperand;
        if("-".equals(operator)) return leftOperand - rightOperand;
        if("*".equals(operator)) return leftOperand * rightOperand;
        return leftOperand / rightOperand;
    }
    private boolean isOperator(String token) {
        return "+-*/".indexOf(token) != -1;
    }
}