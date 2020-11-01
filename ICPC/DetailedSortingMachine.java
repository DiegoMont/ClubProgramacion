import java.util.Scanner;

public class DetailedSortingMachine {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    int[] arreglo = new int[n];

    //Checar en donde se empiezan a desordenar
    arreglo[0] = sc.nextInt();
    boolean isSorted = true;
    int desorden = 0;
    for (int i = 1; i < arreglo.length; i++) {
      arreglo[i] = sc.nextInt();
      if (arreglo[i] < arreglo[i-1] && isSorted) {
        isSorted = false;
        desorden = i;
      }
    }

    if (isSorted) {
      System.out.println(0);
    } else {
      int menor = desorden;
      for (int i = desorden; i < n; i++) {
        if(arreglo[i] < arreglo[menor])
          menor = i;
      }
      //System.out.println(menor);
      int i = 0;
      while(arreglo[menor] > arreglo[i]){
        i++;
      }
      //System.out.println(i);
      int resultado = menor - i + (menor+1 == n ? 0: n - 1 - menor);
      System.out.println(resultado);
    }

  }

}
