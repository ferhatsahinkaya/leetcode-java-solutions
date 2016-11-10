public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if(length < 4) return result;
        
        Arrays.sort(nums);
        
        int i = 0;
        while(i < length-3) {
            int first = nums[i];
            int j = i+1;
            while(j < length-2) {
                int second = nums[j];
                int firstTwo = first + second;
                
                int k = j+1;
                int t = length-1;
                while(k < t) {
                    int third = nums[k];
                    int fourth = nums[t];
                    
                    int sum = firstTwo + third + fourth;
                    if(sum == target) {
                        List<Integer> combination = new ArrayList<>();
                        combination.add(first);
                        combination.add(second);
                        combination.add(third);
                        combination.add(fourth);
                        result.add(combination);
                        
                        while((k < t) && (nums[k] == third)) k++;
                        while((k < t) && (nums[t] == fourth)) t--;
                    } else if(sum < target) {
                        while((k < t) && (nums[k] == third)) k++;
                    } else {
                        while((k < t) && (nums[t] == fourth)) t--;
                    }
                }
                while((j < length-2) && (nums[j] == second)) j++;
            }
            while((i < length-3) && (nums[i] == first)) i++;
        }
        return result;
    }
}