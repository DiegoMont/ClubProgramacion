import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 1, -1, 1, 1, 1};
        System.out.println(s.subarraySum(nums, 1));
    }
}

class Solution {

    HashMap<String, Integer> tabla;
    int subarraySums;

    public int subarraySum(int[] nums, int k) {
        tabla = new HashMap<>();
        subarraySums = 0;
        for(int i = nums.length-1; i > -1; i--){
            sum(nums, 0, i, k);
        }
        System.out.println(llamadas);
        return subarraySums;
    }

    int llamadas = 0;

    private int sum(int[] nums, int i, int j, final int k){
        llamadas++;
        String key = i + " " + j;
        Integer sum = tabla.get(key);
        if(sum != null)
            return sum;
        if(i == j)
            sum = nums[i];
        else
            sum = nums[i] + sum(nums, i+1, j, k);
        if(sum == k)
            subarraySums++;
        tabla.put(key, sum);
        System.out.println(key);
        return sum;
    }
}
