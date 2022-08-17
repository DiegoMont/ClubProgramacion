#include <stdio.h>

int main() {
    int t;
    scanf("%d\n", &t);
    for(; t > 0; t--) {
        int n;
        scanf("%d\n", &n);
        int starts[n];
        for(int i = 0; i < n; i++)
            scanf("%d", starts + i);
        int endOfLastTask = 0;
        for(int i = 0; i < n; i++) {
            int endTime;
            scanf("%d", &endTime);
            int d = endTime - (endOfLastTask < starts[i] ? starts[i]: endOfLastTask);
            endOfLastTask = endTime;
            printf("%d ", d);
        }
        puts("");
    }
}