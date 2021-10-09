/* SPECIAL NUMBERS
Theofanis really likes sequences of positive integers, thus his teacher (Yeltsa Kcir) gave him a problem about a sequence that consists of only special numbers.
Let's call a positive number special if it can be written as a sum of different non-negative powers of n. For example, for n=4 number 17 is special, because it can be written as 4^0+4^2=1+16=17, but 9 is not.
Theofanis asks you to help him find the k-th special number if they are sorted in increasing order. Since this number may be too large, output it modulo 1000000000+7.
INPUT
The first line contains a single integer t(1 <= t <= 10^4) - the number of test cases.
The first and only line of each test case contains two integers n and k (2 <= n <= 10^9; 1 <= k <= 10^9)
OUTPUT
For each test case, print one integer - the k-th special number in increasing order modulo 1000000000+7.
SAMPLE INPUT
3
3 4
2 12
105 564
SAMPLE OUTPUT
9
12
3595374
*/
#include <stdio.h>
 
int main(){
    int t;
    scanf("%d", &t);
    for(; t > 0; t--){
        int n, k;
        scanf("%d %d", &n, &k);
        long long resultado = 0;
        long long exponente = 1;
        while(k > 0){
            int aux = k & 1;
            resultado += aux * exponente;
            exponente *= n;
            exponente %= (1000000000 + 7);
            resultado %= (1000000000 + 7);
            k = k >> 1;
        }
        printf("%lld\n", resultado);
    }
}
