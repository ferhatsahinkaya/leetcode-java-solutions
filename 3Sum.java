public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if(length < 3) return result;
        
        Arrays.sort(nums);
        
        for(int i=0; i<length-2;) {
            int first = nums[i];
            int j = i+1;
            int k = length-1;
            while(j < k) {
                int second = nums[j];
                int third = nums[k];
                
                int sum = first + second + third;
                if(sum == 0) {
                    List<Integer> combination = new ArrayList<>();
                    combination.add(first);
                    combination.add(second);
                    combination.add(third);
                    result.add(combination);
                    
                    while((j < k) && (nums[k] == third)) k--;
                    while((j < k) && (nums[j] == second)) j++;
                } else if(sum > 0) {
                    while((j < k) && (nums[k] == third)) k--;
                } else {
                    while((j < k) && (nums[j] == second)) j++;
                }
            }
            while((i < length-2) && (nums[i] == first)) i++;
        }
        return result;
    }
}