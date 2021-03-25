import java.util.Scanner;
import java.util.LinkedList;

public class Bicoloring {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    while(n != 0){
      int l = Integer.parseInt(sc.nextLine());
      boolean[][] grafo = new boolean[n][n];
      for (int i = 0; i < l; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt(); sc.nextLine();
        grafo[a][b] = true;
        grafo[b][a] = true;
      }
      boolean[] visitados = new boolean[n];
      char[] colores = new char[n];
      LinkedList<Integer> q = new LinkedList<>();
      q.add(0);
      colores[0] = 'B';
      boolean resultado  = true;
      while(!q.isEmpty()){
        int i = q.remove();
        visitados[i] = true;
        for(int j = 0; j < n; j++)
          if(grafo[i][j])
            if(!visitados[j]){
              q.add(j);
              colores[j] = colores[i] == 'B' ? 'N': 'B';
            }
      }

      visitados = new boolean[n];
      q.add(0);
      while(!q.isEmpty()){
        int i = q.remove();
        visitados[i] = true;
        for(int j = 0; j < n; j++)
          if(grafo[i][j])
            if(visitados[j]){
              if(colores[i] == colores[j])
                resultado = false;
                break;
            } else {
              q.add(j);
            }
      }

      System.out.println(resultado ? "BICOLORABLE.": "NOT BICOLORABLE.");
      n = Integer.parseInt(sc.nextLine());
    }
  }
}
