import java.util.Scanner;

public class DebuggingNetwork {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    for(int caso = 0; caso < T; caso++) {
      String text = sc.next();
      int k = sc.nextInt(); sc.nextLine();
      int n = text.length();
      int lengthTotal = 0;
      String palabra = "";
      principal: for(int i = 0; i < n; i++) {
        char letra = text.charAt(i);
        if(isLetter(letra)) {
          lengthTotal++;
          palabra += text.substring(i, i+1);
        } else {
          String numero = "";
          int lengthNumero = 0;
          while(!isLetter(text.charAt(i))){
            //System.out.println(i);
            numero += text.substring(i, i+1);
            i++;
            lengthNumero++;
          }
          //Sumar al length el total de letras a agregar
          if(lengthNumero > 6){
            palabra = "unfeasible";
            break principal;
          } else {
            int num = Integer.parseInt(numero);
            lengthTotal += num;
            if(lengthTotal > k){
              palabra = "unfeasible";
              break principal;
            } else {
              char aConcatenar = text.charAt(i);
              palabra += caracteres(aConcatenar, num);
            }
          }
        }
      }
      //asjkdf10000000000kz
      if(lengthTotal > k)
        palabra = "unfeasible";
      System.out.println(palabra);
    }
  }
  
  private static String caracteres(char letra, int num) {
    String caracteres = "";
    for(int i = 0; i < num; i++)
      caracteres += letra + "";
    return caracteres;
  }
  
  private static boolean isLetter(char letra) {
    return letra > 96 && letra < 123;
  }
  
}
