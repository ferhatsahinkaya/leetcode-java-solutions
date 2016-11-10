public class Solution {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        Integer[] numbers = new Integer[length];
        for(int i=0; i<length; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers, new Comparator<Integer>() {
            public int compare(Integer val1, Integer val2) {
                return String.format("%d%d", val2, val1).compareTo(String.format("%d%d", val1, val2));
            }
        });
        StringBuilder builder = new StringBuilder();
        boolean nonZeroFound = false;
        for(int num : numbers) {
            if(num == 0 && !nonZeroFound) continue;
            if(num != 0) nonZeroFound = true;
            
            builder.append(num);
        }
        String result = builder.toString();
        return result.equals("") ? "0" : result;
    }
}