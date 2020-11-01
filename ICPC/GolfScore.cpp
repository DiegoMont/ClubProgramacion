#include<stdio.h>
#include<map>
#include<string>
#include<iostream>

int main(){
  int arreglo[18];
  int suma = 0;
  for (size_t i = 0; i < 18; i++) {
    scanf("%d", arreglo+i);
    suma += arreglo[i];
  }
  std::map<std::string, int> performances;
  performances["par"] = 0;
  performances["bogey"] = 1;
  performances["double bogey"] = 2;
  performances["triple bogey"] = 3;
  performances["condor"] = -4;
  performances["albatross"] = -3;
  performances["eagle"] = -2;
  performances["birdie"] = -1;
  std::string score;
  getline(std::cin, score);
  for (size_t i = 0; i < 18; i++) {
    getline(std::cin, score);
    if (score == "hole in one"){
      suma -= arreglo[i];
      suma++;
    } else {
      suma += performances[score];
    }
  }
  
  printf("%d", suma);
}