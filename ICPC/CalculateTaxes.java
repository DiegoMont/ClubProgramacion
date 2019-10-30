import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long enteros = 0L;
    int decimales = 0;
    for (int m = Integer.parseInt(sc.nextLine()); m > 0; m--) {
      String[] input = sc.nextLine().split("\\.");
      enteros += Long.parseLong(input[0]);
      decimales += Integer.parseInt(input[1]);
    }
    int tax = getTax(enteros, decimales);
    if (tax == 0) System.out.println(enteros + "." + decimales + " 0% 0.00000");
    else {
      long enterosImpuestos = tax * enteros;
      int decimalesImpuestos = decimales * tax;
      String aux = "" + enterosImpuestos%100;
      enterosImpuestos /= 100;
      while (aux.length() < 7) {
        aux += "0";
      }
      decimalesImpuestos += Integer.parseInt(aux);
      if (decimalesImpuestos > 9_999_999) {
        enterosImpuestos += decimalesImpuestos/10000000;
        decimalesImpuestos %= 10000000;
      }
      while(decimalesImpuestos > 99999){
        int ultimoDigito = decimalesImpuestos%10;
        decimalesImpuestos /= 10;
        if (ultimoDigito>5 || (ultimoDigito == 5 && decimalesImpuestos%2 != 0)) {
          decimalesImpuestos++;
        }
      }
      System.out.println(enteros + "." + decimales + " " + tax + "% " + enterosImpuestos + "." + decimalesImpuestos);
    }
  }

  private static int getTax(long enteros, int decimales){
    if (decimales > 0) enteros++;
    if (enteros > 10_000_000_000_000_000L) return 40;
    else if(enteros > 10_000_000_000_000L) return 30;
    else if(enteros > 10_000_000_000L) return 20;
    else if(enteros > 10_000_000) return 10;
    else return 0;
  }
}
