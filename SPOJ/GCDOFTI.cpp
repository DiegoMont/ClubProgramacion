#include <stdio.h>
#include <algorithm>

int getGCD(int a, int b);

int main (){
  int numeros[3];
  scanf("%i %i %i", numeros, numeros+1, numeros+2);
  std::sort(numeros, numeros+3);
  int GCD = getGCD(numeros[2], numeros[1]);
  int GCD2 = getGCD(std::max(numeros[0], GCD), std::min(numeros[0], GCD));
  printf("%i\n", GCD2);
}

int getGCD(int a, int b){
  if (a == 0){
    return b;
  } else if (b == 0){
    return a;
  } else {
    int residuo = a%b;
    return getGCD(b, residuo);
  }
}