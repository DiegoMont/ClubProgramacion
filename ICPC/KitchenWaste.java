import java.util.Scanner;
//import java.io.File;

class K {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt(); sc.nextLine();
    int desperdicio = 0;

    int[] panes = new int[n];

    for (int i = 0; i < n; i++)
      panes[i] = sc.nextInt();
    sc.nextLine();

    int panActual = 0;
    for (int i = 0; i < m; i++) {
      int cremaDisponible = sc.nextInt();
      while (panActual < n && cremaDisponible >= panes[panActual]) {
        cremaDisponible -= panes[panActual];
        panActual++;
      }
      desperdicio += cremaDisponible;
    }
    sc.nextLine();

    System.out.println(desperdicio);
  }
}