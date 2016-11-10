public class Solution {
    public int integerReplacement(int n) {
        if(n == 1) return 0;
        
        long longN = n;
        Set<Long> set = new HashSet<>();
        set.add(longN);
        int stepCount = 1;
        while(true) {
            Set<Long> nextSet = new HashSet<>();
            for(long value : set) {
                if(value % 2 == 0) {
                    nextSet.add(value / 2);
                } else {
                    nextSet.add(value + 1);
                    nextSet.add(value - 1);
                }
                if(nextSet.contains(1L)) return stepCount;
            }
            stepCount++;
            set = nextSet;
        }
    }
}