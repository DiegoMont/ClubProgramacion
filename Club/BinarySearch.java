import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BinarySearch {

     public static void main(String []args) throws FileNotFoundException{
         Scanner sc = new Scanner(new File("texto.txt"));
         int arraySize = sc.nextInt();
         int[] arreglo = new int[arraySize];
         int numQueries = sc.nextInt(); sc.nextLine();
         for(int i = 0; i < arraySize; i++){
             arreglo[i] = sc.nextInt();
         }
         sc.nextLine();
         for(int casos = 0; casos < numQueries; casos++){
           int elemento = sc.nextInt(); sc.nextLine();
           int indice = binarySearch(arreglo, 0, arreglo.length-1, elemento);
           if (indice != -1) {
             while(indice+1 < arreglo.length){
               int nuevaBusqueda = binarySearch(arreglo, indice+1, arreglo.length-1, elemento);
               if (nuevaBusqueda == -1) {
                 break;
               } else {
                 indice = nuevaBusqueda;
               }
             }
           }
           System.out.println(indice);
         }
     }

    private static int binarySearch(int[] lista, int izq, int der, int element){
      if (der < izq) return -1;
        int m = (der + izq) / 2;
        if(lista[m] == element) return m;
        else if (lista[m] > element) return binarySearch(lista, izq, m-1, element);
        else return binarySearch(lista, m+1, der, element);
   }
}
