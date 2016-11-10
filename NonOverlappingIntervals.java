/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int length = intervals.length;
        if(length <= 1) return 0;
        
        int[] counts = new int[length];
        List<Interval> intervalList = new ArrayList<>();
        for(Interval interval : intervals) {
            intervalList.add(interval);
        }
        Collections.sort(intervalList, new Comparator<Interval>() {
            public int compare(Interval int1, Interval int2) {
                if(int1.start == int2.start) return 0;
                return (int1.start > int2.start) ? 1 : -1;
            }
        });
        
        int maxNonOverlapLength = 0;
        for(int i=0; i<length; i++) {
            int count = 1;
            for(int j=0; j<i; j++) {
                if(!hasOverlap(intervalList.get(j), intervalList.get(i))) {
                    count = Math.max(count, counts[j]+1);
                }
            }
            counts[i] = count;
            maxNonOverlapLength = Math.max(maxNonOverlapLength, counts[i]);
        }
        return length - maxNonOverlapLength;
    }
    private boolean hasOverlap(Interval int1, Interval int2) {
        return int1.end > int2.start;
    }
}