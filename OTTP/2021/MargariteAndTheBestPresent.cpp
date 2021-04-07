/*
Little girl Margarita is a big fan of competitive programming. She especially loves problems about arrays and queries on them.
Recently, she was presented with an array a of the size of 10^9 elements that is filled as follows:
  * a1 = −1
  * a2 = 2
  * a3 = −3
  * a4 = 4
  * a5 = −5
  * And so on ...
That is, the value of the i-th element of the array a is calculated using the formula ai = i(−1)^i.
She immediately came up with q queries on this array. Each query is described with two numbers: l and r. The answer to a query is the sum of all the elements of the array at positions from l to r inclusive.
Margarita really wants to know the answer to each of the requests. She doesn't want to count all this manually, but unfortunately, she couldn't write the program that solves the problem either. She has turned to you — the best programmer.
Help her find the answers!
INPUT
The first line contains a single integer q (1<=q<=1000) — the number of the queries.
Each of the next q lines contains two integers l and r (1<=l<=r<=10^9) — the descriptions of the queries.
OUTPUT
Print q lines, each containing one number — the answer to the query.
SAMPLE INPUT
5
1 3
2 5
5 5
4 4
2 3
SAMPLE OUTPUT
-2
-2
-5
4
-1
*/
#include <iostream>

bool isEven(int num);

int main(){
  int q;
  std::cin >> q;
  for(; q > 0; q--){
    int l, r;
    std::cin >> l >> r;
    int resultado;
    if(isEven(l) && isEven(r))
      resultado = r - (r-l)/2;
    else if(!(isEven(l) || isEven(r)))
      resultado = -r + (r-l)/2;
    else if(isEven(l))
      resultado = -(r - l +1)/2;
    else
      resultado = (r-l+1)/2;
    std::cout << resultado << "\n";
  }
}

bool isEven(int num){
  return (num & 1) == 0;
}