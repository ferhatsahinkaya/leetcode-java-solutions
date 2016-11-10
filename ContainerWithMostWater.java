public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while(start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));
            if(height[end] > height[start]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}