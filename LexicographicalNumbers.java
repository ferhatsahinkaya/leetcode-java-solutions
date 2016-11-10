public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        if(n <= 0) return result;

        result.add(1);
        for(int i=1; i<n; i++) {
            result.add(getNext(result.get(i-1), n));
        }
        return result;
    }
    private int getNext(long i, int n) {
        if(i*10 <= n) return ((int) i*10);
        
        while(i > 0) {
            long nextValue = i+1;
            if((i/10 == nextValue/10) && (nextValue <= n)) return (int) nextValue;
            i /= 10;
        }
        return -1;
    }
}