import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Baker{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner sc = new Scanner(new File("texto.txt"));
    int casos = sc.nextInt();
    for (int i = 1; i <= casos; i++) {
      int x = sc.nextInt();
      if (x < 3) {
        System.out.println("Case "+i+": "+x);
      } else {
        int d = x / 2 + 1;
        int resultado;
        do{
          d--;
          resultado = 0;
          int j = 0;
          while(resultado < x){
            resultado+=(d+j);
            j++;
          }
        } while(resultado != x && d > 0);
        System.out.println("Case "+i+": "+((d > 0)?d:-1));
      }
    }
  }
}
