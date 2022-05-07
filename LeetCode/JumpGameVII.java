import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(!s.canReach("01111010", 2, 3));
        System.out.println(s.canReach("011010", 2, 3));
        System.out.println(!s.canReach("0011010", 2, 3));
        System.out.println(!s.canReach("01101110", 2, 3));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append('0');
        }
        System.out.println(s.canReach(sb.toString(), 5, 9998));
    }
}

class Solution {
    String s;
    int minJump, maxJump;
    int sLength;
    HashMap<Integer, Boolean> recursionTable;
    
    public boolean canReach(String s, int minJump, int maxJump) {
        sLength = s.length();
        if(s.charAt(sLength-1) == '1')
            return false;
        this.s = s;
        this.minJump = minJump;
        this.maxJump = maxJump;
        int counter = 0;
        int groupLetter = s.charAt(0);
        for (int i = 0; i < sLength; i++) {
            char currentPlace = s.charAt(i);
            if(groupLetter == currentPlace)
                counter++;
            else {
                if(currentPlace == '0' && counter >= maxJump)
                    return false;
                counter = 1;
                groupLetter = currentPlace;
            }
        }
        recursionTable = new HashMap<>();
        return canReachRec(0);
    }

    private boolean canReachRec(int from) {
        if(from == sLength-1)
            return true;
        else if('1' == s.charAt(from))
            return false;
        if(recursionTable.containsKey(from))
            return recursionTable.get(from);
        int nextNought = Math.min(from + maxJump, sLength-1);
        final int minNought = from + minJump;
        boolean canReach = false;
        while(nextNought >= minNought&& !canReach) {
            canReach |= canReachRec(nextNought);
            nextNought--;
        }
        recursionTable.put(from, canReach);
        return recursionTable.get(from);
    }
}
