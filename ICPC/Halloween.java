import java.util.Scanner;
//import java.util.Arrays;

public class Halloween {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int cases =Integer.parseInt(sc.nextLine());
    for (int t = 0; t < cases; t++) {
      int n = Integer.parseInt(sc.nextLine());
      int maxDulces = 0;
      int[] houses = new int[n];
      for (int i = 0; i < n; i++) {
        houses[i] = sc.nextInt();
        maxDulces += houses[i];
      }
      sc.nextLine();
      int[] tablita = new int[n];
      boolean[] visitados = new boolean[n];
      int resultado = getCandies(houses, 0, tablita, visitados);
      System.out.println(resultado);
    }
  }

  private static int getCandies(int[] houses, int i, int[] tablita, boolean[] visitados){
    if(i >= houses.length) {
      return 0;
    }
    if(visitados[i]){
      return tablita[i];
    } else {
      int sum1 = getCandies(houses, i+2, tablita, visitados) + houses[i];
      int sum2 = getCandies(houses, i+1, tablita, visitados);
      tablita[i] = Math.max(sum1, sum2);
      visitados[i] = true;
      return tablita[i];
    }
  }
}