public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(n != 1) {
            n = getNext(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
    private int getNext(int n) {
        int total = 0;
        while(n != 0) {
            int digit = n % 10;
            total += digit * digit;
            n /= 10;
        }
        return total;
    }
}