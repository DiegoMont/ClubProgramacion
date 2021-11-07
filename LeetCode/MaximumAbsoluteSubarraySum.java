class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2,-5,1,-4,3,-2};
        System.out.println(s.maxAbsoluteSum(arr));
    }
}

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int positiveMax = nums[0];
        int negativeMax = nums[0];
        int max = Math.abs(positiveMax);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            positiveMax = Math.max(num, num + positiveMax);
            negativeMax = Math.min(num, num + negativeMax);
            int absVal = Math.max(Math.abs(negativeMax), positiveMax);
            if (absVal > max)
                max = absVal;
        }
        return max;
    }
}
