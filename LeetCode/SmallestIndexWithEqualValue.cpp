class Solution {
public:
    int smallestEqual(vector<int>& nums) {
        int i = 0;
        for(int num: nums) {
            if(i % 10 == num)
                return i;
            i++;
        }
        return -1;
    }
};