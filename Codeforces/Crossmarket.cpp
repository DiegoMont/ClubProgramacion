/*Crossmarket
Stanley and Megan decided to shop in the "Crossmarket" grocery store, which can be represented as a matrix withn rows and m columns.
Stanley and Megan can move to an adjacent cell using 1 unit of power. Two cells are considered adjacent if they share an edge. To speed up the shopping process, Megan brought her portals with her, and she leaves one in each cell she visits (if there is no portal yet). If a person (Stanley or Megan) is in a cell with a portal, that person can use 1 unit of power to teleport to any other cell with a portal, including Megan's starting cell.
They decided to split up: Stanley will go from the upper-left cell (cell with coordinates (1, 1)) to the lower-right cell (cell with coordinates (n, m) whilst Megan needs to get from the lower-left cell (cell with coordinates (n, 1) to the upper-right cell (cell with coordinates (1, m).
What is the minimum total energy needed for them both to do that?
Note that they can choose the time they move. Time does not affect energy.

INPUT
Each test contains multiple test cases. The first line contains the number of test cases t(1 <= t <= 1000). Description of the test cases follows.
The only line in the test case contains two integers n and m (1 <= n, m <= 100000).
OUTPUT
For each test case print a single integer on a new line – the answer.
SAMPLE INPUT
8
7 5
5 7
1 1
100000 100000
57 228
1 5
5 1
2 1
SAMPLE OUTPUT
15
15
0
299998
340
5
5
2
*/

#include <algorithm>
#include <stdio.h>

int main() {
    int t;
    scanf("%d\n", &t);
    for(; t > 0; t--) {
        int n, m;
        scanf("%d %d\n", &n, &m);
        int result = n + m - 2 + std::min(n, m);
        if(n == 1 && m == 1)
            result = 0;
        printf("%d\n", result);
    }
}