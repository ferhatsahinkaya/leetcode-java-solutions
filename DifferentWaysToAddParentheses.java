public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, 0, input.length()-1);
    }
    private List<Integer> diffWaysToCompute(String input, int start, int end) {
        List<Integer> result = new ArrayList<>();
        if(start > end) return result;
        
        boolean operatorFound = false;
        for(int i=start; i<=end; i++) {
            if(isOperator(input.charAt(i))) {
                operatorFound = true;
                List<Integer> leftResult = diffWaysToCompute(input, start, i-1);
                List<Integer> rightResult = diffWaysToCompute(input, i+1, end);
                result.addAll(apply(leftResult, rightResult, input.charAt(i)));
            }
        }
        if(!operatorFound) {
            result.add(Integer.parseInt(input.substring(start, end+1)));
        }
        return result;
    }
    private List<Integer> apply(List<Integer> left, List<Integer> right, char operator) {
        List<Integer> result = new ArrayList<>();
        for(int leftOperand : left) {
            for(int rightOperand : right) {
                result.add(apply(leftOperand, rightOperand, operator));
            }
        }
        return result;
    }
    private int apply(int leftOperand, int rightOperand, char operator) {
        if(operator == '+') return leftOperand + rightOperand;
        if(operator == '-') return leftOperand - rightOperand;
        if(operator == '*') return leftOperand * rightOperand;
        throw new IllegalArgumentException(String.format("Invalid Operator: %c", operator));
    }
    private boolean isOperator(char ch) {
        return "+-*".indexOf(ch) >= 0;
    }
}