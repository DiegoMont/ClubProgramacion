import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        System.out.println(Arrays.toString(s.numberOfLines(widths, "bbbcccdddaaa")));
    }
}

class Solution {
    public static int PIXELS_PER_LINE = 100;
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int remainingPixelsInLine = PIXELS_PER_LINE;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char letter = s.charAt(i);
            int letterWidth = widths[getLetterIndex(letter)];
            if(letterWidth > remainingPixelsInLine){
                lines++;
                remainingPixelsInLine = PIXELS_PER_LINE - letterWidth;
            } else {
                remainingPixelsInLine -= letterWidth;
            }
        }
        int[] ans = {lines, PIXELS_PER_LINE - remainingPixelsInLine};
        return ans;
    }

    private int getLetterIndex(char letter){
        return (int) (letter - 97);
    }
}
