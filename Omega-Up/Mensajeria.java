import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> ciudades = new ArrayList<>();
    byte[][] grafo = new byte[1][1];
    for (int m = Integer.parseInt(sc.nextLine()); m > 0; m--) {
      ArrayList<String> arregloCiudades = new ArrayList<>();
      int numCiudades = sc.nextInt();
      for (int j = 0; j < numCiudades; j++) {
        arregloCiudades.add(sc.next());
      }
      sc.nextLine();
      for (int k = 0; k < numCiudades; k++) {
        int indiceCiudadRepetida = ciudades.indexOf(arregloCiudades.get(k));
        if (indiceCiudadRepetida > -1) {
          for (int j = 0; j < numCiudades; j++) {
            if (grafo[indiceCiudadRepetida][j] == 1 && j != indiceCiudadRepetida) {
              arregloCiudades.add(ciudades.get(j));
            }
          }
        } else {
          ciudades.add(arregloCiudades.get(k));
          grafo = crecerArreglo(grafo);
        }
      }
      for (String ciudad: arregloCiudades) {
        int k = ciudades.indexOf(ciudad);
        for (String ciudad2: arregloCiudades) {
          int j = ciudades.indexOf(ciudad2);
          grafo[j][k] = 1;
        }
      }
    }
    int origen = ciudades.indexOf(sc.nextLine());
    int destino = ciudades.indexOf(sc.nextLine());
    System.out.println(grafo[origen][destino] == 1 ? "posible": "imposible");
    sc.close();
  }

  private static byte[][] crecerArreglo(byte[][] arreglo){
    byte[][] aux = new byte[arreglo.length+1][arreglo.length+1];
    for (int i = 0; i < arreglo.length; i++) {
      for (int j = 0; j < arreglo[0].length; j++) {
        aux[i][j] = arreglo[i][j];
      }
    }
    return aux;
  }
}
