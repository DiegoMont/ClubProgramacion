import java.util.Scanner;

public class R {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    for(; t > 0; t--){
      int n = Integer.parseInt(sc.nextLine());
      int[] a = new int[n];
      long[] tabla = new long[n];
      for(int i = 0; i < n; i++)
        a[i] = sc.nextInt();
      sc.nextLine();
      long resultado = 0;
      for(int i = 0; i < n; i++)
        resultado = Math.max(resultado, getMaxScore(a, i, tabla));
      System.out.println(resultado);
    }
  }

  private static long getMaxScore(int[] a, int i, long[] tabla){
    if(i > a.length-1)
      return 0;
    else if(tabla[i] != 0)
      return tabla[i];
    else
      tabla[i] = a[i] + getMaxScore(a, i+a[i], tabla);
      return tabla[i]; 
  }
}