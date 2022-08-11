#include <stdio.h>
#include <map>

int main() {
    int t;
    scanf("%d\n", &t);
    for(; t > 0; t--) {
        int n;
        scanf("%d\n", &n);
        int numSwaps = 0;
        std::map<int, int> numberLastIndex;
        for(int i = 1; i <= n; i++) {
            int a;
            scanf("%d\n", &a);
            try {
                numSwaps = std::max(numberLastIndex.at(a), numSwaps);
            } catch(const std::exception& e) {}
            numberLastIndex[a] = i;
        }
        printf("%d\n", numSwaps);
    }
}