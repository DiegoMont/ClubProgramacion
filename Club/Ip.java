import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Ip{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner sc = new Scanner(new File("texto.txt"));
    String[] ip = sc.next().split("\\.");
    for(String octet: ip){
      int octeto = Integer.parseInt(octet);
      for (int i = 7; i >= 0; i--) {
        if (octeto-Math.pow(2, i)>=0) {
          System.out.print("1");
          octeto -= Math.pow(2, i);
        } else {
        System.out.print("0");
        }
      }
    }
  }
}
