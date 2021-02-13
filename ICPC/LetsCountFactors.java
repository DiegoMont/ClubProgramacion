import java.util.Scanner;
import java.io.File;
import java.util.LinkedList;

class L {
  public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(new File("input.txt"));

    int n = Integer.parseInt(sc.nextLine());

    //Leer input, buscar el número más grande y guardar los inputs
    long[] numeros = new long[n];
    int maxValue = 0;
    for(int i = 0; i < n; i++){
      long a = sc.nextInt(), b = sc.nextInt(); sc.nextLine();
      numeros[i] = a*b;
      maxValue = (int)Math.max(maxValue, a);
      maxValue = (int)Math.max(maxValue, b);
    }
  
    LinkedList<Integer> primos = new LinkedList<>();
    cribita(primos, maxValue);
    
    for(int i = 0; i < n; i++){
      int contador = 0;
      for(int primo: primos){
        if (primo > numeros[i])
          break;
        if(numeros[i] % primo == 0){
          contador++;
          numeros[i] /= primo;
          //System.out.println(numeros[i]);
        }
      }
      System.out.println(contador);
    }
  }

  static void cribita(LinkedList<Integer> primos, int n){
    boolean[] arreglo = new boolean[n+1];
    for(int i = 0; i < arreglo.length; i++)
      arreglo[i] = true;
    for(int p = 2; p * p <= n; p++){
      if(arreglo[p]){
        for(int i = p * p; i <= n; i+=p){
          arreglo[i] = false;
        }
      }
    }
  
    for(int i = 2; i <= n; i++)
      if(arreglo[i]){
        primos.add(i);
        //System.out.println(i);
      }
  }
}