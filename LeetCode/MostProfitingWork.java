import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[] difficulties = {2, 4, 6, 8, 10};
        int[] profits = {10, 20, 30, 40, 50};
        //int[] workers = {4, 5, 6, 7};
        int[] workers = {7};
        Solution s = new Solution();
        System.out.println(s.maxProfitAssignment(difficulties, profits, workers) == 100);
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<Work> sortedWorks = sortWorks(difficulty, profit);
        int[][] maxProfits = getProfitsTable(sortedWorks);
        int maxProfit = 0;
        for(int workerAbillity: worker) {
            int index = findIndexMaxDifficulty(maxProfits, workerAbillity);
            System.out.println(index);
            maxProfit += maxProfits[index][1];
        }
        return maxProfit;
    }

    private PriorityQueue<Work> sortWorks(int[] difficulties, int[] profits) {
        PriorityQueue<Work> sortedWorks = new PriorityQueue<>();
        for(int i = 0; i < profits.length; i++) {
            Work work = new Work(difficulties[i], profits[i]);
            sortedWorks.add(work);
        }
        return sortedWorks;
    }

    private int[][] getProfitsTable(PriorityQueue<Work> sortedWorks){
        int[][] maxProfits = new int[sortedWorks.size()][2];
        Work w = sortedWorks.poll();
        maxProfits[0][0] = w.difficulty;
        maxProfits[0][1] = w.profit;
        for (int i = 1; i < maxProfits.length; i++) {
            w = sortedWorks.poll();
            maxProfits[i][0] = w.difficulty;
            maxProfits[i][1] = maxProfits[i-1][1] + w.profit;
        }
        return maxProfits;
    }

    private int findIndexMaxDifficulty(int[][] maxProfits, int targetDifficulty) {
        int index = binarySearch(maxProfits, 0, maxProfits.length, targetDifficulty);
        System.out.println(index);
        do {
            index++;
        } while(index < maxProfits.length && targetDifficulty >= maxProfits[index][0]);
        index--;
        return index;
    }

    private int binarySearch(int[][] lista, int izq, int der, int element){
        if (der < izq)
            return der;
        int m = (der + izq) / 2;
        if(lista[m][0] == element)
            return m;
        else if(lista[m][0] > element)
            return binarySearch(lista, izq, m-1, element);
        else
            return binarySearch(lista, m+1, der, element);
     }

    private class Work implements Comparable<Work> {
        int difficulty;
        int profit ;

        public Work(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        public int compareTo(Work o) {
            return this.difficulty - o.difficulty;
        }
    }
}
