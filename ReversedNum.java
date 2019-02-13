import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class ReversedNum {
  public static void main(String[] args) throws FileNotFoundException{
    long inicio = System.currentTimeMillis();
    Scanner sc = new Scanner(new File("texto.txt"));
    for (int casos = sc.nextInt(); casos > 0; casos--) {
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();
      int num1Rev = 0; int num2Rev = 0;
      while (n1 != 0 || n2 != 0) {
        num1Rev = (n1==0? num1Rev:num1Rev*10) + n1%10;
        num2Rev = (n2==0? num2Rev:num2Rev*10) + n2%10;
        n1 /= 10;
        n2 /= 10;
      }
      int resultado = num1Rev + num2Rev;
      int resRev = 0;
      while (resultado > 0) {
        resRev = resRev*10 + resultado%10;
        resultado /=10;
      }
      System.out.println(resRev);
    }
    sc.close();
    System.out.println(System.currentTimeMillis()-inicio+" ms");
  }
}
