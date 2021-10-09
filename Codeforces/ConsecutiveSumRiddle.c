/* CONSECUTIVE SUM RIDDLE
Theofanis has a riddle for you and if you manage to solve it, he will give you a Cypriot snack halloumi for free (Cypriot cheese).
You are given an integer n. You need to find two integers l and r such that -10^18 <= l < r <= 10^18 and l+(l+1)+...+(r-1)+r=n.
INPUT
The first line contains a single integer t(1 <= t <= 10^4) — the number of test cases.
The first and only line of each test case contains a single integer n (1 <= n <= 10^18).
OUPUT
For each test case, print the two integers l and r such that -10^18 <= l < r <=10^18 and l+(l+1)+...+(r-1)+r=n.
SAMPLE INPUT
7
1
2
3
6
100
25
3000000000000
SAMPLE OUTPUT
0 1
-1 2
1 2
1 3
18 22
-2 7
999999999999 1000000000001
*/

#include <stdio.h>
 
int main(){
    int t;
    scanf("%d", &t);
    for(; t > 0; t--){
        long long n, l, r;
        scanf("%lld", &n);
        l = -(n - 1);
        r = n;
        printf("%lld %lld\n", l, r);
    }
}