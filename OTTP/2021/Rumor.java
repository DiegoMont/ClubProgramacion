/*
Vova promised himself that he would never play computer games... But recently Firestorm — a well-known game developing company — published their newest game, World of Farcraft, and it became really popular. Of course, Vova started playing it.
Now he tries to solve a quest. The task is to come to a settlement named Overcity and spread a rumor in it.
Vova knows that there are n characters in Overcity. Some characters are friends to each other, and they share information they got. Also Vova knows that he can bribe each character so he or she starts spreading the rumor; i-th character wants ci gold in exchange for spreading the rumor. When a character hears the rumor, he tells it to all his friends, and they start spreading the rumor to their friends (for free), and so on.
The quest is finished when all n characters know the rumor. What is the minimum amount of gold Vova needs to spend in order to finish the quest?
Take a look at the notes if you think you haven't understood the problem completely.
INPUT
The first line contains two integer numbers n and m (1 <= n <= 100000, 0 <= m <= 100000) — the number of characters in Overcity and the number of pairs of friends.
The second line contains n integer numbers ci (0 <= ci <= 10^9) — the amount of gold i-th character asks to start spreading the rumor.
Then m lines follow, each containing a pair of numbers (xi, yi) which represent that characters xi and yi are friends (1 <= xi, yi <= n, xi != yi). It is guaranteed that each pair is listed at most once.
OUTPUT
Print one number — the minimum amount of gold Vova has to spend in order to finish the quest.
SAMPLE INPUT
10 5
1 6 2 7 3 8 4 9 5 10
1 2
3 4
5 6
7 8
9 10
SAMPLE OUTPUT
15
*/

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Rumor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), m = sc.nextInt(); sc.nextLine();
    int[] c = new int[n];
    long resultado = 0;
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt();
      resultado += c[i];
    }
    if (m == 0){
      System.out.println(resultado);
      return;
    }

    // RELACIONES
    TreeSet<Integer>[] grafo = new TreeSet[n];
    for(int i = 0; i < n; i++)
      grafo[i] = new TreeSet<Integer>();
    resultado = 0;
    for(int i = 0; i < m; i++){
      int x = sc.nextInt()-1, y = sc.nextInt()-1; sc.nextLine();
      grafo[x].add(y);
      grafo[y].add(x);
    }
    boolean[] visitados = new boolean[n];
    for(int i = 0; i < n; i++){
      if(visitados[i])
        continue;
      int costoMenor = Integer.MAX_VALUE;
      LinkedList<Integer> q = new LinkedList<>();
      q.add(i);
      while(!q.isEmpty()){
        int actual = q.poll();
        visitados[actual] = true;
        for (int vecino : grafo[actual])
          if(!visitados[vecino])
            q.add(vecino);
        costoMenor = Math.min(costoMenor, c[actual]);
      }
      resultado += costoMenor;
    }
    //RELACIONES
    
    System.out.println(resultado);
  }

}