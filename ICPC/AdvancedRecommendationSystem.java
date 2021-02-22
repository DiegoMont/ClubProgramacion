import java.util.Scanner;

public class AdvancedRecommendationSystem {
  public static void main(String[] a){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), q = sc.nextInt(); sc.nextLine();
    int[][] tablita = new int[n][n];
    int[] maximos = new int[n];
    int[] countMaximos = new int[n];
    int[] indiceMaximos = new int[n];
    for(int t = 0; t < q; t++){
      String query = sc.next();
      if(query.equals("R")){
        int i = sc.nextInt(), j = sc.nextInt(); sc.nextLine();
        tablita[i][j]++;
        if(tablita[i][j] > maximos[i]) {
          maximos[i] = tablita[i][j];
          countMaximos[i] = 1;
          indiceMaximos[i] = j+1;
        } else if(tablita[i][j] == maximos[i]){
          countMaximos[i]++;
        }
      } else if(query.equals("Q")){
        int i = sc.nextInt();
        if(maximos[i] == 0){
          System.out.println("No info");
        } else if(countMaximo[i] > 2){
          System.out.println("Multiple");
        } else {
          System.out.println(String.format("%d", indiceMaximos[i]));
        }
      } else {
        
      }
    }
  }
}

class Producto {
  
}

class Relacion {
  int contador;
  public Relacion(){
    contador = 0;
  }
}
