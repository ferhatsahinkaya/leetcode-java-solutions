public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int length1 = nums1.length;
        for(int i=0; i<length1; i++) {
            Integer count = map.get(nums1[i]);
            count = (count != null) ? count : 0;
            map.put(nums1[i], count+1);
        }
        
        List<Integer> intersectionList = new ArrayList<>();
        int length2 = nums2.length;
        for(int i=0; i<length2; i++) {
            Integer count = map.get(nums2[i]);
            count = (count != null) ? count : 0;
            if(count != 0) {
                map.put(nums2[i], count-1);
                intersectionList.add(nums2[i]);
            }
        }
        
        int index = 0;
        int[] result = new int[intersectionList.size()];
        for(int value : intersectionList) {
            result[index++] = value;
        }
        return result;
    }
}