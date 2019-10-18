import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String linea = sc.nextLine().toUpperCase();
    String[] demasInput = sc.nextLine().split(" ");
    int grupos = Integer.parseInt(demasInput[0].substring(1));
    int regre = Integer.parseInt(demasInput[1].substring(1));
    if (linea.substring(0, 1).equals("D")) {
      linea = hacerCorrimiento(linea, -regre);
    } else {
      linea = hacerCorrimiento(linea, regre);
    }
    linea = invertirGrupos(linea.substring(1), grupos);
    System.out.println(linea);
  }

  private static String invertirGrupos(String mensaje, int grupo){
    String inversion = "";
    int inferior = -grupo;
    int superior = 0;
    while (superior < mensaje.length()) {
      inferior += grupo;
      superior += grupo;
      if (superior > mensaje.length()) superior = mensaje.length();
      inversion += palabraInvertida(mensaje.substring(inferior, superior));
    }
    return inversion;
  }

  private static String hacerCorrimiento(String mensaje, int distancia){
    String original = "";
    for (int i = 0; i < mensaje.length(); i++) {
      original += new String(Character.toChars(((int)mensaje.charAt(i)) + distancia));
    }
    return original;
  }

  private static String palabraInvertida(String palabra){
    return palabra.length() == 1 ? palabra: palabra.charAt(palabra.length()-1) + palabraInvertida(palabra.substring(0, palabra.length()-1));
  }
}
