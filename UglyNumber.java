public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        
        num = divideBy(num, 2);
        num = divideBy(num, 3);
        num = divideBy(num, 5);
        return (num == 1);
    }
    private int divideBy(int num, int divisor) {
        while(num % divisor == 0) {
            num /= divisor;
        }
        return num;
    }
}