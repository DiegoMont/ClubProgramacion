import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class SolucionesJava {

  public static void main(String[] args){
    long tiempoInicio = System.currentTimeMillis();
    problemGConcurso();
    System.out.println("Tiempo: "+(System.currentTimeMillis()-tiempoInicio)+"ms");
  }

  public static void problemB (){
    Scanner sc = new Scanner(System.in);
    //Scanner sc = new Scanner(new File("inputs.txt"));
    int casos = sc.nextInt();sc.nextLine();
    for(int j = 1; j < casos+1; j++) {
      String num1 = sc.next();
      String num2 = sc.next(); sc.nextLine();
      if (num1.length() < num2.length()) {
        String aux = num1;
        num1 = num2;
        num2 = aux;
      }
      int[] resultado = new int[num1.length()+1];
      int residuo = 0;
      for(int i = 0;i < num2.length(); i++) {
        int suma = residuo + Character.getNumericValue(num1.charAt(num1.length()-1-i)) + Character.getNumericValue(num2.charAt(num2.length()-1-i));
        if (suma == 2) {
          resultado[resultado.length-1-i] = 0;
          residuo = 1;
        } else if (suma == 3) {
          resultado[resultado.length-1-i] = 1;
          residuo = 1;
        } else {
          resultado[resultado.length-1-i] = suma;
          residuo = 0;
        }
      }
      for (int i = num1.length()-num2.length()-1; i > -1; i--) {
        int suma = Character.getNumericValue(num1.charAt(i)) + residuo;
        if (suma == 2) {
          residuo = 1;
          resultado[i+1] = 0;
        } else {
          resultado[i+1] = suma;
          residuo = 0;
        }
      }
      resultado[0] = residuo;
      System.out.print(j+" ");
      if (resultado[0] == 1) {
        System.out.print(resultado[0]);
      }
      for (int i =1; i < resultado.length; i++) {
        System.out.print(resultado[i]);
      }
      System.out.println();
    }
    sc.close();
  }

  public void problemA (){
    //Scanner sc = new Scanner(new File("inputs.txt"));
    Scanner sc = new Scanner(System.in);
    int casos = sc.nextInt(); sc.nextLine();
    for (casos+=0; casos > 0; casos--) {
      String[] horario = sc.next().split(":");
      sc.nextLine();
      if (Integer.parseInt(horario[1]) > 0) {
        System.out.println(0);
      } else {
        int hora = Integer.parseInt(horario[0]);
        if (hora < 13) {
          System.out.println(hora+12);
        } else {
          System.out.println(hora-12);
        }
      }
    }
    sc.close();
  }

  public static void problemC(){
    Scanner sc = new Scanner(System.in);
    //Scanner sc = new Scanner(new File("inputs.txt"));
    int cases = sc.nextInt(); sc.nextLine();
    for (int i = 1; cases+1 > i; i++) {
      String fecha1 = sc.next();
      String fecha2 = sc.next(); sc.nextLine();
      String[] date1 = fecha1.split("/");
      String[] date2 = fecha2.split("/");
      System.out.print(i+" ");
      if (date1[0].equals(date2[0]) && date1[1].equals(date2[1])) {
        System.out.println("SAME DAY");
      } else {
        boolean encontroAlgo = false;
        int[][] periodo = new int[15][3];
        for (int j =1; j < 8; j++) {
          periodo[7-j][1] = Integer.parseInt(date1[0]);
          periodo[7-j][0] = Integer.parseInt(date1[1])-j;
          periodo[7-j][2] = Integer.parseInt(date1[2]);
          if (periodo[7-j][0]<1) {
            periodo[7-j][1]--;
            periodo[7-j][0]+=diasMes(periodo[7-j][1] < 1 ? 12: periodo[7-j][1], periodo[7-j][2]);
            if (periodo[7-j][1] < 1) {
              periodo[7-j][1] =12;
              periodo[7-j][2]--;
            }
          }
          if (Integer.parseInt(date2[1]) == periodo[7-j][0] && Integer.parseInt(date2[0])==periodo[7-j][1]) {
            System.out.print(fecha2+"/");
            System.out.println(periodo[7-j][2]+" IS "+j+" DAY"+ (j > 1?"S":"") +" PRIOR");
            encontroAlgo = true;
            break;
          }
          //System.out.println(periodo[7-j][0]+"/"+periodo[7-j][1]+"/"+periodo[7-j][2]);
          periodo[7+j][1] = Integer.parseInt(date1[0]);
          periodo[7+j][0] = Integer.parseInt(date1[1])+j;
          periodo[7+j][2] = Integer.parseInt(date1[2]);
          if (periodo[7+j][0]>diasMes(periodo[7+j][1], periodo[7+j][2])) {
            periodo[7+j][1]++;
            periodo[7+j][0]-=diasMes(periodo[7+j][1] > 12 ? 1: periodo[7+j][1], periodo[7+j][2]);
            if (periodo[7+j][1] > 12) {
              periodo[7+j][1] =1;
              periodo[7+j][2]++;
            }
          }
          if (Integer.parseInt(date2[0]) == periodo[7+j][1] && Integer.parseInt(date2[1])==periodo[7+j][0]) {
            System.out.print(fecha2+"/");
            System.out.println(periodo[7+j][2]+" IS "+j+" DAY"+ (j > 1?"S":"") +" AFTER");
            encontroAlgo = true;
            break;
          }
          //System.out.println(periodo[7+j][1]+"/"+periodo[7+j][0]+"/"+periodo[7+j][2]);
        }
        if (!encontroAlgo) {
          System.out.println("OUT OF RANGE");
        }
      }
    }
    sc.close();
  }

  public static int diasMes (int mes, int anio) {
    switch (mes) {
      case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
      case 4: case 6: case 9: case 11: return 30;
      default: if (anio%4==0 && !(anio%100==0) || anio%400==0) {
        return 29;
      } else {
        return 28;
      }
    }
  }

  public static void problemD () {
    //Scanner sc = new Scanner(new File("inputs.txt"));
    Scanner sc = new Scanner(System.in);
    int a;
    do {
      a = sc.nextInt();sc.nextLine();
      if (a == 0) {
        break;
      }
      int[] sumFilas = new int[a];
      int[] error = new int[4];//Filas Columnas y x
      int[] sumColumnas = new int[a];
      for (int i = 0; i < a; i++) {
        for (int j = 0; j < a; j++) {
          int numMatriz = sc.nextInt();
          sumFilas[i]+= numMatriz;
          sumColumnas[j] += numMatriz;
          if (i == a-1) {
            if (sumColumnas[j]%2!=0) {
              error[1]++;
              error[3] = j;
            }
            //System.out.print(" Columna "+j+": " +error[3]);
          }
          if (j == a-1) {
            if (sumFilas[i]%2 != 0) {
              error[0]++;
              error[2]=i;
            }
            //System.out.print(" Fila "+i+": "+error[2]);
          }
        }
        sc.nextLine();
      }
      if (error[0] == 0 && error[1] == 0) {
        System.out.println("OK");
      } else if (error[0] > 1 || error[1] > 1) {
        System.out.println("Corrupt");
      } else {
        System.out.println("Change bit ("+(error[2]+1)+","+(error[3]+1)+")");
      }
    } while (a > 0);
    sc.close();
  }

  public static void problemI() {
    //Scanner sc = new Scanner(new File("inputs.txt"));
    Scanner sc = new Scanner(System.in);
    int casos = sc.nextInt(); sc.nextLine();
    for (int i = 0; i < casos; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int k = sc.nextInt(); sc.nextLine();
      long resultado = (a - b) * ((long)(k/2));
      resultado += (a * (k%2));
      System.out.println(resultado);
    }
    sc.close();
  }

  public static void problemJ(){
    //Scanner sc = new Scanner(new File("inputs.txt"));
    Scanner sc = new Scanner(System.in);
    int numeroFlats = sc.nextInt(); sc.nextLine();
    int[] flats = new int[numeroFlats];
    int[] cambios =new int[numeroFlats];
    int ceros = 0;
    flats[0] = sc.nextInt();
    for (int i = 1; i < numeroFlats; i++) {
      flats[i] = sc.nextInt();
      if (flats[i] == 0) {
        cambios[ceros] = i;
        ceros++;
      }
    }
    int resultado = 0;
    for (int i = 0; i < ceros; i++) {
      if(cambios[i]+1 < flats.length){
        if (flats[cambios[i]-1] == 1 && flats[cambios[i]+1] == 1) {
          resultado++;
          if (cambios[i]+2 < flats.length) {
            if(flats[cambios[i]+2] == 0 ) {
              //System.out.print("resta ");
              /*resultado--;
              if (cambios[i]+3 == flats.length) {
                resultado++;
              }*/
              flats[cambios[i]+1] = 0;
            }
          }
        }
      }
    }
    System.out.println(resultado);
    sc.close();
  }

  public static void problemGConcurso(){
    //Scanner sc = new Scanner(new File("inputs.txt"));
    Scanner sc = new Scanner(System.in);
    int resultado = 1;
    long n = sc.nextLong(); sc.nextLine();
    for (long i = 1; i-1 < n/2; i++) {
      long suma = 0;
      for (long j = i; suma < n; j++) {
        suma += j;
      }
      if (suma == n) {
        resultado++;
      }
    }
    System.out.println(resultado);
    sc.close();
  }

}
