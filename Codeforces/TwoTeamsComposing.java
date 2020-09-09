/*Two teams composing
You have n students under your control and you have to compose exactly two teams consisting of some subset of your students. Each student had his own skill, the i-th student skill is denoted by an integer ai (different students can have the same skills).
So, about the teams. Firstly, these two teams should have the same size. Two more constraints:
  * The first team should consist of students with distinct skills (i.e. all skills in the first team are unique).
  * The second team should consist of students with the same skills (i.e. all skills in the second team are equal).
Note that it is permissible that some student of the first team has the same skill as a student of the second team.
Consider some examples (skills are given):
  * [1, 2, 3], [4, 4] is not a good pair of teams because sizes should be the same;
  * [1, 1, 2], [3, 3, 3] is not a good pair of teams because the first team should not contain students with the same skills;
  * [1, 2, 3], [3, 4, 5] is not a good pair of teams because the second team should contain students with the same skills;
  * [1, 2, 3][3, 3, 3] is a good pair of teams;
  [5], [6] is a good pair of teams.
Your task is to find the maximum possible size x for which it is possible to compose a valid pair of teams, where each team size is x (skills in the first team needed to be unique, skills in the second team should be the same between them). A student cannot be part of more than one team.
You have to answer t independent test cases.
INPUT
The first line of the input contains one integer t (1 <= t <= 10^4) — the number of test cases. Then t test cases follow.
The first line of the test case contains one integer n (1 <= n <= 2*10^5) — the number of students. The second line of the test case contains n integers a1,a2,...,an (1 <= ai <= n), where ai is the skill of the i-th student. Different students can have the same skills.
It is guaranteed that the sum of n over all test cases does not exceed 2 * 10^5 (En <= 2 * 10^5).
OUTPUT
For each test case, print the answer — the maximum possible size x for which it is possible to compose a valid pair of teams, where each team size is x.
SAMPLE INPUT
4
7
4 2 4 1 4 3 4
5
2 1 5 4 3
1
1
4
1 1 1 3
SAMPLE OUTPUT
3
1
0
2
*/
import java.util.HashMap;
import java.util.Scanner;

public class TwoTeamsComposing {
  public static void main(String[] args){
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
      int integrantesDiferentes = estudiantes.size();
      if (integrantesDiferentes == maxEstudiantes) {
        x = maxEstudiantes - 1;
      } else {
        x = Math.min(maxEstudiantes, integrantesDiferentes);
      }
      System.out.println(x);
    }
    sc.close();
  }
}