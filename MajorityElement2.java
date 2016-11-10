public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        if(length <= 0) return result;
        Arrays.sort(nums);
        
        int val1 = nums[length/3];
        int val2 = nums[length*2/3];
        
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<length; i++) {
            if(val1 == nums[i]) {
                count1++;
            }
            if(val2 == nums[i]) {
                count2++;
            }
        }
        if(count1 > length/3) {
            result.add(val1);
        }
        if((val1 != val2) && (count2 > length/3)) {
            result.add(val2);
        }
        return result;
    }
}