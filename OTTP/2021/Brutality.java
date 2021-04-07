/*
You are playing a new famous fighting game: Kortal Mombat XII. You have to perform a brutality on your opponent's character.
You are playing the game on the new generation console so your gamepad have 26 buttons. Each button has a single lowercase Latin letter from 'a' to 'z' written on it. All the letters on buttons are pairwise distinct.
You are given a sequence of hits, the i-th hit deals ai units of damage to the opponent's character. To perform the i-th hit you have to press the button si on your gamepad. Hits are numbered from 1 to n.
You know that if you press some button more than k times in a row then it'll break. You cherish your gamepad and don't want to break any of its buttons.
To perform a brutality you have to land some of the hits of the given sequence. You are allowed to skip any of them, however changing the initial order of the sequence is prohibited. The total damage dealt is the sum of ai over all i for the hits which weren't skipped.
Note that if you skip the hit then the counter of consecutive presses the button won't reset.
Your task is to skip some hits to deal the maximum possible total damage to the opponent's character and not break your gamepad buttons.
INPUT
The first line of the input contains two integers n and k (1<=k<=n<=200000) — the number of hits and the maximum number of times you can push the same button in a row.
The second line of the input contains n integers a1,a2,...,an (1<=ai<=10^9), where ai is the damage of the i-th hit.
The third line of the input contains the string s consisting of exactly n lowercase Latin letters — the sequence of hits (each character is the letter on the button you need to press to perform the corresponding hit).
OUTPUT
Print one integer dmg — the maximum possible damage to the opponent's character you can deal without breaking your gamepad buttons.
SAMPLE INPUT
8 1
10 15 2 1 4 8 15 16
qqwweerr
SAMPLE OUTPUT
41
*/
import java.util.PriorityQueue;
import java.util.Scanner;

public class Brutality {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt(); sc.nextLine();
    int[] a = new int[n];
    for(int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    sc.nextLine();
    long resultado = 0;
    String s = sc.nextLine();
    char checkingLetter = s.charAt(0);
    long acumulado = 0;
    int presses = 0;
    int p1 = 0;
    for(int i = 0; i < n; i++){
      char currentLetter = s.charAt(i);
      if(currentLetter != checkingLetter){
        if(presses > k){
          //System.out.println(String.format("acumulado exceso: %d", acumulado));
          PriorityQueue<Integer> queue = new PriorityQueue<>();
          for(; p1 < i; p1++)
            queue.add(-a[p1]);
          acumulado = 0;
          for(int j = 0; j < k; j++)
            acumulado -= queue.poll();
          //System.out.println(String.format("acumulado exceso: %d", acumulado));
        }
        resultado += acumulado;
        checkingLetter = currentLetter;
        acumulado = a[i];
        presses = 1;
        p1 = i;
      } else {
        presses++;
        acumulado += a[i];
      }
    }
    //Para el ultimo elemento
    if(presses > k){
      //System.out.println(String.format("acumulado exceso: %d", acumulado));
      PriorityQueue<Integer> queue = new PriorityQueue<>();
      for(; p1 < n; p1++)
        queue.add(-a[p1]);
      acumulado = 0;
      for(int j = 0; j < k; j++)
        acumulado -= queue.poll();
      //System.out.println(String.format("acumulado exceso: %d", acumulado));
    }
    resultado += acumulado;

    System.out.println(resultado);
  }
}
