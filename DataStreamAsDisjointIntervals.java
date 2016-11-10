/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    private final Map<Integer, Integer> map = new TreeMap<>();
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        if(map.get(val) != null) return;
        map.put(val, 1);
        merge(map, val, val+1);
        merge(map, val-1, val);
    }
    
    private void merge(Map<Integer, Integer> map, int left, int right) {
        Integer leftSize = map.get(left);
        int leftBound = (leftSize != null) ? left-leftSize+1 : right;
        Integer rightSize = map.get(right);
        int rightBound = (rightSize != null) ? right+rightSize-1 : left;
        int totalSize = rightBound-leftBound+1;
        map.put(leftBound, totalSize);
        map.put(rightBound, totalSize);
    }
    
    public List<Interval> getIntervals() {
        List<Interval> intervals = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int start = entry.getKey();
            int end = start + entry.getValue() - 1;
            add(intervals, new Interval(start, end));
        }
        return intervals;
    }
    
    private void add(List<Interval> intervals, Interval interval) {
        if(intervals.isEmpty()) {
            intervals.add(interval);
        } else {
            Interval lastInterval = intervals.get(intervals.size()-1);
            if(!isOverlap(lastInterval, interval)) {
                intervals.add(interval);
            }
        }
    }
    
    private boolean isOverlap(Interval interval1, Interval interval2) {
        return interval1.end >= interval2.start;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */