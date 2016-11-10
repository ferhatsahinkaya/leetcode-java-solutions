public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int start = 0;
        int end = length-1;
        
        int hIndex = 0;
        while(start <= end) {
            int mid = start + ((end-start) / 2);
            if(citations[mid] <= length-mid) {
                hIndex = Math.max(hIndex, citations[mid]);
                start = mid+1;
            } else {
                hIndex = Math.max(hIndex, length-mid);
                end = mid-1;
            }
        }
        return hIndex;
    }
}