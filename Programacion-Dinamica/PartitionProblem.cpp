#include<stdio.h>

bool canPartition(int* S, int n){
  int sum = 0;
  int lengthTabla = 100;
  int tabla[lengthTabla];
  for (int i = 0; i < lengthTabla; i++) {
    tabla[i] = 0;
  }
  for (int i = 0; i < n; i++) {
    sum += S[i];
    tabla[S[i]]++;
  }
  int target = sum / 2;
  if (target*2 != sum) {
    return false;
  }
  for (int i = lengthTabla-1; i > -1; i--) {
    while(tabla[i] > 0){
      if (target == 0){
        return true;
      } else if (target - i > -1) {
        tabla[i]--;
        target -= i;
        //printf("%d %d\n", target, i);
      } else {
        break;
      }
    }
  }
  return false;
}

int main(){
  int S[] = {3, 1, 1, 2, 2, 1};
  if(canPartition(S, sizeof(S)/sizeof(S[0]))){
    printf("True");
  } else
    printf("False");
  printf("\n");
}
