import java.math.BigInteger;
import java.util.Scanner;

public class Q_2G {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    for(; t > 0; t--){
      int n = sc.nextInt(), k = sc.nextInt(); sc.nextLine();
      int[] a = new int[n+1];
      for(int i = 0; i < n; i++)
        a[sc.nextInt()]++;
      sc.nextLine();
      int p = k;
      int i = n;
      for(; i > 0; i--){
        if(a[i] >= p)
          break;
        else
          p -= a[i];
      }
      System.out.println(getCombinaciones(a[i], p));
    }
  }

  private static int getCombinaciones(int n, int k){
    BigInteger num = new BigInteger("1");
    int max = Math.max(k, n-k);
    int min = Math.min(k, n-k);
    for(int i = n; i > max; i--)
      num = num.multiply(new BigInteger(Integer.toString(i)));
    for(int i = min; i > 1; i--)
      num = num.divide(new BigInteger(Integer.toString(i)));
    return num.mod(new BigInteger(Integer.toString(1000_000_007))).intValue();
  }

}