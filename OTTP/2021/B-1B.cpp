#include <iostream>
#include <cmath>

void convertirADos(int n, int* a){
  int cuantosCabenEnMedio = n - 2;
  for (int i = 0; i < 4; i++){
    a[i] -= cuantosCabenEnMedio;
    if(a[i] < 0)
      a[i] = 0;
  }
}

int main(){
  int t;
  std::cin >> t;
  for(; 0 < t; t--){
    int n, a[4];
    std::cin >> n >> a[0] >> a[1] >> a[2] >> a[3];
    convertirADos(n, a);
    bool resultado = a[0] == a[1] && a[1] == a[2] && a[2] == a[3];
    if(std::abs(a[0] - a[2]) == 1 && std::abs(a[3] - a[1]) == 1 && ((a[0] == a[1] && std::abs(a[0] - a[3]) == 1) || (a[0] == a[3] && std::abs(a[0] - a[1]) == 1)))
      resultado = true;
    std::cout << (resultado ? "YES": "NO") << "\n";
  }
}