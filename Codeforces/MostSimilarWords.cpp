#include <stdio.h>
#include <algorithm>
#include <limits>

int getDifference(char* word1, char* word2, size_t m);

int main() {
    char words[50][9];
    size_t t;
    scanf("%d\n", &t);
    for(; t> 0; t--) {
        size_t n, m;
        scanf("%d %d\n", &n, &m);
        for(size_t i = 0; i < n; i++)
            scanf("%s\n", words[i]);
        int minDifference = std::numeric_limits<int>::max();
        for(size_t i = 0; i < n; i++){
            for(size_t j = 0; j < n; j++) {
                if(i != j) {
                    int difference = getDifference(words[i], words[j], m);
                    minDifference = std::min(minDifference, difference);
                }
            }
        }
        printf("%d\n", minDifference);
    }
}

int getDifference(char* word1, char* word2, size_t m) {
    int difference = 0;
    for(size_t i = 0; i < m; i++) {
        int localDiff = word1[i] - word2[i];
        if(localDiff < 0)
            difference -= localDiff;
        else
            difference += localDiff;
    }
    return difference;
}