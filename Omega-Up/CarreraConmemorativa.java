import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("texto.txt"));
    int n = sc.nextInt();
    int m = sc.nextInt(); sc.nextLine();
    byte[][] grafo = new byte[n][n];
    for (int i = 0; i < m; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1; sc.nextLine();
      grafo[u][v]  = 1;
      grafo[v][u] = 1;
    }
  }
}
