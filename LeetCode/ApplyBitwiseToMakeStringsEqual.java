class Solution {
    public boolean makeStringsEqual(String s, String target) {
        int sCount = countOnes(s);
        int targetCount = countOnes(target);
        if (targetCount == 0)
            return sCount == 0;
        else
            return sCount > 0;
    }

    private int countOnes(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '1')
                count++;
        return count;
    }
}
