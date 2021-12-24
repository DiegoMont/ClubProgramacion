import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution(3, 1);
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        solution.reset();
        System.out.println(Arrays.toString(solution.flip()));
    }
}

class Solution {
    private LinkedList<int[]> randomIndices;
    private int m, n;
    private int maxCallsToFlip;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        maxCallsToFlip = Math.min(1000, this.m * this.n);
        reset();
    }
    
    public int[] flip() {
        return randomIndices.pop();
    }
    
    public void reset() {
        randomIndices = new LinkedList<>();
        HashSet<String> selectedIndexes = new HashSet<>();
        Random r = new Random();
        for(int i = 0; i < maxCallsToFlip; i++){
            int x = r.nextInt(m);
            int y = r.nextInt(n);
            String possibleIndex;
            do {
                x = (x + 1) % m;
                if(x == 0)
                    y = (y + 1) % n;
                possibleIndex = x + " " + y;
            } while(selectedIndexes.contains(possibleIndex));
            selectedIndexes.add(possibleIndex);
            int[] index = {x, y};
            randomIndices.add(index);
        }
    }
}
