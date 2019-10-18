import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineas = sc.nextInt(); sc.nextLine();
        String mensaje = "";
        String linea = "";
        while(lineas > 0){
            linea += sc.next();
            sc.nextLine();
            lineas--;
        }
        int index = 15;
        while(index <= linea.length()){
          if (!(linea.substring(index, index+1).equals("X") && (linea.substring(index-1, index).equals("I") || linea.substring(index-1, index).equals("O")))) {
            mensaje += linea.substring(index, index+1);
          }
          index+=16;
        }
        if (mensaje.indexOf("CUADRADO") == 0) {
          int size = posicion(mensaje.substring(8, 9));
          for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) System.out.print("*");
            System.out.println();
          }
        } else if (mensaje.indexOf("PIRAMIDE") == 0) {
          int altura = posicion(mensaje.substring(8, 9));
          int largo = altura*2 - 1;
          for (int i = 0; i < altura; i++) {
            int asteriscos = (i+1)*2 -1;
            for (int j = (largo - asteriscos)/2; j > 0; j--) {
              System.out.print(" ");
            }
            while (asteriscos > 0) {
              System.out.print("*");
              asteriscos--;
            }
            System.out.println();
          }
        } else if (mensaje.indexOf("TRIANGULO") == 0) {
          int altura = posicion(mensaje.substring(9, 10));
          for (int i = 0; i < altura; i++) {
            for (int j = i + 1; j > 0; j--) {
              System.out.print("*");
            }
            System.out.println();
          }
        } else {
          System.out.println(mensaje);
        }
    }

    private static int posicion(String letra){
      String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      return abc.indexOf(letra) + 1;
    }
}
