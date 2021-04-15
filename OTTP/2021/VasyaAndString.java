/*
High school student Vasya got a string of length n as a birthday present. This string consists of letters 'a' and 'b' only. Vasya denotes beauty of the string as the maximum length of a substring (consecutive subsequence) consisting of equal letters.
Vasya can change no more than k characters of the original string. What is the maximum beauty of the string he can achieve?
INPUT
The first line of the input contains two integers n and k (1 <= n <= 100 000, 0 <= k <= n) — the length of the string and the maximum number of characters to change.
The second line contains the string, consisting of letters 'a' and 'b' only.
OUTPUT
Print the only integer — the maximum beauty of the string Vasya can achieve by changing no more than k characters.
SAMPLE INPUT
8 1
aabaabaa
SAMPLE OUTPUT
5
*/
import java.util.ArrayList;
import java.util.Scanner;

public class VasyaAndString {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt(); sc.nextLine();
    String s = sc.next();
    char currentLetter = s.charAt(0);
    int count = 0;
    ArrayList<Integer> lista = new ArrayList<>();
    for(int i = 0; i < n; i++){
      char letter = s.charAt(i);
      if(currentLetter == letter)
        ++count;
      else {
        lista.add(count);
        count = 1;
        currentLetter = letter;
      }
    }
    lista.add(count);
    int countLista = lista.size();
    int resultado = 0;
    if (countLista == 1) {
      resultado = lista.get(0);
    } else if(countLista == 2) {
      int primero = lista.get(0), segundo = lista.get(1);
      resultado = Math.max( primero, segundo) + Math.min(Math.min(primero, segundo), k);
    } else {
      int izq, medio, der;
      izq = lista.get(0);
      medio = lista.get(1);
      resultado = Math.max(medio, izq) + Math.min(Math.min(medio, izq), k);
      for (int i = 2; i < countLista; i++) {
        der = lista.get(i);
        if(k < medio){
          resultado = Math.max(resultado, Math.max(medio, der) + Math.min(Math.min(medio, der), k));
        } else if(k == medio){
          resultado = Math.max(resultado, izq + der + medio);
        } else {
          int total = izq + der + medio;
          int cambiosRestantes = k - medio;
          int j = 1;
          for(; i+j < countLista; j++){
            int elemento = lista.get(j+i);
            if((j & 1) == 0){
              total += Math.min(cambiosRestantes, elemento);
              cambiosRestantes -= elemento;
            } else {
              total += elemento;
              if(cambiosRestantes < 1)
                break;
            }
          }
          //System.out.println(total);
          resultado = Math.max(resultado, total);
          if(i+j == countLista)
            break;
        }
        izq = medio;
        medio = der;
      }
    }
    System.out.println(resultado);
  }
}
