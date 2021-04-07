/*
Mishka started participating in a programming contest. There are n problems in the contest. Mishka's problem-solving skill is equal to k.
Mishka arranges all problems from the contest into a list. Because of his weird principles, Mishka only solves problems from one of the ends of the list. Every time, he chooses which end (left or right) he will solve the next problem from. Thus, each problem Mishka solves is either the leftmost or the rightmost problem in the list.
Mishka cannot solve a problem with difficulty greater than k. When Mishka solves the problem, it disappears from the list, so the length of the list decreases by 1. Mishka stops when he is unable to solve any problem from any end of the list.
How many problems can Mishka solve?
INPUT
The first line of input contains two integers n and k (1<=n,k<=100) — the number of problems in the contest and Mishka's problem-solving skill.
The second line of input contains n integers a1,a2,...,an (1<=ai<=100), where ai is the difficulty of the i-th problem. The problems are given in order from the leftmost to the rightmost in the list.
OUTPUT
Print one integer — the maximum number of problems Mishka can solve.
SAMPLE INPUT
8 4
4 2 3 1 5 1 6 4
SAMPLE OUTPUT
5
*/
#include <iostream>

int main(){
  int n, k;
  std::cin >> n >> k;
  int a[n];
  for (int i = 0; i < n; i++)
    std::cin >> a[i];
  int resultado = 0;
  int tope = 0;
  for (; tope < n && a[tope] <= k; tope++)
    ++resultado;
  
  for(int i = n-1; i > tope && a[i] <= k; i--)
    ++resultado;
  std::cout << resultado << "\n";
}