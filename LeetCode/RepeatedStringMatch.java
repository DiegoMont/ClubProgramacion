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
        System.out.println(s.repeatedStringMatch("abababaaba", "aabaaba") == 2);
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
        final int maxPossibleCounts = (patternLength + stringLength) / stringLength + 1;
        for (int starterI = 0; starterI < stringLength && !solutionFound; starterI++) {
            int repeatedStringI = starterI;
            int patternI = 0;
            repeatsCount = starterI == 0 ? 0: 1;
            while(patternI < patternLength){
                repeatedStringI %= stringLength;
                char patternChar = pattern.charAt(patternI);
                char stringChar = repeatedString.charAt(repeatedStringI);
                if(repeatedStringI == 0)
                    repeatsCount++;
                repeatedStringI++;
                patternI++;
                if(patternChar != stringChar || repeatsCount > maxPossibleCounts)
                    break;
            }
            solutionFound = patternI == patternLength && pattern.charAt(patternI-1) == repeatedString.charAt(repeatedStringI-1);
        }
        if(solutionFound)
            return repeatsCount;
        else
            return -1;
    }

}
