import java.util.Scanner;
import java.util.Arrays;

public class IsItSecureEnough {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, testCases;
        String input;

        testCases = Integer.parseInt(sc.nextLine());

        for (i = 0; i < testCases; i++) {
            input = sc.nextLine();
            int reglasCumplidas = 0;
            int n = input.length();
            
            if(n > 9)
              reglasCumplidas++;
            
            char ant = 0;
            boolean isUpper = false, isLower = false, hasDigit = false, noConsecutivos = true, hasCaracter = false;
            for(int j = 0; j < n; j++){
                char act = input.charAt(j);
                //ChecarSiEsUppercase
                if(!isUpper){
                    if(act > 64 && act < 91)
                    isUpper = true;
                }
                //ChecarSiEsLowercase
                if(!isLower){
                    if(act > 96 && act < 123)
                    isLower = true;
                }
                //Checar que tenga un digito y si es consecutivo
                if(act > 47 && act < 58) {
                    hasDigit = true;
                    if(ant > 47 && ant < 58 && Math.abs(act - ant) == 1)
                        noConsecutivos = false;
                }
                //Checar si tiene un caracter especial
                if(!hasCaracter){
                    if((act > 34 && act < 42 && act != 49) || act == 46 || act == 47)
                        hasCaracter = true;
                }
                ant = act;
            }

            if(isLower) reglasCumplidas++;
            if(isUpper) reglasCumplidas++;
            if(hasDigit && noConsecutivos) reglasCumplidas++;
            if(hasCaracter) reglasCumplidas++;
            
            System.out.print("Assertion number #" + (i+1) + ": ");
            switch (reglasCumplidas) {
                case 5:
                    System.out.println("Strong");
                    break;
                case 4:
                    System.out.println("Good");
                    break;
                case 3:
                    System.out.println("Weak");
                    break;
                default:
                    System.out.println("Rejected");
                    break;
            }
        }
    }
}