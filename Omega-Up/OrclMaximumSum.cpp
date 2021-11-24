#include <stdio.h>
#include <algorithm>

int getNextNum();

int main(int argc, char const *argv[]) {
    int n = getNextNum();
    int maxSum = getNextNum();
    int accumulatedSum = maxSum;
    for(int i = 1; i < n; i++){
        int currentNum = getNextNum();
        accumulatedSum = std::max(currentNum, currentNum + accumulatedSum);
        maxSum = std::max(maxSum, accumulatedSum);
    }
    printf("%d\n", maxSum);
}

int getNextNum(){
    int num;
    scanf("%d", &num);
    return num;
}
