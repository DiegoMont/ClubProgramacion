import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(s.numDifferentIntegers("leet1234code234"));
        System.out.println(s.numDifferentIntegers("a1b01c001"));
        System.out.println(s.numDifferentIntegers("a"));
        System.out.println(s.numDifferentIntegers("0"));
        System.out.println(s.numDifferentIntegers("12a"));
        System.out.println(s.numDifferentIntegers("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"));
        System.out.println(s.numDifferentIntegers("0w000w00"));
    }
}

class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<String> integers = new HashSet<>();
        boolean pendingCharacter = false;
        boolean hasLeadingZeros = false;
        StringBuilder unparsedInteger = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            if(isDigit(currentCharacter)){
                if(hasLeadingZeros){
                    unparsedInteger.deleteCharAt(0);
                    hasLeadingZeros = currentCharacter == '0';
                }
                unparsedInteger.append(currentCharacter);
                if(!pendingCharacter && currentCharacter == '0')
                    hasLeadingZeros = true;
                pendingCharacter = true;
            } else if(pendingCharacter){
                pendingCharacter = false;
                integers.add(unparsedInteger.toString());
                unparsedInteger = new StringBuilder();
                hasLeadingZeros = false;
            }
        }
        if(pendingCharacter)
            integers.add(unparsedInteger.toString());

        return integers.size();
    }

    private static boolean isDigit(char character){
        return character >= '0' && character <= '9';
    }
}
