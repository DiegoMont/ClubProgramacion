/*  MARATHON
You are given four distinct integers a, b, c, d.
Timur and three other people are running a marathon. The value a is the distance that Timur has run and b, c, d correspond to the distances the other three participants ran.
Output the number of participants in front of Timur.

INPUT
The first line contains a single integer t (1 <= t <= 10^4) — the number of test cases.
The description of each test case consists of four distinct integers a, b, c, d (0 <= a, b, c, d <= 10^4).

OUTPUT
For each test case, output a single integer — the number of participants in front of Timur.

SAMPLE INPUT
4
2 3 4 1
10000 0 1 2
500 600 400 300
0 9999 10000 9998

SAMPLE OUTPUT
2
0
1
3
*/

#include <stdio.h>

int main() {
    int t;
    scanf("%d\n", &t);
    for(; t > 0; t--) {
        int timurDistance;
        int otherRunnersDistance[3];
        scanf("%d %d %d %d\n", &timurDistance, otherRunnersDistance, otherRunnersDistance+1, otherRunnersDistance+2);
        int participantsInFrontOfTimur = 0;
        for(int distance: otherRunnersDistance)
            if(distance > timurDistance)
                participantsInFrontOfTimur++;
        printf("%d\n", participantsInFrontOfTimur);
    }
}