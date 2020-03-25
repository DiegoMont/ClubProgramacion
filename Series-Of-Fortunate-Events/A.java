import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;

public class A {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner sc = new Scanner(new File("texto.txt"));
    int n = sc.nextInt(); sc.nextLine();
    ArrayList<Integer> animals = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      animals.add(sc.nextInt());
      sc.nextLine();
    }
    Collections.sort(animals);
    int sumRight = 0;
    int sumLeft = 0;
    int indexLeft = 0;
    int indexRight = n - 1;
    while(indexLeft < indexRight){
      sumRight += animals.get(indexRight);
      while(sumLeft < sumRight && indexLeft < indexRight){
        sumLeft += animals.get(indexLeft);
        indexLeft++;
      }
      indexRight--;
    }
    System.out.println(animals.get(indexLeft));
    System.out.println(animals.get(indexRight));
    System.out.println(sumLeft);
    System.out.println(sumRight);
    int t = animals.get(n/2);
    sc.close();
  }
}
