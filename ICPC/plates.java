import java.util.Scanner;

public class plates {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt(); sc.nextLine();
    String[] badWords = new String[n];
    //Leer bad words
    for (int i = 0; i < n; i++) {
      badWords[i] = sc.nextLine();
    }

    //Leer placas
    for (int i = 0; i < m; i++) {
      String placaRaw = sc.nextLine();
      String placa = "";
      for (int j = 0; j < placaRaw.length(); j++) {
        char letra = placaRaw.charAt(j);
        switch (letra) {
          case '0':
            placa+="O";
            break;
          case '1':
            placa+="L";
            break;
          case '2':
            placa+="Z";
            break;
          case '3':
            placa+="E";
            break;
          case '5':
            placa+="S";
            break;
          case '6': case '8':
            placa+="B";
            break;
          case '7':
            placa+="T";
            break;
          default:
            placa += letra;
            break;
        }
      }
      boolean isValid = true;
      for (String badWord: badWords) {
        if(placa.contains(badWord)){
          isValid = false;
          break;
        }
      }
      System.out.println(isValid ? "VALID": "INVALID");
    }
  }
}