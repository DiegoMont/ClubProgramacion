import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SecondLargest {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner sc = new Scanner(new File("texto.txt"));
    int casos = sc.nextInt(); sc.nextLine();
    for (int j = 0; j < casos; j++) {
      String[] linea = sc.nextLine().split(" ");
      if (linea.length < 2) {
        System.out.println(-1);
        continue;
      }
      int numero = Integer.parseInt(linea[0]);
      int max = numero;
      int secondLargest = numero;
      int i;
      for (i = 1; i < linea.length; i++) {
        numero = Integer.parseInt(linea[i]);
        if (numero != max) {
          secondLargest = numero;
          //System.out.print(secondLargest + " "+i+" ");
          break;
        }
      }
      while (i < linea.length) {
        numero = Integer.parseInt(linea[i]);
        if (numero > max) {
          secondLargest = max;
          max = numero;
        } else if (numero > secondLargest) {
          secondLargest = numero;
        }
        i++;
      }
      System.out.println(max!=secondLargest?secondLargest:-1);
    }
    sc.close();
  }
}
