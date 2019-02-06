import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Jamie {
  public static void main (String[]args) throws FileNotFoundException {
    long currentTime = System.currentTimeMillis();
    Scanner sc = new Scanner(new File("texto.txt"));
    int numCases = sc.nextInt();
    for (int i = 0; i<numCases; i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      long n = sc.nextLong();


//for(a = 1; a <= 49;a++){for(b = a+1;b <99;b++){for(n =100;n <= 100;n++){


      int residuo = a;
      int j = 0;
      long Periodo = 0L;
      long[] periodo = new long[10];
      int[] residuos = {a};
      int resultado = 1;
      int indexPeriodo = 0;
      do {
        residuo *=10;
        periodo[residuo/b]++;
        int[] arregloTemp = new int[residuos.length+1];
        int nuevoResiduo = residuo%b;
        boolean encontroPeriodo = false;
        for (int l = 0; l < arregloTemp.length-1; l++) {
          arregloTemp[l]=residuos[l];
          if (nuevoResiduo == residuos[l]) {
            encontroPeriodo=true;
            indexPeriodo = l;
          }
        }
        j++;
        if (encontroPeriodo) {
          break;
        }
        arregloTemp[residuos.length] = nuevoResiduo;
        residuos = arregloTemp;
        residuo = nuevoResiduo;
      } while (n > j);
      if(n>j){
        residuo = residuos[indexPeriodo];
        long digitosPeriodo =n-j;
        for (int l = indexPeriodo; l < residuos.length; l++) {
          residuo*=10;
          int nuevoPeriodo = residuo/b;
          if (digitosPeriodo%(residuos.length-indexPeriodo)>0) {
            periodo[nuevoPeriodo] += digitosPeriodo/(residuos.length-indexPeriodo)+1;
            digitosPeriodo--;
          } else {
            periodo[nuevoPeriodo] += digitosPeriodo/(residuos.length-indexPeriodo);
          }
          Periodo= Periodo*10+(nuevoPeriodo==0?1:nuevoPeriodo);
          residuo%=b;
        }
      }
      for (int k = 1;k < 10 ; k++) {
        resultado*=Math.pow(k,periodo[k]);
        System.out.print(k+": "+periodo[k]+", ");
      }
      System.out.println("  a: " + a+"  b: "+b+"  n: "+n+"  "+((double)a/b)+"  Periodo: "+Periodo);


//}}}


    }
    System.out.println(System.currentTimeMillis() - currentTime+" ms");
  }
}
