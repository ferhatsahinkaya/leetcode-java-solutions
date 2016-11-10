public class Solution {
    public int thirdMax(int[] nums) {
        int length = nums.length;
        
        long[] max = new long[3];
        Arrays.fill(max, Long.MIN_VALUE);
        
        for(int i=0; i<length; i++) {
            if((nums[i] >= max[2]) && (nums[i] != max[0]) && (nums[i] != max[1]) && (nums[i] != max[2])) {
                max[2] = nums[i];
                sort(max);
            }
        }
        return (int) ((max[2] != Long.MIN_VALUE) ? max[2] : max[0]);
    }
    private void sort(long[] values) {
        for(int i=0; i<3; i++) {
            int maxIndex = i;
            for(int j=i; j<3; j++) {
                if(values[maxIndex] < values[j]) {
                    maxIndex = j;
                }
            }
            swap(values, maxIndex, i);
        }
    }
    private void swap(long[] values, int i, int j) {
        if(i != j) {
            long tmp = values[i];
            values[i] = values[j];
            values[j] = tmp;
        }
    }
}