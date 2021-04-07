/*
It is raining heavily. But this is the first day for Serval, who just became 3 years old, to go to the kindergarten. Unfortunately, he lives far from kindergarten, and his father is too busy to drive him there. The only choice for this poor little boy is to wait for a bus on this rainy day. Under such circumstances, the poor boy will use the first bus he sees no matter where it goes. If several buses come at the same time, he will choose one randomly.
Serval will go to the bus station at time t, and there are n bus routes which stop at this station. For the i-th bus route, the first bus arrives at time si minutes, and each bus of this route comes di minutes later than the previous one.
As Serval's best friend, you wonder which bus route will he get on. If several buses arrive at the same time, you can print any of them.
INPUT
The first line contains two space-separated integers n and t (1<=n<=100, 1<=t<=100000) — the number of bus routes and the time Serval goes to the station.
Each of the next n lines contains two space-separated integers si and di (1<=si,di<=100000) — the time when the first bus of this route arrives and the interval between two buses of this route.
OUTPUT
Print one number — what bus route Serval will use. If there are several possible answers, you can print any of them.
SAMPLE INPUT
5 5
3 3
2 5
5 6
4 9
6 1
SAMPLE OUTPUT
3
*/
#include <iostream>
#include <climits>

int main(){
  int n, t;
  std::cin >> n >> t;
  int diferenciaMinima = INT_MAX;
  int ruta;
  for(int i = 0; i < n; i++){
    int si, ti;
    std::cin >> si >> ti;
    int tiempoEspera;
    if(t <= si)
      tiempoEspera = si - t;
    else {
      int tiempoSiguienteBus;
      tiempoSiguienteBus = (t - si)/ti;
      tiempoSiguienteBus += ((t-si)%ti > 0 ? 1: 0);
      tiempoSiguienteBus *= ti;
      tiempoSiguienteBus += si;
      tiempoEspera = tiempoSiguienteBus - t;
    }
    if(tiempoEspera < diferenciaMinima){
      diferenciaMinima = tiempoEspera;
      ruta = i+1;
    }
  }
  std::cout << ruta << "\n";
}