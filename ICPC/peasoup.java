import java.util.Scanner;

public class peasoup {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); sc.nextLine();
    for (int i = 0; i < n; i++) {
      int k = Integer.parseInt(sc.nextLine());
      String nombre = sc.nextLine();
      boolean hasPancakes = false, hasPeaSoup = false;
      for (int j = 0; j < k; j++) {
        String platillo = sc.nextLine();
        hasPeaSoup = hasPeaSoup || platillo.contains("pea soup");
        hasPancakes = hasPancakes || platillo.contains("pancakes");
      }
      if (hasPeaSoup && hasPancakes) {
        System.out.println(nombre);
        return;
      }
    }
    System.out.println("Anywhere is fine I guess");
  }
}