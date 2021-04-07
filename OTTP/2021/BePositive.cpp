/*
You are given an array of n integers: a1, a2,..., an. Your task is to find some non-sero integer d (-1000 <= d <= 1000) such that, after each number in the array is divided by d, the number of positive nubmers that are presented in the array is greater than or equal to half of the array size (at least ceil(n/2)). Note that those positive numbers do not need to be an integer (2.5 counts as a positive number). If there are multiple values of d that satisfy the condition, you may print any of them. In case that there is no such d, print a single integer 0.
Recall that ceil(x) represents the smallest integer that is not less than x and that zero (0) is neither positive or negative.
INPUT
The first line contains one integer n(1<=n<=100) - the number of elements in the array.
The second line contains n space-separated integers a1, a2,..., an (-1000 <= ai <= 1000).
OUTPUT
Print one integer d(-1000 <= d <= 1000 and d != 0) that satisfies the given condition. If there are multiple values of d that satisfy the condition, you may print any of them. In case that there is no such d, print a single integer 0.
SAMPLE INPUT
7
0 0 1 -1 0 0 2
SAMPLE OUTPUT
0
*/
#include <iostream>

int main(){
  int n;
  std::cin >> n;
  int numerosPositivos = 0, numerosNegativos = 0;
  for(int i = 0; i < n; i++){
    int a;
    std::cin >> a;
    if(a > 0)
      numerosPositivos++;
    if(a < 0)
      numerosNegativos++;
  }
  int resultado;
  int minNumeros = n/2 + n%2;
  if(numerosPositivos > numerosNegativos)
    resultado = 1;
  else 
    resultado = -1;
  if(numerosPositivos < minNumeros && numerosNegativos < minNumeros)
    resultado = 0;
  std::cout << resultado <<"\n";
}