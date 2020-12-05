import java.util.Scanner;
import java.math.BigInteger;

public class CountingTriangles {
  public static void main(String[] args) {
    final BigInteger MODULO = new BigInteger("1000000007");
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    for(int x = 0; x < T; x++){
      int n = sc.nextInt() + 1, k = sc.nextInt() + 1; sc.nextLine();
      long triangulosSuperiores = n * (n + 1) / 2;
      BigInteger sumaTriangulos = new BigInteger(triangulosSuperiores + "");
      BigInteger kha = new BigInteger(k + "");
      BigInteger resultado = sumaTriangulos.multiply(kha);
      System.out.println(resultado.mod(MODULO).toString());
    }
  }
}
