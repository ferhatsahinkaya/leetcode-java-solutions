public class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        int length = nums.length;
        sums = new int[length];
        Arrays.fill(sums, 0);
        for(int i=0; i<length; i++) {
            sums[i] = (i > 0) ? (sums[i-1] + nums[i]) : nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - ((i > 0) ? sums[i-1] : 0);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);