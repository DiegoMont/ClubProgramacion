import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Jamie {
  public static void main (String[]args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("texto.txt"));
    int numCases = Integer.parseInt(sc.nextLine());
    for (int i = 0; i<numCases ;i++){
      long resultado = 1L;
      String [] lectura = new String [3];
      lectura = sc.nextLine().split(" ");
      double n = (Double.parseDouble(lectura[0]))/(Double.parseDouble(lectura[1]));
      long c = (long) Math.floor((n * Math.pow(10, Integer.parseInt(lectura[2]))));
      for (int j = 1; j<=Integer.parseInt(lectura[2]); j++){
        if( c%10 != 0){
          resultado = resultado*(c%10);
        }
        c = c/10;
      }
      System.out.println(resultado%188888881);
    }
  }
}
