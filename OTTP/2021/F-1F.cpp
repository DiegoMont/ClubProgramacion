#include <iostream>

int main(){
  int t;
  std::cin >> t;
  for (; 0 < t; t--){
    long long n;
    std::cin >> n;
    while((n & 1) == 0)
      n /= 2;
    std::cout << (n > 1 ? "YES": "NO") << "\n";
  }
  
}