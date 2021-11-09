import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("MMMCMXCIX"));
    }
}

class Solution {
    private static HashMap<String, Integer> romanNumerals;

    public int romanToInt(String s) {
        if (romanNumerals == null)
            getRomanNumerals();
        return romanNumerals.get(s);
    }

    private void getRomanNumerals(){
        romanNumerals = new HashMap<>();
        for(int num = 1; num < 4000; num++){
            String romaString = intToRoman(num);
            romanNumerals.put(romaString, num);
        }
    }

    private String intToRoman(int n){
        StringBuilder romanNum = new StringBuilder();
        int num = n;
        appendThousands(romanNum, num / 1000);
        num %= 1000;
        appendHundreds(romanNum, num / 100);
        num %= 100;
        appendTens(romanNum, num / 10);
        num %= 10;
        appendsUnits(romanNum, num / 1);
        return romanNum.toString();
    }

    private void appendThousands(StringBuilder romanNum, int val){
        appendChar(romanNum, val, 'M');
    }

    private void appendHundreds(StringBuilder romanNum, int val){
        translateNumber(romanNum, val, "CM", 'D', 'C');
    }

    private void appendTens(StringBuilder romanNum, int val){
        translateNumber(romanNum, val, "XC", 'L', 'X');
    }

    private void appendsUnits(StringBuilder romanNum, int val){
        translateNumber(romanNum, val, "IX", 'V', 'I');
    }

    private void appendChar(StringBuilder romanNum, int lettersToAppend, char letter){
        for (int i = 0; i < lettersToAppend; i++)
            romanNum.append(letter);
    }

    private void translateNumber(StringBuilder romanNum, int val, String nineValue, char fiveValue, char oneValue){
        int onesToAdd = 0;
        if(val == 9)
            romanNum.append(nineValue);
        else if(val == 4){
            romanNum.append(oneValue);
            romanNum.append(fiveValue);
        } else if(val > 4){
            romanNum.append(fiveValue);
            onesToAdd = val - 5;
        } else
            onesToAdd = val;
        appendChar(romanNum, onesToAdd, oneValue);
    }
}
