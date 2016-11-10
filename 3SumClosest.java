public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        
        int i = 0;
        while(i < length-2) {
            int first = nums[i];
            int j = i+1;
            int k = length-1;
            while(j < k) {
                int second = nums[j];
                int third = nums[k];
                int currentSum = first + second + third;
                int diff = Math.abs(target - (currentSum));
                if(minDiff > diff) {
                    minDiff = diff;
                    closestSum = currentSum;
                    if(minDiff == 0) return target;
                }
                
                if(currentSum < target) {
                    while((j < k) && (second == nums[j])) j++;
                } else {
                    while((j < k) && (third == nums[k])) k--;
                }
            }
            while((i < length-2) && (first == nums[i])) i++;
        }
        return closestSum;
    }
}