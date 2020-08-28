#include<stdio.h>

int main(){
  int t;
  scanf("%i", &t);
  for (int i = 0; i < t; i++){
    int n, x, y;
    scanf("%d %d %d", &n, &x, &y);
    int j = 1;
    int a = x;
    while(a < n){
      if (a % y != 0){
        printf("%d ", a);
      }
      ++j;
      a = x*j;
    }
    printf("\n");
  }
}