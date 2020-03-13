#include <iostream>
#include <vector>

int binarySearch(std::vector<int>& arreglo, int elemento);
int binarySearchRecursivo(std::vector<int>& arreglo, int izq, int der, int elemento);


int main(){
  std::vector<int> lista = {1, 2, 3, 5, 7};
  std::cout << binarySearch(lista, 5);
  std::cout << binarySearch(lista, 2);
  std::cout << binarySearch(lista, 8);
  return 0;
}

int binarySearch(std::vector<int>& arreglo, int elemento){
  return binarySearchRecursivo(arreglo, 0, arreglo.size()-1, elemento);
}

int binarySearchRecursivo(std::vector<int>& arreglo, int izq, int der, int elemento){
  if (der < izq)
    return -1;
  else {
    int m = (der + izq) / 2;
    if(arreglo[m] == elemento)
      return m;
    else if(arreglo[m] > elemento)
      return binarySearchRecursivo(arreglo, izq, m-1, elemento);
    else
      return binarySearchRecursivo(arreglo, m+1, der, elemento);
    }
}
