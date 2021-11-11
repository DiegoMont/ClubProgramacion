import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSteps(8));
    }
}

class Solution {
    public static int MAX_INPUT = 1000;
    public static int[] results;
    public int minSteps(int n) {
        if(results == null)
            getResults();
        return results[n];
    }

    private static void getResults(){
        results = new int[MAX_INPUT + 1];
        boolean[] compoundNumbers = new boolean[MAX_INPUT + 1];
        for(int i = 0; i < results.length; i++)
            results[i] = Integer.MAX_VALUE;
        results[1] = 0;
        for(int i = 2; i < results.length; i++){
            if(!compoundNumbers[i])
                results[i] = i;
            int j = 2;
            int operations = results[i] + 2;
            int evaluatingK = j * i;
            while(evaluatingK < results.length){
                compoundNumbers[evaluatingK] = true;
                results[evaluatingK] = Math.min(results[evaluatingK], operations);
                j++;
                evaluatingK = j * i;
                operations++;
            }
        }
    }
}