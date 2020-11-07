import java.util.Scanner;

public class ForgottenScore {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); 
    int a = Integer.parseInt(sc.nextLine()), m = Integer.parseInt(sc.nextLine());
    int score = m * 2 - a;
    System.out.println(score);
  }
}
