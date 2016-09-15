public class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        
        int end1 = a.length() - 1;
        int end2 = b.length() - 1;
        int carry = 0;
        while(end1 >= 0 || end2 >= 0 || carry > 0) {
            int val1 = (end1 >= 0) ? (a.charAt(end1--) - '0') : 0;
            int val2 = (end2 >= 0) ? (b.charAt(end2--) - '0') : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 2;
            result = String.valueOf(sum % 2) + result;
        }
        return result.equals("") ? "0" : result;
    }
}