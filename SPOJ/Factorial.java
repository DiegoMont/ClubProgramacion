/*
For any positive integer N, Z(N) is the number of zeros at the end of the decimal form of number N!. If we have two numbers N1<N2, then Z(N1) <= Z(N2). It is because we can never "lose" any trailing zero by multiplying by any positive number. We can only get new and new zeros. The function Z is very interesting, so we need a computer program that can determine its value efficiently.

Input
There is a single positive integer T on the first line of input (equal to about 100000). It stands for the number of numbers to follow. Then there are T lines, each containing exactly one positive integer number N, 1 <= N <= 1000000000.

Output
For every number N, output a single line containing the single non-negative integer Z(N).
Sample Input
6
3
60
100
1024
23456
8735373

Sample Output
0
14
24
253
5861
2183837
*/
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int casos = Integer.parseInt(sc.nextLine());
    while(casos > 0){
      int i = Integer.parseInt(sc.nextLine());
      int resultado = 0;
      for (int factor = (int) (Math.log(i) / Math.log(5)); factor > 0; factor--) {
        resultado += i / Math.pow(5, factor);
      }
      System.out.println(resultado);
      casos--;
    }
  }
}
