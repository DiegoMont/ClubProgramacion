#include <iostream>
#include <algorithm>
#include <map>

bool maximoNumeroPiezas(int w, int h, int n, std::map<std::string, int>& tabla);
int mnpRecursivo(int w, int h, std::map<std::string, int>& tabla);

int main(){
  std::map<std::string, int> tabla;
  int t, w, h, n;
  std::cin >> t;
  for (int caso = 0; caso < t; caso++){
    std::cin >> w >> h >> n;
    std::cout << (maximoNumeroPiezas(w, h, n, tabla) ? "YES": "NO") << "\n";
  }
}

bool maximoNumeroPiezas(int w, int h, int n, std::map<std::string, int>& tabla){
  return mnpRecursivo(w, h, tabla) >= n;
}

int mnpRecursivo(int w, int h, std::map<std::string, int>& tabla){
  int mayor = std::max(w, h), menor = std::min(w, h);
  std::string key = std::to_string(mayor) + "," + std::to_string(menor);
  auto elemento = tabla.find(key);
  if(elemento != tabla.end()){
    return elemento->second;
  }
  int resultado = 1;
  if((mayor & 1) == 0)
    resultado = 2*mnpRecursivo(mayor/2, menor, tabla);
  if((menor & 1) == 0)
    resultado = std::max(resultado, 2*mnpRecursivo(mayor, menor/2, tabla));
  tabla.insert({key, resultado});
  return resultado;
}