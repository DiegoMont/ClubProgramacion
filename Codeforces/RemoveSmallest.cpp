/*REMOVE SMALLEST
You are given the array a consisting of n positive integers (greater than zero).
In one move, you can choose two indices i and j (i != j) such that the absolute differene between ai and aj is no more than one (|ai - aj| <= 1) and remove the smallest of these two elements. If two elements are equal, you can remove any of them (but exactly one).
Your task is to find if it is possible to obtain the array consisting of only one element using several (possibly zero) such moves or not.
You have to answer t independent test cases.
INPUT
The first line of the input contains one integer t (1 <= t <= 1000) - the number of test cases. Then t test cases follow.
The first line of the test case contains one integer n (1 <= n <= 50) - the length of a. The second line of the test case contains n integers a1, a2, ..., an (1 <= ai <= 100), where ai is the i-th element of a.
OUTPUT
For each test case, print the answer "YES" if it is possible to obtain the array consisting of only one element using several (possibly, zero) moves described in the problem statement, or "NO" otherwise.
SAMPLE INPUT
5
3
1 2 2
4
5 5 5 5
3
1 2 4
4
1 3 4 4
1
100
SAMPLE OUTPUT
YES
YES
NO
NO
YES
*/

#include <stdio.h>
#include <vector>

int main(){
  int t;
  scanf("%i", &t);
  for (int g = 0; g < t; g++) {
    int n;
    scanf("%i", &n);
    int numeros[101];
    for (int i = 0; i < 101; i++) {
      numeros[i] = 0;
    }
    
    for (int i = 0; i < n; i++) {
      int a;
      scanf("%i", &a);
      numeros[a] = numeros[a] + 1;
    }
    std::vector<int> lista;
    for (int i = 0; i < 101; i++) {
      if (numeros[i] > 0) {
        lista.push_back(i);
      }
    }
    int vectorLength = lista.size()-1;
    bool salio = true;
    for (int i = 0; i < vectorLength; i++) {
      int diferencia = lista.at(i+1) - lista.at(i);
      if(diferencia > 1) {
        salio = false;
        break;
      }
    }
    if(salio)
      printf("YES\n");
    else
      printf("NO\n");
  }
  
}