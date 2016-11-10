public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int[] result = new int[2];
        int start = 0;
        int end = length-1;
        while(start < end) {
            int total = numbers[start] + numbers[end];
            if(total == target) {
                result[0] = start+1;
                result[1] = end+1;
                break;
            } else if(total > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}