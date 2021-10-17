class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        //int[] weights = {1};
        System.out.println(s.shipWithinDays(weights, 5));
    }
}

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int leastCapacity = weights[weights.length - 1];
        for (int weight : weights)
            leastCapacity = Math.max(leastCapacity, weight);
        while (true) {
            int daysNeeded = 0;
            int addedWeight = 0;
            for (int weight: weights) {
                addedWeight += weight;
                if(addedWeight >= leastCapacity){
                    daysNeeded++;
                    if(daysNeeded > days)
                      break;
                    addedWeight = addedWeight > leastCapacity ? weight: 0;
                }
            }
            if(addedWeight > 0)
                daysNeeded++;
            if(daysNeeded <= days)
                break;
            leastCapacity++;
        }
        return leastCapacity;
    }
}
