import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner();
        int lineas = sc.nextInt(); sc.nextLine();
        String mensaje = "";
        String linea = "";
        while(lineas > 0){
            linea += sc.next();
            sc.nextLine();
            lineas--;
        }
        int index = 15;
        while(true){
            if(index < linea.length()){
                if((linea.substring(index-1,index).equals("I") || linea.substring(index-1,index).equals("O")) && !linea.substring(index-1,index).equals("X"))
                mensaje += String.valueOf(linea.charAt(index));
                index += 16;
            } else break;
        }
    }
}
