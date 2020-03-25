//Judges Time
import java.util.Scanner;
public class J {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, s;
    n = sc.nextInt();
    s = sc.nextInt(); sc.nextLine();
    int max = 0;
    for (int i = 0; i < n; i++) {
      int temp = sc.nextInt();
      if(temp > max)
        max = temp;
    }
    sc.nextLine();
    double resultado = max * s;
    resultado /= 1000.0;
    resultado = Math.ceil(resultado);
    max = (int)resultado;
    System.out.println(max);
  }
}
