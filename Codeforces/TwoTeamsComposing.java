import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class TwoTeamsComposing {
  public static void main(String[] args) throws FileNotFoundException{
    //Scanner sc = new Scanner(new File("input.txt"));
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    for (int g = 0; g < t; g++) {
      int n = Integer.parseInt(sc.nextLine());
      HashMap<Integer, Integer> estudiantes = new HashMap<>();
      int maxEstudiantes = 1;
      for (int i = 0; i < n; i++) {
        int a = sc.nextInt();
        if (estudiantes.containsKey(a)) {
          int cuenta = estudiantes.get(a)+1;
          estudiantes.put(a, cuenta);
          if (cuenta > maxEstudiantes) {
            maxEstudiantes = cuenta;
          }
        } else {
          estudiantes.put(a, 1);
        }
      }
      sc.nextLine();

      int x = 0;
      int integrantesDiferentes = estudiantes.size() - 1;
      //System.out.println(integrantesDiferentes);
      //System.out.println(maxEstudiantes);
      if (integrantesDiferentes == maxEstudiantes) {
        x = maxEstudiantes;
      } else {
        maxEstudiantes--;
        integrantesDiferentes++;
        if (maxEstudiantes == integrantesDiferentes) {
          x = maxEstudiantes;
        } else if (n > 1) {
          x = Math.min(maxEstudiantes > 0 ? maxEstudiantes: 1, integrantesDiferentes);
        }
      }
      System.out.println(x);
    }
    sc.close();
  }
}