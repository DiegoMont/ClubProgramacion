class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(!s.checkIfPangram("leetcode"));
    }
}

class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] letterOcurrences = new int[26];
        int n = sentence.length();
        for(int i = 0; i < n; i++) {
            char letter = sentence.charAt(i);
            int letterIndex = ((int) letter) - 97;
            letterOcurrences[letterIndex] = 1;
        }
        for (int count : letterOcurrences) {
            if(count == 0)
                return false;
        }
        return true;
    }
}