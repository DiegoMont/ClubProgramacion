import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int alcance = sc.nextInt(); sc.nextLine();
    int n = sc.nextInt(); sc.nextLine();
    int[][] coordenadas = new int[n][2];
    int[] limites = new int[4];
    for (int i = 0; i < n; i++) {
      coordenadas[i][0] = sc.nextInt();
      if (limites[1] < coordenadas[i][0]) limites[1] = coordenadas[i][0];
      else if (limites[3] > coordenadas[i][0]) limites[3] = coordenadas[i][0];
      coordenadas[i][1] = sc.nextInt(); sc.nextLine();
      if (limites[0] < coordenadas[i][1]) limites[0] = coordenadas[i][1];
      else if (limites[2] > coordenadas[i][1]) limites[2] = coordenadas[i][1];
    }
    char[][] resultado = new char[limites[0]-limites[2]+1][limites[1]-limites[3]+1];
    for (int i = 0; i < coordenadas.length; i++) {
      int normalX = coordenadas[i][0] - limites[3];
      int normalY = limites[0] - coordenadas[i][1];
      resultado[normalY][normalX] = Math.sqrt(Math.pow(coordenadas[i][0], 2) + Math.pow(coordenadas[i][1], 2)) > alcance ? 'x': '+';
      if (coordenadas[i][1] > 0) {
          if (coordenadas[i][0] > 0) {
            for (int j = normalY; j <= limites[0]; j++) {
            for (int k = normalX; k > -limites[3]; k--) {
              if (resultado[j][k] != 'x' && resultado[j][k] != '+') resultado[j][k] = 'o';
            }
            }
          } else {
            for (int j = normalY; j < limites[0]; j++) {
            for (int k = normalX; k <= -limites[3]; k++) {
              if (resultado[j][k] != 'x' && resultado[j][k] != '+') resultado[j][k] = 'o';
            }
          }
          }
      } else {
          if (coordenadas[i][0] > 0) {
            for (int j = normalY; j > limites[0]; j--) {
            for (int k = normalX; k >= -limites[3]; k--) {
              if (resultado[j][k] != 'x' && resultado[j][k] != '+') resultado[j][k] = 'o';
            }
          }
          } else {
            for (int j = normalY; j >= limites[0]; j--) {
            for (int k = normalX; k < -limites[3]; k++) {
              if (resultado[j][k] != 'x' && resultado[j][k] != '+') resultado[j][k] = 'o';
            }
          }
          }
      }
      if(coordenadas[i][0] == 0 && coordenadas[i][1] < 0){
        for (int j = normalY; j >= limites[0]; j--) {
          if (resultado[j][-limites[3]] != 'x' && resultado[j][-limites[3]] != '+') resultado[j][-limites[3]] = 'o';
        }
      }
      if(coordenadas[i][1] == 0 && coordenadas[i][0] > 0){
        for (int k = normalX; k >= -limites[3]; k--) {
          if (resultado[limites[0]][k] != 'x' && resultado[limites[0]][k] != '+') resultado[limites[0]][k] = 'o';
        }
      }
    }
    resultado[limites[0]][-limites[3]] = '#';
    for (int i = 0; i < resultado.length; i++) {
      for (int j = 0; j < resultado[0].length; j++) {
        System.out.print(Character.toString(resultado[i][j]));
      }
      System.out.println();
    }
  }
}
