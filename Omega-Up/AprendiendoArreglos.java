import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        int[] arreglo = new int[n];
        while(n > 0){
            arreglo[n-1] = sc.nextInt();
            n--;
        }
        sc.nextLine();
        int a = sc.nextInt();
        int b = sc.nextInt(); sc.nextLine();
        int resultado = 0;
        for(int x: arreglo){
            if(x >= a && x <= b) resultado++;
        }
        System.out.println(resultado);
    }
}
