/*  DOMINANT PIRANHA
 There are n piranhas with sizes a1, a2, ... , an in the aquarium. Piranhas are numbered from left to right in order they live in the aquarium.
 Scientists of the Berland State University want to find if there is dominant piranha in the aquarium. The piranha is called dominant if it can eat all the other piranhas in the aquarium (except itself, of course). Other piranhas will do nothing while the dominant piranha will eat them.
 Because the aquarium is pretty narrow and long, the piranha can eat only one of the adjacent piranhas during one move. Piranha can do as many moves as it needs (or as it can). More precisely:
   * The piranha i can eat the piranha i-1 if the piranha i-1 exists and ai-1 < ai.
   * The piranha i can eat the piranha i+1 if the piranha i+1 exists and ai+1 < ai.
 When the piranha i eats some piranha, its size increases by one (ai becomes ai+1).
 Your task is to find any dominant piranha in the aquarium or determine if there are no such piranhas.
 Note that you have to find any (exactly one) dominant piranha, you don't have to find all of them.
 For example, if a=[5,3,4*,4,5], then the third piranha can be dominant. Consider the sequence of its moves:
   * The piranha eats the second piranha and a becomes [5, 5*, 4, 5].
   * The piranha eats the third piranha and a becomes [5, 6*, 5].
   * The piranha eats the first piranha and a becomes [7*, 5].
   * The piranha eats the second piranha and a becomes [8].
 You have to answer t independent test cases.
 INPUT
 The first line of the input contains one integer t(1 <= t <= 2*10^4) - the number of test cases. Then t test cases follow.
 The first line of the test case contains one integer n(2 <= n <= 3*10^5) - the number of piranhas in the aquarium. The second line of the test case contains n integers a1, a21, ..., an (1 <= ai <= 10^9), where ai is the size of the i-th piranha.
 It is guaranteed that the sum of n does not exceed 3*10^5.
 OUTPUT
 For each test case, print the answer: -1 if there are no dominant piranhas in the aquarium or index of any dominant piranha otherwise. If there are several answers, you can print any.
 SAMPLE INPUT
 6
 5
 5 3 4 4 5
 3
 1 1 1
 5
 4 4 3 4 4
 5
 5 5 4 3 2
 3
 1 1 2
 5
 5 4 3 5 5
 SAMPLE OUTPUT
 3
 -1
 4
 3
 3
 1
 */
#include <stdio.h>
#include <algorithm>
int main(){
  int t;
  scanf("%d", &t);
  for (int h = 0; h < t; h++) {
    int n;
    scanf("%d", &n);
    int piranhas[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      int pesoPiranha;
      scanf("%d", &pesoPiranha);
      max = std::max(max, pesoPiranha);
      piranhas[i] = pesoPiranha;
    }
    int indice = n;
    for (int i = 0; i < n; i++) {
      if (piranhas[i] == max) {
        bool hayALaIzquierda = i-1 < 0 || piranhas[i-1] == max;
        bool hayALaDerecha = i+1 == n || piranhas[i+1] == max;
        if (!(hayALaIzquierda && hayALaDerecha)) {
          indice = i;
          break;
        }
      }
    }
    if (indice == n) {
      printf("-1\n");
    } else {
      indice++;
      printf("%d\n", indice);
    }
  }
}
