import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lavaspar {

  private static int l, c;
  private static String[] arr;
  private static byte[][] tablero;
  private static boolean[][] casillasEspeciales;
  public static void main(String[] args) throws FileNotFoundException{
    //Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner (new File("input.txt"));
    l = sc.nextInt(); c = sc.nextInt(); sc.nextLine();
    arr = new String[l];
    for (int i = 0; i < l; i++) {
      arr[i] = sc.nextLine();
    }
    int n = Integer.parseInt(sc.nextLine());
    tablero = new byte[l][c];
    casillasEspeciales = new boolean[l][c];
    String[] palabras = new String[n];
    for (byte i = 0; i < n; i++) {
      palabras[i] = sc.nextLine();
      //Para cada letra de la sopa de letras
      for (int j = 0; j < l; j++) {
        for (int k = 0; k < c; k++) {
          if (tablero[j][k] != i+1) {
            horizontal(strtochar(palabras[i]), k, j, (byte)(i+1));
            vertical(strtochar(palabras[i]), k, j, (byte)(i+1));
            diagonal(strtochar(palabras[i]), k, j, (byte)(i+1));
            diagonalInvertida(strtochar(palabras[i]), k, j, (byte)(i+1));
          }
        }
      }
    }

    String especiales = "", normales = "";

    int resultado = 0;
    for (int j = 0; j < l; j++) {
      for (int k = 0; k < c; k++) {
        especiales += (casillasEspeciales[j][k] ? "1": "0");
        normales += tablero[j][k];
        if(casillasEspeciales[j][k])
          resultado++;
      }
      especiales += "\n";
      normales += "\n";
    }
    System.out.println(especiales);
    System.out.println(normales);
    System.out.println(resultado);

  }

  private static LinkedList<Character> strtochar(String algo){
    LinkedList<Character> palabra = new LinkedList<>();
    int n = algo.length();
    for (int i = 0; i < n; i++) {
      palabra.push(algo.charAt(i));
    }
    return palabra;
  }

  private static void horizontal(LinkedList<Character> palabra, int x, int y, byte flag){
    //Checar hacia la derecha
    int limder = x, limizq = x;
    int aux = palabra.indexOf(arr[y].charAt(limder));
    while (aux != -1) {
      palabra.remove(aux);
      limder++;
      if(limder == c)
        break;
      aux = palabra.indexOf(arr[y].charAt(limder));
    }
    limizq = x - 1;
    if(x > 0) {
      aux = palabra.indexOf(arr[y].charAt(limizq));
      while (aux != -1) {
        palabra.remove(aux);
        limizq--;
        if (limizq == -1)
          break;
          aux = palabra.indexOf(arr[y].charAt(limizq));
      }
    }
    if (palabra.isEmpty()) {
      int i = limizq + 1;
      while (i < limder){
        if(tablero[y][i] > 0 && tablero[y][i] != flag)
          casillasEspeciales[y][i] = true;
        tablero[y][i] = flag;
        i++;
      }
    }
  }

  private static void diagonal(LinkedList<Character> palabra, int x, int y, byte flag){
    int limup = y, limdown = y, limder = x, limizq = x;
    int aux = palabra.indexOf(arr[limdown].charAt(limder));
    while (aux != -1) {
      palabra.remove(aux);
      limder++;
      limdown++;
      if(limdown == l || limder == c)
        break;
      aux = palabra.indexOf(arr[limdown].charAt(limder));
    }
    limup--;
    limizq--;
    if(y > 0 && x > 0) {
      aux = palabra.indexOf(arr[limup].charAt(limizq));
      while (aux != -1) {
        palabra.remove(aux);
        limup--;
        limizq--;
        if (limup == -1 || limizq == -1)
          break;
          aux = palabra.indexOf(arr[limup].charAt(limizq));
      }
    }
    if (palabra.isEmpty()) {
      limup++;
      limizq++;
      while (limup < limdown){
        if(tablero[limup][limizq] > 0 && tablero[limup][limizq] != flag)
          casillasEspeciales[limup][limizq] = true;
          tablero[limup][limizq] = flag;
          limup++;
          limizq++;
      }
    }
  }

  private static void diagonalInvertida(LinkedList<Character> palabra, int x, int y, byte flag){
    int limup = y, limdown = y, limder = x, limizq = x;
    int aux = palabra.indexOf(arr[limup].charAt(limder));
    while (aux != -1) {
      palabra.remove(aux);
      limder++;
      limup--;
      if(limup == -1 || limder == c)
        break;
      aux = palabra.indexOf(arr[limup].charAt(limder));
    }
    limdown++;
    limizq--;
    if(y < l-1 && x > 0) {
      aux = palabra.indexOf(arr[limdown].charAt(limizq));
      while (aux != -1) {
        palabra.remove(aux);
        limdown++;
        limizq--;
        if (limdown == l || limizq == -1)
          break;
        aux = palabra.indexOf(arr[limdown].charAt(limizq));
      }
    }
    if (palabra.isEmpty()) {
      limup++;
      limder--;
      while (limup < limdown){
        if(tablero[limup][limder] > 0 && tablero[limup][limder] != flag)
          casillasEspeciales[limup][limder] = true;
        tablero[limup][limder] = flag;
        limup++;
        limder--;
      }
    }
  }

  private static void vertical(LinkedList<Character> palabra, int x, int y, byte flag){
    //Checar hacia abajo
    int limup = y, limdown = y;
    int aux = palabra.indexOf(arr[limdown].charAt(x));
    while (aux != -1) {
      palabra.remove(aux);
      limdown++;
      if(limdown == l)
        break;
      aux = palabra.indexOf(arr[limdown].charAt(x));
    }
    limup = y - 1;
    if(y > 0) {
      aux = palabra.indexOf(arr[limup].charAt(x));
      while (aux != -1) {
        palabra.remove(aux);
        limup--;
        if (limup == -1)
          break;
          aux = palabra.indexOf(arr[limup].charAt(x));
      }
    }
    if (palabra.isEmpty()) {
      int i = limup + 1;
      while (i < limdown){
        if(tablero[i][x] > 0 && tablero[i][x] != flag)
          casillasEspeciales[i][x] = true;
          tablero[i][x] = flag;
        i++;
      }
    }
  }

}
