public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int primeCount = primes.length;
        if(primeCount <= 0) return 1;
        
        int[] values = new int[n];
        values[0] = 1;
        
        int[] indexes = new int[primeCount];
        Arrays.fill(indexes, 0);
        
        Arrays.sort(primes);
        
        for(int i=1; i<n; i++) {
            int minValue = Integer.MAX_VALUE;
            for(int j=0; j<primeCount; j++) {
                minValue = Math.min(minValue, values[indexes[j]] * primes[j]);
            }
            values[i] = minValue;
            for(int j=0; j<primeCount; j++) {
                if(minValue == values[indexes[j]] * primes[j]) {
                    indexes[j]++;
                }
            }
        }
        return values[n-1];
    }
}