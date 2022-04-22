class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.repeatedStringMatch("ba", "ab") == 2);
        System.out.println(s.repeatedStringMatch("abcd", "cdabcdab") == 3);
        System.out.println(s.repeatedStringMatch("abceabcd", "abcda") == 2);
        System.out.println(s.repeatedStringMatch("a", "aa") == 2);
        System.out.println(s.repeatedStringMatch("a", "a") == 1);
        System.out.println(s.repeatedStringMatch("abcd", "abce") == -1);
        System.out.println(s.repeatedStringMatch("abc", "xazyabcujz") == -1);
        System.out.println(s.repeatedStringMatch("abc", "defghia") == -1);
        System.out.println(s.repeatedStringMatch("abc", "abcabcabc") == 3);
        System.out.println(s.repeatedStringMatch("aaac", "aaca") == 2);
        System.out.println(s.repeatedStringMatch("abcd", "cdabcdacdabcd") == -1);
        System.out.println(s.repeatedStringMatch("axaxaya", "axaya") == 1);
    }
}

class Solution {
    public int repeatedStringMatch(String a, String b) {
        String repeatedString = a;
        String pattern = b;
        int repeatsCount = 0;
        final int patternLength = b.length();
        final int stringLength = a.length();
        boolean solutionFound = false;
        final int maxPossibleCounts = (patternLength + stringLength) / stringLength;
        for (int starterI = 0; starterI < stringLength && !solutionFound; starterI++) {
            int repeatedStringI = starterI;
            int patternI = 0;
            repeatsCount = starterI == 0 ? 0: 1;
            while(patternI < patternLength){
                char patternChar = pattern.charAt(patternI);
                char stringChar = repeatedString.charAt(repeatedStringI);
                System.out.println(patternChar + "   " + stringChar);
                if(repeatedStringI == 0) {
                    if(repeatsCount > maxPossibleCounts)
                        break;
                    repeatsCount++;
                }
                repeatedStringI++;
                if(patternChar != stringChar) {
                    if(repeatedStringI == stringLength)
                        break;
                    patternI = -1;
                }
                patternI++;
                if(patternI == patternLength)
                    return repeatsCount;
                repeatedStringI %= stringLength;
            }
            solutionFound = patternI == patternLength;
        }
        if(solutionFound)
            return repeatsCount;
        else
            return -1;
    }

}
