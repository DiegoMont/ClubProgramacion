#include<iostream>

int reverse( int numero);

int main(){
  int casos;
  std::cin >> casos;
  for (int i = 0; i < casos; i++) {
    int numero1, numero2;
    std::cin >> numero1;
    std::cin >> numero2;
    int resultado = reverse(numero1) + reverse(numero2);
    std::cout << reverse(resultado) << "\n";
  }
}

int reverse(int numero){
  int resultado = 0;
  while(numero > 0){
    resultado *= 10;
    resultado += numero % 10;
    numero /= 10;
  }
  return resultado;
}
