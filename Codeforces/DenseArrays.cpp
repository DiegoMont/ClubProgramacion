#include<iostream>
#include<algorithm>

bool cumpleFuncion(double max, double min){
  return max/min <= 2;
}

int main(){
  int t;
  std::cin >> t;
  for (int caso = 0; caso < t; caso++) {
    int n;
    std::cin >> n;
    int num1, num2, resultado = 0;
    std::cin >> num1;
    for (int i = 1; i < n; i++) {
      std::cin >> num2;
      int maxAux = num1, minAux = num1;
      if(num1 > num2)
        minAux = num2;
      else
        maxAux = num2;
      while(!cumpleFuncion(maxAux, minAux)){
        ++resultado;
        minAux *= 2;
      }
      num1 = num2;
    }
    std::cout << resultado << "\n";
  }
}
