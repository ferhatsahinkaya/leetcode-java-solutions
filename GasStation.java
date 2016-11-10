public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if(length <= 0) return -1;
        
        int[] values = new int[length];
        int netValue = 0;
        for(int i=0; i<length; i++) {
            values[i] = gas[i] - cost[i];
            netValue += values[i];
        }
        if(netValue < 0) return -1;
        
        int start = (values[0] > 0) ? 0 : 1;
        for(int i=1; i<length; i++) {
            if(values[i] < values[i-1] + values[i]) {
                values[i] += values[i-1];
            }
            if(values[i] < 0) {
                start = i+1;
            }
        }
        return start % length;
    }
}