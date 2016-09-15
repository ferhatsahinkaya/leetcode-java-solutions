public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> added = new ArrayList<>();
        int length = digits.length;
        int runner = length-1;
        int carry = 1;
        while(runner >= 0 || carry != 0) {
            int value = (runner >= 0) ? digits[runner] : 0;
            int sum = value + carry;
            carry = sum / 10;
            added.add(sum % 10);
            runner--;
        }
        int[] result = new int[added.size()];
        int count = added.size();
        for(int i=count-1; i>=0; i--) {
            result[count-i-1] = added.get(i);
        }
        return result;
    }
}