import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[] difficulties = {2, 4, 6, 8, 10};
        int[] profits = {10, 20, 30, 40, 50};
        int[] workers = {4, 5, 6, 7};
        Solution s = new Solution();
        System.out.println(s.maxProfitAssignment(difficulties, profits, workers) == 100);
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int difficultyLimit = worker[worker.length - 1];
        PriorityQueue<Work> sortedWorks = sortWorks(difficulty, profit, difficultyLimit);
        int maxProfit = 0;
        int unasignedWorkers = worker.length - 1;
        while(sortedWorks.peek() != null) {
            Work w = sortedWorks.poll();
            int i;
            for (i = unasignedWorkers; i > -1; i--) {
                if(w.difficulty > worker[i]) {
                    unasignedWorkers = i;
                    break;
                } else
                    maxProfit += w.profit;
            }
            if(i == -1)
                break;
        }
        return maxProfit;
    }

    private PriorityQueue<Work> sortWorks(int[] difficulties, int[] profits, int difficultyLimit) {
        PriorityQueue<Work> sortedWorks = new PriorityQueue<>(11, new Comparator<Work>() {
            public int compare(Work o1, Work o2) {
                return -o1.compareTo(o2);
            }
        });
        for(int i = 0; i < profits.length; i++) {
            Work work = new Work(difficulties[i], profits[i]);
            if(!(work.difficulty > difficultyLimit))
                sortedWorks.add(work);
        }
        return sortedWorks;
    }

    private class Work implements Comparable<Work> {
        int difficulty;
        int profit ;

        public Work(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        public int compareTo(Work o) {
            return this.profit - o.profit;
        }

        public String toString() {
            return "Profit: " + profit + "   Difficulty: " + difficulty;
        }
    }
}
