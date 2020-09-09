/* BOATS COMPETITION
 There are n people who want to participate in a boat competition. The weight of the i-th participant is wi. Only teams consisting of two people can participate in this competition. As an organizer, you think that it's fair to allow only teams with the same total weight.
 So, if there are k teams (a1, b1), (a2, b2), ..., (ak, bk), where ai is the weight of the first participant of the i-th team and bi is the weight of the second participant of the i-th team, then the condition a1+b1 = a2+b2 = ... = ak+bk = s, where s is the total weight of each team, should be satisfied.
 Your task is to choose such s that the number of teams people can create is the maximum possible. Note that each participant can be in no more than one team.
 You have to answer t independent test cases.
 INPUT
 The first line of the input contains one integer t (1 <= t <= 100) - the number of test cases. Then t test cases follow.
 The first line of the test case contains one integer n (1 <= n <= 50) - the number of participants. The second line of the test case contains n integers w1, w2, ..., wn (1 <= wi <= n), where wi is the weight of the i-th participant.
 OUTPUT
 For each test case, print one integer k: the maximum number of teams people can compose with the total weight s, if you choose s optimally.
 SAMPLE INPUT
 5
 5
 1 2 3 4 5
 8
 6 6 6 6 6 6 8 8
 8
 1 2 2 1 2 1 1 2
 3
 1 3 3
 6
 1 1 3 4 2 2
 SAMPLE OUTPUT
 2
 3
 4
 1
 2
 */

#include<stdio.h>
#include<algorithm>

int search(int pesos[], int izq, int der, int count, int target);

int main(){
  int t;
  scanf("%d", &t);
  for (int caso = 0; caso < t; caso++) {
    int n;
    scanf("%d", &n);
    int personas[n];
    for (int i = 0; i < n; i++) {
      scanf("%d", personas+i);
    }
    if (n < 2) {
      printf("0\n");
      continue;
    }
    std::sort(personas, personas+n);
    //Crear tablita
    int pesoMax = personas[n-1] + personas[n-2] + 1;
    int pesoMin = personas[0] + personas[1];
    int maxNumber = 0;
    for (int i = pesoMin; i < pesoMax; i++) {
      maxNumber = std::max(maxNumber, search(personas, 0, n-1, 0, i));
    }
    printf("%d\n", maxNumber);
  }
}

int search(int pesos[], int izq, int der, int count, int target){
  if (izq >= der) {
    return count;
  } else if (pesos[izq] + pesos[der] > target){
    return search(pesos, izq, der-1, count, target);
  } else if (pesos[izq] + pesos[der] < target) {
    return search(pesos, izq+1, der, count, target);
  } else {
    return search(pesos, izq+1, der-1, count+1, target);
  }
}
