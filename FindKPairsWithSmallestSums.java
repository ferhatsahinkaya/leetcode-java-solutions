public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> pairs = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int[] indexes = new int[length1];
        Arrays.fill(indexes, 0);
        
        for(int i=0; i<k; i++) {
            int firstIndex = -1;
            int secondIndex = -1;
            int minTotal = Integer.MAX_VALUE;
            
            for(int j=0; j<length1; j++) {
                if(indexes[j] < length2) {
                    if(minTotal > nums1[j] + nums2[indexes[j]]) {
                        minTotal = nums1[j] + nums2[indexes[j]];
                        firstIndex = j;
                        secondIndex = indexes[j];
                    }
                }
            }
            if(firstIndex >= 0) {
                pairs.add(new int[] {nums1[firstIndex], nums2[indexes[firstIndex]]});
                indexes[firstIndex]++;
            } else {
                break;
            }
        }
        return pairs;
    }
}