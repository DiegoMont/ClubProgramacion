import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int declaraciones = sc.nextInt();
    int asignaciones = sc.nextInt(); sc.nextLine();
    int[][] relaciones = new int[declaraciones][declaraciones];
    String[] variables = new String[declaraciones];
    for (int i = 0; i < declaraciones; i++) {
      variables[i] = sc.nextLine().split(" ")[1];
      relaciones[i][i] = 1;
    }
    for (int i = 0; i < asignaciones; i++) {
      String[] statement = sc.nextLine().split(" ");
      int a = getIndex(variables, statement[0]);
      int b = getIndex(variables, statement[2].substring(0, statement[2].length()-1));
      relaciones[a][encontrarReferencia(relaciones, a)] = 0;
      relaciones[a][b] = 1;
    }

    int referenciasSobrantes = 0;
    for (int i = 0; i < relaciones.length; i++) {
      for (int j = 0; j < relaciones.length; j++) {
        if (relaciones[j][i] == 1) {
          referenciasSobrantes++;
          break;
        }
      }
    }

    System.out.println(referenciasSobrantes);
  }

  private static int getIndex(String[] arreglo, String valor){
    int indice = 0;
    while (!valor.equals(arreglo[indice])) indice++;
    return indice;
  }

  private static int encontrarReferencia(int[][] arreglo, int indice){
    int referencia = 0;
    for(int i = 0; i < arreglo[0].length; i++){
      if (arreglo[indice][i] == 1) {
        referencia = i;
        break;
      }
    }
    return referencia;
  }
}
