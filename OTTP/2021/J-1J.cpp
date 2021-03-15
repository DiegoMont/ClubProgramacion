#include <iostream>

int main(){
  int t;
  std::cin >> t;
  for (int caso = 0; caso < t; caso++){
    int n, a[2] = {}, totalDulces = 0;
    std::cin >> n;
    for (int i = 0; i < n; i++){
      int pesoDulce;
      std::cin >> pesoDulce;
      totalDulces += pesoDulce;
      a[pesoDulce-1]++;
    }
    if((totalDulces & 1) == 1){
      std::cout << "NO\n";
      continue;
    }
    if((a[1]%2)*2 > a[0])
      std::cout << "NO\n";
    else
      std::cout << "YES\n";
  }
  
}