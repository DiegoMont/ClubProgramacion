class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(" "));
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(!s.isPalindrome("race a car"));
        System.out.println(s.isPalindrome("a"));
        System.out.println(!s.isPalindrome("ab"));
        System.out.println(s.isPalindrome("aa"));
        System.out.println(s.isPalindrome("aba"));
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleanPalindrome = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(isValidCharacter(a))
                cleanPalindrome.append(Character.toLowerCase(a));
        }
        String word = cleanPalindrome.toString();
        int wordLength = word.length();
        if(wordLength < 2)
            return true;
        return isPalindrome(word, 0, wordLength-1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        char firstLetter = s.charAt(left);
        char lastLetter = s.charAt(right);
        if(firstLetter != lastLetter)
            return false;
        if(right - left < 2)
            return true;
        return isPalindrome(s, left+1, right-1);
    }

    private boolean isValidCharacter(char a) {
        return a > '@' && a < '[' || a > '`' && a < '{' || a > '/' && a < ':';
    }
}