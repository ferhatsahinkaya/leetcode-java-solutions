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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval int1, Interval int2) {
                return int1.start - int2.start;
            }
        });
        int length = intervals.size();
        result.add(intervals.get(0));
        for(int i=1; i<length; i++) {
            Interval nextInterval = intervals.get(i);
            Interval interval = result.get(result.size()-1);
            if(hasOverlap(interval, nextInterval)) {
                interval.end = Math.max(interval.end, nextInterval.end);
            } else {
                result.add(nextInterval);
            }
        }
        return result;
    }
    private boolean hasOverlap(Interval int1, Interval int2) {
        return int2.start <= int1.end;
    }
}