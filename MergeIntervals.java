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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int length = intervals.size();
        if(length <= 0) return result;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval int1, Interval int2) {
                return int1.start - int2.start;
            }
        });
        
        result.add(intervals.get(0));
        for(int i=1; i<length; i++) {
            Interval interval = intervals.get(i);
            Interval lastInterval = result.get(result.size()-1);
            if(hasOverlap(lastInterval, interval)) {
                lastInterval.end = Math.max(lastInterval.end, interval.end);
            } else {
                result.add(interval);
            }
        }
        return result;
    }
    private boolean hasOverlap(Interval int1, Interval int2) {
        return int2.start <= int1.end;
    }
}