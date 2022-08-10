#include <stdio.h>
#include <climits>

struct Time {
    int hour, minute;

    int toMinutes() {
        return hour * 60 + minute;
    }
};

int main() {
    int t;
    scanf("%d\n", &t);
    for(; t > 0; t--) {
        int maxSleepTime = INT_MAX;
        int n, h, m;
        scanf("%d %d %d\n", &n, &h, &m);
        struct Time sleepTime = {h, m};
        for(; n > 0; n--) {
            scanf("%d %d\n", &h, &m);
            struct Time taskTime = {h, m};
            int timeBetween = taskTime.toMinutes() - sleepTime.toMinutes();
            if(timeBetween < 0)
                timeBetween += 24 * 60;
            if(timeBetween < maxSleepTime)
                maxSleepTime = timeBetween;
        }
        printf("%d %d\n", maxSleepTime / 60, maxSleepTime % 60);
    }
}