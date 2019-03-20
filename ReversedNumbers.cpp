#include<iostream>

int main() {
  int casos;
  for (std::cin >> casos; casos > 0; casos--) {
    int num1, num2;
    std::cin>>num1;
    std::cin>>num2;
    int num1Rev =0;
    int num2Rev =0;
    while (num1 != 0 || num2 != 0) {
      num1Rev = (num1==0? num1Rev:num1Rev*10) + num1%10;
      num2Rev = (num2==0? num2Rev:num2Rev*10) + num2%10;
      num1 /= 10;
      num2 /= 10;
    }
    int resultado = num1Rev + num2Rev;
    int resRev = 0;
    while (resultado != 0) {
      resRev = resRev*10 + resultado%10;
      resultado /=10;
    }
    std::cout << resRev<<endl;
  }
  return 0;
}
