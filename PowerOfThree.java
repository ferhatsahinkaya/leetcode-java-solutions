public class Solution {
    public boolean isPowerOfThree(int n) {
        return isInteger(Math.log10(n) / Math.log10(3));
    }
    private boolean isInteger(double value) {
        return Math.abs(value - Math.floor(value)) < 0.0000000001;
    }
}