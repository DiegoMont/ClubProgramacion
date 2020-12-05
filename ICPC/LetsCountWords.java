import java.util.Scanner;
import java.util.Arrays;

public class LetsCountWords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] palabras = sc.nextLine().split(" ");
    
    //Para cada palabra
    for(int i = 0; i < n; i++){
      //System.out.println(Arrays.toString(palabras));
      String W = palabras[i];
      if(W == null)
        continue;
      for(int j = i+1; j < n; j++) {
        String W1 = palabras[j];
        if(W1 == null || W.length() != W1.length())
          continue;
        //Encontrar la primera letra en que coinciden
        String aux = "";
        for(int k = 0; k < W1.length(); k++) {
          //System.out.println(W1.charAt(k));
          if(W.charAt(0) == W1.charAt(k)) {
            aux = "";
            int l = 0, m = k;
            while(l < W.length()) {
              if(m == W1.length())
                m = 0;
              if(W.charAt(l) == W1.charAt(m)) {
                aux += W.charAt(l) + "";
                //System.out.println(aux);
              } else {
                break;
              }
              l++;
              m++;
            }
            if(aux.equals(W)){
              palabras[j] = null;
              break;
            }
          }
        }
      }
    }
    //word icpc rdwo dwor ordw pcic ccpi
    
    int total = 0;
    for(int i = 0; i < n; i++)
      if(palabras[i] != null)
        total++;
    System.out.println(total);
  }
  
}
