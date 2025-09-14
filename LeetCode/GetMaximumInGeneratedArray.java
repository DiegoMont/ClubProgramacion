class Solution {
    private int[] nums;

    public Solution() {
        nums = new int[101];
        nums[1] = 1;
        int i;
        for(i = 1; i * 2 + 1 < nums.length; i++) {
            nums[2*i] = nums[i];
            nums[2*i+1] = nums[i] + nums[i+1];
        }
        nums[2*i] = nums[i];
    }

    public int getMaximumGenerated(int n) {
        int max = 0;
        for (int i = 0; i < n+1; i++)
            if (this.nums[i] > max)
                max = this.nums[i];
        return max;
    }
}
