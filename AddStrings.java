public class Solution {
    public String addStrings(String num1, String num2) {
        String sum = "";
        int runner1 = num1.length() - 1;
        int runner2 = num2.length() - 1;
        int carry = 0;
        
        while((runner1 >= 0) || (runner2 >= 0) || (carry > 0)) {
            int val1 = ((runner1 >= 0) ? num1.charAt(runner1) : '0') - '0';
            int val2 = ((runner2 >= 0) ? num2.charAt(runner2) : '0') - '0';
            
            int digitSum = val1 + val2 + carry;
            sum = String.valueOf((char) ((digitSum % 10) + '0')) + sum;
            carry = digitSum / 10;
            
            runner1--;
            runner2--;
        }
        return sum;
    }
}