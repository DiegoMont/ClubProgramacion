import java.util.Scanner;

class G {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); sc.nextLine();
    byte[] tabla = new byte[1000001];
    for(;t > 0; t--){
      int n = Integer.parseInt(sc.nextLine());
      byte resultado = checarElDato(n, tabla);
      System.out.println(resultado == 1 ? "YES": "NO");
    }
  }

  private static byte checarElDato(int n, byte[] tabla){
    if(0 > n)
      return -1;
    if(tabla[n] != 0)
      return tabla[n];
    byte resultado = 0;
    if(n == 0)
        resultado = 1;
    if(0 < n)
      resultado = (byte) Math.max(checarElDato(n-2020, tabla), checarElDato(n-2021, tabla));
    tabla[n] = resultado;
      return resultado;
  }
}