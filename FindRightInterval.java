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
    public int[] findRightInterval(Interval[] intervals) {
        int length = intervals.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<length; i++) {
            map.put(intervals[i].start, i);
        }
        for(int i=0; i<length; i++) {
            Integer next = map.get(intervals[i].end);
            next = (next != null) ? next : map.higherKey(intervals[i].end);
            result[i] = (next != null) ? next : -1;
        }
        return result;
    }
}