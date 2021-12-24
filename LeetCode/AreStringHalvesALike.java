import java.util.HashMap;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.halvesAreAlike("ae"));
        System.out.println(s.halvesAreAlike("aA"));
        System.out.println(s.halvesAreAlike("book"));
        System.out.println(s.halvesAreAlike("textbook"));
    }
}

class Solution {
    HashSet<Character> vowels;
    
    public Solution(){
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }
    public boolean halvesAreAlike(String s) {
        int i, mid = s.length() / 2;
        int vowelCount = 0;
        for(i = 0; i < mid; i++){
            char currentLetter = s.charAt(i);
            if(isVowel(currentLetter))
                vowelCount++;
        }
        for(; i < s.length(); i++){
            char currentLetter = s.charAt(i);
            if(isVowel(currentLetter))
                vowelCount--;
        }
        return vowelCount == 0;
    }

    private boolean isVowel(char letter){
        return vowels.contains(letter);
    }
}
