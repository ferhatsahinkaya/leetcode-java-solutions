public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < length) {
            int start = i;
            do {
                i++;
            } while((i < length) && (nums[i] == nums[i-1]+1));
            
            result.add((i <= start+1) ? String.valueOf(nums[start]) : String.format("%d->%d", nums[start], nums[i-1]));
        }
        return result;
    }
}