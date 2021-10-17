class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] milestones = {4, 1, 10};
        System.out.println(s.numberOfWeeks(milestones));
    }
}

class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0L;
        int max = 0;
        for (int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
        }
        long secondLeast = sum - max;
        return Math.min(secondLeast * 2 + 1, sum);
    }
}
