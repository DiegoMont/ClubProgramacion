import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Gcd{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner sc = new Scanner(new File("texto.txt"));
    int a = sc.nextInt();
    int b = sc.nextInt();
    while (a!=b||a!=-1){
      int gcd = 1;
      boolean encontrado = false;
      int divisor = 2;
      while (!encontrado) {
        if ((divisor==a||b==divisor)&&!(a%divisor == 0 && b%divisor == 0)) {
          encontrado=true;
        } else if(a%divisor != 0 && b%divisor != 0){
          divisor++;
        } else {
          a/=divisor;
          b/=divisor;
          gcd*=divisor;
        }
      }
      System.out.println(gcd);
      a = sc.nextInt();
      b = sc.nextInt();
    }
  }
}
