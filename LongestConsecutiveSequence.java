public class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.get(num) == null) {
                map.put(num, 1);
                maxLength = Math.max(maxLength, merge(map, num-1, num));
                maxLength = Math.max(maxLength, merge(map, num, num+1));
            }
        }
        return maxLength;
    }
    private int merge(Map<Integer, Integer> map, int left, int right) {
        int leftBound = (map.get(left) != null) ? left-map.get(left)+1 : right;
        int rightBound = (map.get(right) != null) ? right+map.get(right)-1 : left;
        int size = rightBound - leftBound + 1;
        map.put(leftBound, size);
        map.put(rightBound, size);
        return size;
    }
}