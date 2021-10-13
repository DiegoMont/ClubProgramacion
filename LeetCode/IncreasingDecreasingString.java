import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sortString("rat"));
    }
}

class Solution {
    int[] buckets = new int[26];
    int n;
    public String sortString(String s) {
        n = s.length();
        String result = "";
        countLetters(s);
        while(n != 0){
            char lastAppended = pickSmallerLetter((byte) 0);
            while (lastAppended != ' ') {
                result += lastAppended;
                lastAppended = pickSmallerLetter((byte) (lastAppended + 1 - 'a'));
            }
            lastAppended = pickLargerLetter((byte) (buckets.length - 1));
            while (lastAppended != ' ') {
                result += lastAppended;
                lastAppended = pickLargerLetter((byte) (lastAppended - 1 - 'a'));
            }
        }
        return result;
    }

    private void countLetters(String s){
        for (int i = n -1; i != -1; i--) {
            char letter = s.charAt(i);
            buckets[letter - 'a']++;
        }
    }

    private char pickSmallerLetter(byte start){
        for(byte i = start; i < buckets.length; i++)
            if(buckets[i] > 0)
                return extractLetter(i);
        return ' ';
    }

    private char pickLargerLetter(byte start){
        for(byte i = start; i > -1; i--)
            if(buckets[i] > 0)
                return extractLetter(i);
        return ' ';
    }

    private char extractLetter(byte i){
        buckets[i]--;
        n--;
        char letter = (char) (i + 'a');
        return letter;
    }
}
