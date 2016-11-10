public class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        
        int sqrtN = (int) Math.sqrt(n);
        for(int i=2; i<=sqrtN; i++) {
            if(!primes[i]) continue;
            
            int j = i;
            while((j + i) < n) {
                primes[j+i] = false;
                j += i;
            }
        }
        int primeCount = 0;
        for(int i=0; i<n; i++) {
            if(primes[i]) primeCount++;
        }
        return primeCount;
    }
}