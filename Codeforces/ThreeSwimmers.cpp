/*
Three swimmers decided to organize a party in the swimming pool! At noon, they started to swim from the left side of the pool.
It takes the first swimmer exactly a minutes to swim across the entire pool and come back, exactly b minutes for the second swimmer and c minutes for the third. Hence, the first swimmer will be on the left side of the pool after 0, a, 2a, 3a, ... minutes after the start time, the second one will be at 0, b, 2b, 3b, ... minutes, and the third one will be on the left side of the pool after 0, c, 2c, 3c, ... minutes.
You came to the left side of the pool exactly p minutes after they started swimming. Determine how long you have to wait before one of the swimmers arrives at the left side of the pool.
INPUT
The first line of the input contains a single integer t(1 <= t <= 1000)the number of test cases. Next t lines contains test case descriptions, one per line.
Each line contains four integers p, a, b and c(1 <= p, a, b, c <= 10^18) time in minutes after the start, when you came to the pool and times in minutes it take the swimmers to cross the entire pool and come back.
OUTPUT
For each test case, output one integer — how long you have to wait (in minutes) before one of the swimmers arrives at the left side of the pool.
SAMPLE INPUT
4
9 5 4 8
2 6 10 9
10 2 5 10
10 9 9 9
SAMPLE OUTPUT
1
4
0
8
*/

#include<iostream>
#include<algorithm>
#include<cmath>
#include<climits>

int main(){
  int t;
  std::cin >> t;
  for(; t > 0; t--){
    long long p;
    long long nadadores[3];
    std::cin >> p >> nadadores[0] >> nadadores[1] >> nadadores[2];
    long long arreglo[] = {p/nadadores[0], p/nadadores[1], p/nadadores[2]};
    long long min = LLONG_MAX;
    for (int i = 0; i < 3; i++){
      if(p%nadadores[i])
        arreglo[i]++;
      if(arreglo[i]*nadadores[i] < min)
        min = arreglo[i]*nadadores[i];
    }
    long long resultado = min - p;
    std::cout << resultado << "\n";
  }
}