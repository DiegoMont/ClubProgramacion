class Solution {
public:
    int smallestEqual(vector<int>& nums) {
        int i = 0;
        for(int num: nums) {
            if(i == num)
                return i;
            i++;
            if(i == 10)
                i = 0;
        }
        return -1;
    }
};