//Figure / Sculpture
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r, c;
    r = sc.nextInt();
    c = sc.nextInt();
    int[][] input = new int[r][c];
    //Leer todo el input
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        input[i][j] = sc.nextInt();
      }
      sc.nextLine();
    }
    for (int i = 0; i < c && r > 0; i++) {
      System.out.print("0 ");
    }
    System.out.println("");
    for (int i = 1; i < r-1; i++) {
      System.out.print("0 ");
      for (int j = 1; j < c-1; j++) {
        if (input[i-1][j] > input[i][j] && input[i+1][j] > input[i][j] && input[i][j-1] > input[i][j] && input[i][j+1] > input[i][j]){
          System.out.print("1 ");
        } else {
          System.out.print("0 ");
        }
      }
      System.out.println(c > 2 ? "0": "");
    }
    for (int i = 0; i < c && r > 2; i++) {
      System.out.print("0 ");
    }
    System.out.println("");
    sc.close();
  }
}
