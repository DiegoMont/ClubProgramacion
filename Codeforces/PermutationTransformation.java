import java.util.Scanner;

public class PermutationTransformation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    for(; t > 0; t--){
      final int n = Integer.parseInt(sc.nextLine());
      int[] a = new int[n], respuesta = new int[n];
      for(int i = 0; i < n; i++)
        a[i] = sc.nextInt();
      sc.nextLine();
      recur(a, 0, n, 0, respuesta);
      String resultado = "";
      for(int i = 0; i < n; i++)
        resultado += respuesta[i] + " ";
      System.out.println(resultado);
    }
  }

  private static void recur(int[] a, int inicio, int fin, int currentLevel, int[] resultados){
    int indice = getMaxIndex(a, inicio, fin);
    if(indice == -1)
      return;
    //System.out.println(String.format("%d, i = %d, current level = %d", a[indice], indice, currentLevel));
    resultados[indice] = currentLevel;
    recur(a, inicio, indice, currentLevel+1, resultados);
    recur(a, indice+1, fin, currentLevel+1, resultados);
  }

  private static int getMaxIndex(int[] a, int inicio, int fin){
    int max = -1;
    int indice = -1;
    for(int i = inicio; i < fin; i++)
      if(a[i] > max){
        max = a[i];
        indice = i;
      }
    return indice;
  }
}