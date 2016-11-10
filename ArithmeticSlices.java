public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int length = A.length;
        int i = 0;
        int result = 0;
        while(i+2 < length) {
            int j = i;
            int count = 1;
            int diff = A[j+1] - A[j];
            while((j+1 < length) && (A[j+1] - A[j] == diff))  {
                j++;
                count++;
            }
            int size = 3;
            while(count >= size) {
                result += count - (size - 1);
                size++;
            }
            i = j;
        }
        return result;
    }
}