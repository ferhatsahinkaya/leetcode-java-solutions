public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length <= 0) return new int[0];
        
        int[] result = new int[length-k+1];
        
        LinkedList<Integer> max = new LinkedList<>();
        for(int i=0; i<k; i++) {
            if(max.isEmpty()) {
                max.add(nums[i]);
            } else {
                while(!max.isEmpty() && (max.getFirst() < nums[i])) max.removeFirst();
                while(!max.isEmpty() && (max.getLast() < nums[i])) max.removeLast();
                max.add(nums[i]);
            }
        }
        result[0] = max.getFirst();
        for(int i=k; i<length; i++) {
            if(nums[i-k] == max.getFirst()) max.removeFirst();
            while(!max.isEmpty() && (max.getFirst() < nums[i])) max.removeFirst();
            while(!max.isEmpty() && (max.getLast() < nums[i])) max.removeLast();
            max.add(nums[i]);
            
            result[i-k+1] = max.getFirst();
        }
        return result;
    }
}