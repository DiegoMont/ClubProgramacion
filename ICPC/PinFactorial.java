import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class PinFactorial {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner sc = new Scanner(new File("../texto.txt"));
    int casos = sc.nextInt(); sc.nextLine();
    for (int d = 0; d < casos; d++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt(); sc.nextLine();
      int pin = 1;
      int resultado = 0;
      for (int i = 1; i < l; i++) {
        pin *= i;
        while (pin % 10 == 0) pin /= 10;
      }
      for (int i = l; i <= r; i++) {
        pin *= i;
        while (pin % 10 == 0) pin /= 10;
        resultado += (x <= pin && pin <= y)? 1 : 0;

      }
      System.out.println(resultado);
    }
    sc.close();
  }
}
