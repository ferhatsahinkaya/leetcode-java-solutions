public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if(length <= 0) return result;
        
        Arrays.sort(nums);
        
        boolean nextFound = false;
        do {
            nextFound = false;
            result.add(getList(nums, length));
            
            int maxIndex = length-1;
            int i = length-2;
            while(i >= 0) {
                if(nums[i] >= nums[maxIndex]) {
                    maxIndex = i;
                } else {
                    int minIndex = maxIndex;
                    for(int j=i+1; j<length; j++) {
                        if((nums[j] > nums[i]) && (nums[minIndex] > nums[j])) {
                            minIndex = j;
                        }
                    }
                    swap(nums, minIndex, i);
                    sort(nums, i+1, length-1);
                    nextFound = true;
                    break;
                }
                i--;
            }
        } while(nextFound);
        
        return result;
    }
    private List<Integer> getList(int[] nums, int length) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<length; i++) {
            result.add(nums[i]);
        }
        return result;
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