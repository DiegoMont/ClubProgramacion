/*
EXAM
You and your friend have just taken a True/False exam. Your friend has been to see the instructor, so they know how many answers they got right (but not which ones). You compare notes: you know your answers and your friend's answers. What is the maximum number of answers you could have gotten right?
INPUT
Each input will consist of a single test case. Note that your program may be run multiple times on different inputs.
Each test case will begin with a line containing a single integer N (0 <= N <= 1,000), which is the number of answers your friend got right on the exam.
Each of the next two lines will contain a string S (max[N,1] <= |S| <= 1,000, S E {T,F}*). The two strings will be of the same length. The first line represents your answers; the second line represents your friend's answers. The order of answers is the same in both strings: the first letter is the answer to question 1, the second to question 2, and so on.
OUTPUT
Output a single integer, which is the maximum number of answers you could have gotten right.
SAMPLE INPUT
3
FTFFF
TFTTT
SAMPLE OUTPUT
2
SAMPLE INPUT
6
TTFTFFTFTF
TTTTFFTTTT
SAMPLE OUTPUT
9
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class E {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner sc = new Scanner(new File("input.txt"));
    int correctas = sc.nextInt(); sc.nextLine();
    String respuestas = sc.nextLine();
    String respuestasAmigo = sc.nextLine();
    int iguales = 0;
    int diferentes = 0;
    for (int i = 0; i < respuestas.length(); i++) {
      if (respuestas.charAt(i) == respuestasAmigo.charAt(i)) {
        iguales++;
      } else
        diferentes++;
    }

    if(correctas < iguales) {
      System.out.println(correctas + diferentes);
    } else {
      System.out.println(iguales + diferentes - (correctas - iguales));
    }
    sc.close();
  }
}
