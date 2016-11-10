public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, "", result);
        return result;
    }
    private void generateParenthesis(int left, int right, String current, List<String> result) {
        if(left > right) return;
        if(left == 0 && right == 0) {
            result.add(current);
            return;
        }
        
        if(left > 0) {
            generateParenthesis(left-1, right, current + "(", result);
        }
        if(right > 0) {
            generateParenthesis(left, right-1, current + ")", result);
        }
    }
}