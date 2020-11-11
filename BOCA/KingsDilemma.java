import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class KingsDilemma {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(); sc.nextLine();
    int[][] grafo = new int[n][n];
    int[] numCaminos = new int[n];
    ArrayList<Punto> calles = new ArrayList<>(m);
    for (int i = 0; i < m; i++) {
      int[] coordenadas = new int[2];
      coordenadas[0] = sc.nextInt()-1; coordenadas[1] = sc.nextInt()-1; sc.nextLine();
      calles.add(new Punto(coordenadas[0], coordenadas[1]));
    }
    Collections.sort(calles);
    for (int i = 0; i < k; i++) {
      int u = calles.get(i).x, v = calles.get(i).y;
      if(i < k) {
        grafo[u][v] = 1;
        numCaminos[u]++;
        numCaminos[v]++;
      }
    }
    if (m < k || k < n-1) {
      System.out.println("Impossible");
    } else {
      if (puedeLlegarATodosLados(grafo)) {
        for (int i = 0; i < numCaminos.length; i++)
          System.out.print(numCaminos[i] + " ");
        System.out.println("");
      } else
        System.out.println("Impossible");
    }
  }

  private static boolean puedeLlegarATodosLados(int[][] grafo){
    int n = grafo.length;
    boolean[] visitadas = new boolean[n];
    LinkedList<Integer> fila = new LinkedList<>();
    fila.add(0);
    while (fila.size() > 0) {
      int nodo = fila.remove();
      visitadas[nodo] = true;
      for (int i = 0; i < n; i++) {
        if (grafo[nodo][i] == 1 && !visitadas[i]) {
          fila.add(i);
        }
      }
    }
    boolean resultado = true;
    for (boolean ciudadVisitada : visitadas)
      resultado = resultado && ciudadVisitada;
    return resultado;
  }

}

class Punto implements Comparable<Punto> {
  public int x, y;
  public Punto(int x, int y) {
    this.x = x; this.y = y;
  }

  @Override
  public int compareTo(Punto otroPunto){
    if (this.x < otroPunto.x) {
      return -1;
    } else if(this.x > otroPunto.x){
      return 1;
    } else {
      if (this.y < otroPunto.y) {
        return -1;
      } else if(this.y > otroPunto.y){
        return 1;
      } else {
        return 0;
      }
    }
  }
}
