import java.util.Arrays;
import java.util.LinkedList;

public class AllLongestCommonSubsequences {
  private static LinkedList<String>[] arreglo;
  private static int maxLength;
  public static void main(String[] args){
    String X = "XMJYAUZ";
    String Y = "MZJAWXU";
    Y = "ABCBDAB";
    X = "BDCABA";
    //X = "ABCD";
    //Y = "ADCB";
    arreglo = new LinkedList[Math.max(X.length(), Y.length())];
    maxLength = 0;
    ALCS(X, Y, 0, 0, "");
    System.out.println(Arrays.toString(arreglo[maxLength].toArray()));
    System.out.println(ALCSDynamic(X, Y));
  }

  public static String ALCSDynamic(String x, String y){
    LinkedList<String>[][] tablita = new LinkedList[x.length()][y.length()];
    //Llenar primera columna
    for (int i = 0; i < tablita.length; i++) {
      tablita[i][0] = new LinkedList<>();
      if (x.charAt(i) == y.charAt(0)) {
        tablita[i][0].add(Character.toString(x.charAt(i)));
      } else if(i-1 >= 0)
        for (String sub: tablita[i-1][0])
          tablita[i][0].add(sub);
          
    }

    //Llenar primera fila
    for(int i = 1; i < tablita[0].length; i++) {
      tablita[0][i] = new LinkedList<>();
      if (x.charAt(0) == y.charAt(i)) {
        tablita[0][i].add(Character.toString(y.charAt(i)));
      } else
        for(String seq: tablita[0][i-1])
          tablita[0][i].add(seq);
    }

    //Llenar el resto de la tabla
    int maxLength = 0;
    for (int i = 1; i < tablita.length; i++) {
      for (int j = 1; j < tablita[0].length; j++) {
        tablita[i][j] = new LinkedList<>();
        for (String seq : tablita[i-1][j]) {
          tablita[i][j].add(seq);
        }
        for (String seq : tablita[i][j-1]) {
          if(!tablita[i][j].contains(seq)){
            tablita[i][j].add(seq);
          }
        }
        if(x.charAt(i) == y.charAt(j)) {
          for(int k = 0; k < tablita[i][j].size(); k++) {
            String temp = tablita[i][j].get(k) + x.charAt(i);
            tablita[i][j].set(k, temp);
          }
        }
      }
    }

    for(LinkedList[] arreglo: tablita){
      for(LinkedList<String> seqs: arreglo)
        System.out.print(Arrays.toString(seqs.toArray()));
      System.out.println(" ");
    }

    return Arrays.toString(tablita[tablita.length-1][tablita[0].length-1].toArray());
  }

  public static void ALCS(String x, String y, int indiceX, int indiceY, String palabra){
    if (indiceX == x.length() || indiceY == y.length()) {
      if (palabra.length() >= maxLength) {
        maxLength = palabra.length();
        if (arreglo[maxLength] == null) {
          arreglo[maxLength] = new LinkedList<>();
          arreglo[maxLength].add(palabra);
        } else if (!arreglo[maxLength].contains(palabra)){
          arreglo[maxLength].add(palabra);
        }
      }
    } else if (x.charAt(indiceX) == y.charAt(indiceY)) {
      ALCS(x, y, indiceX+1, indiceY+1, palabra + x.charAt(indiceX));
    } else {
      ALCS(x, y, indiceX+1, indiceY, palabra);
      ALCS(x, y, indiceX, indiceY+1, palabra);
      }
  }

}
