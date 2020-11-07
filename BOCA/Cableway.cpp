#include<stdio.h>
#include<iostream>
#include<string>
#include<cmath>

int main(){
  int c, a;
  scanf("%d %d", &c, &a);
  std::string aux;
  getline(std::cin, aux);
  int resultado = a / (c-1);
  if(a > resultado * (c-1))
    ++resultado;
  printf("%d", resultado);
}