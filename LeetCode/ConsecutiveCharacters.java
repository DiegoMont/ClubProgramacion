// 1446. Consecutive Characters

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxPower("leetcode") == 2);
        System.out.println(s.maxPower("abbcccddddeeeeedcba") == 5);
        System.out.println(s.maxPower("tourist") == 1);
        System.out.println(s.maxPower("a") == 1);
        System.out.println(s.maxPower("aab") == 2);
    }
}

class Solution {
    public int maxPower(String s) {
        int power = 1;
        int i = 0;
        char sameCharacter = s.charAt(i);
        int n = s.length();
        int currentCount = 1;
        for(i = 1; i < n; i++) {
            char currentCharacter = s.charAt(i);
            if(currentCharacter == sameCharacter)
                currentCount++;
            else {
                sameCharacter = currentCharacter;
                currentCount = 1;
            }
            power = Math.max(power, currentCount);
        }
        return power;
    }
}