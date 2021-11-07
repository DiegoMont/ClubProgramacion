import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canConstruct("aa", "aab"));
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> foundCharacters = new HashMap<>();
        int n = magazine.length();
        for(int i = 0; i < n; i++){
            char letter = magazine.charAt(i);
            if(foundCharacters.get(letter) == null)
                foundCharacters.put(letter, 1);
            else {
                int count = foundCharacters.get(letter) + 1;
                foundCharacters.put(letter, count);
            }
        }
        n = ransomNote.length();
        for(int i = 0; i < n; i++){
            char letter = ransomNote.charAt(i);
            Integer remainingCharacters = foundCharacters.get(letter);
            if(remainingCharacters == null || remainingCharacters == 0)
                return false;
            foundCharacters.put(letter, remainingCharacters - 1);
        }
        return true;
    }
}
