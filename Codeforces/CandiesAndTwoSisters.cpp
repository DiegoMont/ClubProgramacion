/*Candies and two sisters
There are two sisters Alice and Betty. You have n candies. You want to distribute these n candies between two sisters in such a way that:
  * Alice will get a(a > 0) candies;
  * Betty will get b(b > 0) candies;
  * each sister will get some integer number of candies;
  * Alice will get a greater amount of candies than Betty (a > b);
  * all the candies will be given to one of two sisters (a + b = n).
Your task is to calculate the number of ways to distribute exactly n candies between sisters in a way described above. Candies are indistinguishable.
Formally, find the number of ways to represent n as the sum of n = a + b, where a and b are positive integers and a > b.
You have to answer t independent test cases.
INPUT
The first line of the input contains one integer t(1 <= t <= t^4) - the number of test cases. Then t test cases follo.
The only line of a test case contains one integer n(1 <= n <= 2*10^9) - the number of andies you have.
OUTPUT
For each test case, print the answer - the number of ways to distribute exactly n candies betwwn two sisters in a way described in the problem statement. If there is no way to sitisfy all the conditions, print 0.
SAMPLE INPUT:
6
7
1
2
3
2000000000
763243547
SAMPLE OUTPUT
3
0
0
1
999999999
381621773
*/
#include <stdio.h>
int main(){
  int t;
  scanf("%i", &t);
  for(int i = 0; i < t; i++){
    int n;
    scanf("%i", &n);
    int resultado = (n - 1) / 2;
    printf("%i\n", resultado);
  }
}