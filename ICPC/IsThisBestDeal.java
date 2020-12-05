import java.util.Scanner;
import java.util.PriorityQueue;

public class IsThisBestDeal {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PriorityQueue<Integer> fila = new PriorityQueue<>();
    int resultado = 0;
    for(int i = 0; i < 3; i++) {
      int a = sc.nextInt();
      fila.add(a);
      resultado += a;
    }
    sc.nextLine();
    if(resultado >= 500) {
      resultado = 0;
      int carry = 0;
      for(int libro: fila) {
        carry += libro;
        if(carry >= 500) {
          resultado += carry - 100;
          carry = 0;
        }
      }
      resultado += carry;
    }
    System.out.println(resultado);
  }
}
