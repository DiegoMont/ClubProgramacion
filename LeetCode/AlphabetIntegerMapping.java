
class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}

class Solution {
    private StringBuilder ans;
    public String freqAlphabets(String s) {
        ans = new StringBuilder("");
        int i = s.length() - 1;
        while(i > -1){
            char currentDigit = s.charAt(i);
            char letter;
            if(currentDigit == '#'){
                String digitPair = s.substring(Math.max(0, i - 2), i);
                byte twoDigitValue = Byte.parseByte(digitPair);
                letter = (char) (twoDigitValue + '`');
                i-=3;
            } else {
                letter = (char) (currentDigit + '0');
                i--;
            }
            ans.insert(0, letter);
        }
        return ans.toString();
    }
}