#include<stdio.h>
#include<algorithm>

int main(){
  int n;
  scanf("%d", &n);
  int fila[n];
  int mayoresIzq[n];
  int mayoresDer[n];
  int unaPuerta = 0, dosPuertas = 0;
  for (int i = 0; i < n; i++) {
    mayoresIzq[i] = 0;
    mayoresDer[i] = 0;
    scanf("%d", fila+i);
    for (int j = 0; j < i; j++) {
      if (fila[j] > fila[i]) {
        mayoresIzq[i]++;
      }
    }
    unaPuerta += mayoresIzq[i];
  }
  for (int i = n-1; i > -1; i--) {
    for (int j = n-1; j > i; j--) {
      if (fila[j] > fila[i]) {
        mayoresDer[i]++;
      }
    }
    dosPuertas += std::min(mayoresIzq[i], mayoresDer[i]);
  }
  printf("%d %d\n", unaPuerta, dosPuertas);
}
