#include <stdio.h>
#include <vector>
#include <unordered_map>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        std::vector<int> results;
        std::unordered_map<int, int> checkedElements;
        int i = 0;
        for(int num: nums) {
            int complement = target - num;
            if(checkedElements.count(complement) > 0) {
                results.push_back(checkedElements[complement]);
                results.push_back(i);
                break;
            }
            checkedElements[num] = i;
            i++;
        }
        return results;
    }
};

int main() {
    std::vector<int> nums{2,11,15, 7};
    Solution s;
    std::vector<int> sumIndices = s.twoSum(nums, 9);
    printf("%d, %d\n", sumIndices.at(0), sumIndices.at(1));
}
