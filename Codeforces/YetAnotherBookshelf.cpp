/*  YET ANOTHER BOOKSHELF
 There is a bookshelf which can fit N books. The i-th position of bookshelf is ai=1 if there is a book on this position and ai=0 otherwise. It is guaranteed that there is at least one book on the bookshelf.
 In one move, you can choose some contiguous segment [l;r] consisting of books (i.e. for each i from l to r the condition the condition ai=1 holds) and:
   * Shift it to the right by 1: move the book at index i to i+1 for all l <= i <= r. This move can be done only if r+1<=n and there is no book at the position r+1.
   * Shift it to the left by 1: move the book at index i to i-1 for all l<=i<=r. This move can be done only if l-1>=1 and there is no book at the position l-1.
 Your task is to find the minimum number of moves required to collect all the books on the shelf as a contiguous (consecutive) segment (i.e. the segment without any gaps).
 For example, for a=[0,0,1,0,1] there is a gap between books (a4=0 when a3=1 and a5=1), for al = [1, 1, 0] there are no gaps between books and for a=[0,0,0] there are also no gaps between books.
 You have to answer t independent test cases.
 INPUT
 The first line of the input contains one integer t(<<= t <= 200) - the number of test cases. Then t test cases follow.
 The first line of the test case contains one integer n(1 <= n <= 50) - the number of places on a bookshelf. The second line of the test case contains n integers a1, a2, ... , an (0 <= ai <= 1), where ai is 1 if there is a book at this position and 0 otherwise. It is guaranteed that there is at least one book on the bookshelf.
 OUTPUT
 For each test case, print one integer: the minimum number of moves required to collect all the books on the shelf as a contiguous (consecutive) segment (i.e. the segment without gaps).
 SAMPLE INPUT
 5
 7
 0 0 1 0 1 0 1
 3
 1 0 0
 5
 1 1 0 0 1
 6
 1 0 0 0 0 1
 5
 1 1 0 1 1
 SAMPLE OUTPUT
 2
 0
 2
 4
 1
*/
#include<stdio.h>

int main(){
  int t;
  scanf("%d", &t);
  for (int h = 0; h < t; h++) {
    int n;
    scanf("%d", &n);
    //Encontrar el primer uno
    int i = 0;
    bool foundUno = false;
    while(!foundUno){
      int a;
      scanf("%d", &a);
      foundUno = a == 1;
      i++;
    }
    int resultado = 0;
    //Contar numero de ceros entre unos
    int numCeros = 0;
    while(i < n){
      int a;
      scanf("%d", &a);
      if(a == 0)
        numCeros++;
      else {
        resultado += numCeros;
        numCeros = 0;
      }
      i++;
    }
    printf("%d\n", resultado);
  }
}
