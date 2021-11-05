import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] digits = {9,9,9,9};
        int[] nDigits = s.plusOne(digits);
        String result = Arrays.toString(nDigits);
        System.out.println(result);
        nDigits = s.plusOne(nDigits);
        result = Arrays.toString(nDigits);
        System.out.println(result);
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int carry;
        do {
            digits[i]++;
            carry = digits[i] / 10;
            if(carry == 1)
                digits[i] = 0;
            i--;
        } while(carry > 0 && i > -1);
        if(carry == 1){
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            digits = newDigits;
            digits[0] = carry;
        }
        return digits;
    }
}
