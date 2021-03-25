#include <iostream>

int main(){
  int n;
  std::cin >> n;
  int i = 0;
  for (; i < n/2; i++){
    int rango = n/2;
    for (int j = 0; j < n; j++){
      if(j < rango-i || rango+i < j)
        std::cout << "*";
      else
        std::cout << "D";
    }
    std::cout << "\n";
  }
  for (; i > -1; i--){
    int rango = n/2;
    for (int j = 0; j < n; j++){
      if(j < rango-i || rango+i < j)
        std::cout << "*";
      else
        std::cout << "D";
    }
    std::cout << "\n";
  }
}