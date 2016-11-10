public class Solution {
    public int bulbSwitch(int n) {
        int sqrt = (int) Math.sqrt(n) + 1;
        int count = 0;
        int i = 1;
        while((i <= sqrt) && (i * i <= n)) {
            count++;
            i++;
        }
        return count;
    }
}