class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minOperations(39) == 3);
        System.out.println(s.minOperations(54) == 3);
        System.out.println(s.minOperations(1) == 1);
        System.out.println(s.minOperations(7) == 2);
        System.out.println(s.minOperations(23) == 3);
        System.out.println(s.minOperations(16) == 1);
    }

    public int minOperations(int n) {
        int[] binary = this.getAsBinArray(n);
        int groupsCount = this.countGroupsOfOnes(binary);
        int ones = this.countOnes(binary);
        int result = groupsCount + ones;
        return result;
    }

    private int[] getAsBinArray(int n) {
        String binary = Integer.toBinaryString(n);
        int[] bits = new int[binary.length() + 1];
        for (int i = 0; i < binary.length(); i++)
            bits[i] = binary.charAt(i) == '1' ? 1: 0;
        return bits;
    }

    private int countGroupsOfOnes(int[] binary) {
        int lastZero = -1;
        int lastValue = binary[0];
        int groupsOfOnesCount = 0;
        for (int i = 1; i < binary.length; i++) {
            if (binary[i] == 0) {
                boolean wasGroupOfOnes = i - lastZero > 2;
                lastZero = i;
                if (wasGroupOfOnes) {
                    binary[i] = 1;
                    groupsOfOnesCount++;
                    lastZero--;
                }
                lastValue = binary[i];
            } else {
                if (lastValue == 1) {
                    binary[i-1] = 0;
                    binary[i] = 0;
                }
                lastValue = 1;
            }
        }
        return groupsOfOnesCount;
    }

    private int countOnes(int[] binary) {
        int count = 0;
        for (int bit : binary)
            count += bit;
        return count;
    }
}
