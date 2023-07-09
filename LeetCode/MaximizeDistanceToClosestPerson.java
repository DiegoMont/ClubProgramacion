class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(s.maxDistToClosest(seats) == 2);
        int[] seats2 = {1,0,0,0};
        System.out.println(s.maxDistToClosest(seats2) == 3);
        int[] seats3 = {0, 0, 0, 0, 1};
        System.out.println(s.maxDistToClosest(seats3) == 4);
        int[] seats4 = {1, 0, 0, 1};
        System.out.println(s.maxDistToClosest(seats4) == 1);
        int[] seats5 = {1, 0, 0, 1, 0, 0};
        System.out.println(s.maxDistToClosest(seats5) == 2);
        int[] seats6 = {0, 1, 0, 1, 0};
        System.out.println(s.maxDistToClosest(seats6) == 1);
        int[] seats7 = {1,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0};
        System.out.println(s.maxDistToClosest(seats7) == 5);
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        int zerosAtTheBeginning = 0;
        int i;
        for (i = 0; i < seats.length; i++)
            if(seats[i] == 0)
                zerosAtTheBeginning++;
            else
                break;
        int zerosAtTheEnd = 0;
        int j;
        for(j = seats.length - 1; j > 0; j--)
            if(seats[j] == 0)
                zerosAtTheEnd++;
            else
                break;
        int maxConsecutiveZeros = 0;
        int currentConsecutiveZeros = 0;
        while(j > i) {
            if(seats[i] == 0)
                currentConsecutiveZeros++;
            else {
                maxConsecutiveZeros = Math.max(maxConsecutiveZeros, currentConsecutiveZeros);
                currentConsecutiveZeros = 0;
            }
            i++;
        }
        maxConsecutiveZeros = Math.max(maxConsecutiveZeros, currentConsecutiveZeros);
        int distanceToClosestPerson = maxConsecutiveZeros / 2 + (maxConsecutiveZeros & 1);
        distanceToClosestPerson = Math.max(distanceToClosestPerson, Math.max(zerosAtTheBeginning, zerosAtTheEnd));
        return distanceToClosestPerson;
    }
}