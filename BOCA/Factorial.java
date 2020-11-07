import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);    
    int n = Integer.parseInt(sc.nextLine());
    int i = 0;
    while(n > 0){
      n -= encontrarFactorial(n);
      ++i;
    }
    System.out.println(i);
  }

  private static int encontrarFactorial(int n){
    int factorial = 1;
    int i = 1;
    while (!(factorial * i > n)) {
      factorial *= i;
      i++;
    }
    return factorial;
  }

}
