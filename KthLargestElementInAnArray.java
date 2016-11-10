public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        k = length - k;
        return findKthLargest(nums, 0, length-1, k);
    }
    private int findKthLargest(int[] nums, int start, int end, int index) {
        int lastLess = start;
        int pivot = start;
        for(int i=start+1; i<=end; i++) {
            if(nums[i] < nums[pivot]) {
                swap(nums, ++lastLess, i);
            }
        }
        swap(nums, lastLess, pivot);
        int foundIndex = lastLess - start;
        if(foundIndex == index) return nums[lastLess];
        if(foundIndex > index) return findKthLargest(nums, start, lastLess-1, index);
        return findKthLargest(nums, lastLess+1, end, index-foundIndex-1);
    }
    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}