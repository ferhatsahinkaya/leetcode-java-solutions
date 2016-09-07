public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> values = new HashSet<>();
        int length1 = nums1.length;
        for(int i=0; i<length1; i++) {
            values.add(nums1[i]);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        int length2 = nums2.length;
        for(int i=0; i<length2; i++) {
            if(values.contains(nums2[i])) {
                intersectionSet.add(nums2[i]);
            }
        }
        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for(int value : intersectionSet) {
            result[index++] = value;
        }
        return result;
    }
}