#include <vector>
#include <algorithm>

using namespace std;

class Solution {
    int n;
public:
    int maxArea(vector<int>& heights) {
        this->n = heights.size();
        int left = 0;
        int right = n-1;
        int maxArea = 0;
        while(left < right) {
            int area = getArea(heights, left, right);
            maxArea = max(maxArea, area);
            if(heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

private:
    int getArea(vector<int>& heights, int left, int right) {
        int base = right - left;
        int height = min(heights[left], heights[right]);
        return base * height;
    }
};