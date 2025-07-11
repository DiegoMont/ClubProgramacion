#include <vector>

class Solution {
public:
    int minimumRightShifts(std::vector<int>& nums) {
        int numsLength = nums.size();
        int indexOfBiggestNumber = findIndexOfBiggestElement(nums);
        if (!(isSorted(nums, 0, indexOfBiggestNumber) && isSorted(nums, indexOfBiggestNumber+1, numsLength)))
            return -1;
        int shifts = numsLength - indexOfBiggestNumber - 1;
        if (shifts > 0 && nums[numsLength - 1] > nums[0])
            return -1;
        return shifts;
    }

private:
    int findIndexOfBiggestElement(std::vector<int>& nums) {
        int indexOfMax = 0;
        int maxValue = nums[indexOfMax];
        for (size_t i = 0; i < nums.size(); i++)
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                indexOfMax = i;
            }
        return indexOfMax;
    }

    bool isSorted(std::vector<int>& nums, int start, int end) {
        int aux = nums[start];
        for (size_t i = start; i < end; i++) {
            if (nums[i] < aux)
                return false;
            aux = nums[i];
        }
        return true;
    }
};
