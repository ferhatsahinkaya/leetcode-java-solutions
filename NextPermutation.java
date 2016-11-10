public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        
        int maxIndex = length-1;
        int i=length-2;
        while(i>=0) {
            if(nums[maxIndex] > nums[i]) {
                int minIndex = maxIndex;
                for(int j=i+1; j<length; j++) {
                    if((nums[i] < nums[j]) && (nums[minIndex] > nums[j])) {
                        minIndex = j;
                    }
                }
                swap(nums, minIndex, i);
                break;
            } else {
                maxIndex = i;
            }
            i--;
        }
        sort(nums, i+1, length-1);
    }
    private void sort(int[] nums, int start, int end) {
        if(start >= end) return;
        int lastLess = start;
        int pivot = start;
        for(int i=start+1; i<=end; i++) {
            if(nums[i] < nums[pivot]) {
                swap(nums, ++lastLess, i);
            }
        }
        swap(nums, pivot, lastLess);
        sort(nums, start, lastLess-1);
        sort(nums, lastLess+1, end);
    }
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}