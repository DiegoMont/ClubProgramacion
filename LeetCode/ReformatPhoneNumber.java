import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reformatNumber("1-23-45 6"));
    }
}

class Solution {
    StringBuilder reformattedNumber = new StringBuilder();
    LinkedList<Character> queue = new LinkedList<>();

    public String reformatNumber(String number) {
        int n = number.length();
        for(int i = 0; i < n; i++){
            char currentChar = number.charAt(i);
            if(isDigit(currentChar)){
                queue.add(currentChar);
                if(queue.size() == 5)
                    addGroupOfN(3);
            }
        }
        if(queue.size() == 3)
            addGroupOfN(3);
        else
            while(!queue.isEmpty())
                addGroupOfN(2);
        reformattedNumber.deleteCharAt(reformattedNumber.length() - 1);
        return reformattedNumber.toString();
    }

    private boolean isDigit(char digit){
        return digit > '/' && digit < ':';
    }

    private void addGroupOfN(int n){
        while(n > 0){
            reformattedNumber.append(queue.poll());
            n--;
        }
        reformattedNumber.append("-");
    }
}
