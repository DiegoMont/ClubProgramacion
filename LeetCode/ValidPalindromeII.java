class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validPalindrome("aba"));
        System.out.println(s.validPalindrome("abca"));
        System.out.println(!s.validPalindrome("abc"));
        System.out.println(!s.validPalindrome("eeccccbebaeeabebccceea"));
        System.out.println(s.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}

class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                boolean isLeftSubstitutionValid = true;
                boolean isRightSubstitutionValid = true;
                int x = i+1, y = j;
                while(x < y) {
                    if(s.charAt(x) != s.charAt(y)) {
                        isLeftSubstitutionValid = false;
                        break;
                    }
                    x++;
                    y--;
                }
                x = i; y = j-1;
                while(x < y) {
                    if(s.charAt(x) != s.charAt(y)) {
                        isRightSubstitutionValid = false;
                        break;
                    }
                    x++;
                    y--;
                }
                return isLeftSubstitutionValid || isRightSubstitutionValid;
            }
            i++;
            j--;
        }
        return true;
    }
}