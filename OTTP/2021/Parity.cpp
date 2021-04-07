/*
You are given an integer n (n>=0) represented with k digits in base (radix) b. So,
    n = a1 * b^(k−1) + a2 * b^(k−2) + … a(k−1) * b + ak.
For example, if b=17,k=3 and a=[11,15,7] then n = 11 * 17^2 + 15 * 17 + 7 = 3179 + 255 + 7 = 3441.
Determine whether n is even or odd.
INPUT
The first line contains two integers b and k (2<=b<=100, 1<=k<=100000) — the base of the number and the number of digits.
The second line contains k integers a1,a2,...,ak (0<=ai<b) — the digits of n.
The representation of n contains no unnecessary leading zero. That is, a1 can be equal to 0 only if k=1.
OUTPUT
Print "even" if n is even, otherwise print "odd".
SAMPLE INPUT
99 5
32 92 85 74 4
SAMPLE OUTPUT
odd
*/
#include <iostream>

bool isEven(int num);

int main(){
  int b, k;
  std::cin >> b >> k;
  bool isBaseEven = isEven(b);
  int counter = 0;
  int a;
  for (int i = 1; i < k; i++){
    std::cin >> a;
    bool numeroYBase = isBaseEven || isEven(a);
    counter += numeroYBase ? 0: 1;
  }
  std::cin >> a;
  counter += isEven(a) ? 0: 1;
  bool resultado = isEven(counter);
  std::cout << (resultado ? "even": "odd") << "\n";
}

bool isEven(int num){
  return (num & 1) == 0;
}