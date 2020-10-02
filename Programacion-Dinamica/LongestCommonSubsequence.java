public class LongestCommonSubsequence {
  public static void main(String[] args){
    String X = "abac";
    String Y = "daea";
    
    final int lengthX = X.length(), lengthY = Y.length();
    int resultado = LCS(X, Y, lengthX, lengthY);
    System.out.println(String.format("%d", resultado));
    int[][] tablita = new int[lengthX + 1][lengthY + 1];
    resultado = LCSDinamico(X, Y, lengthX, lengthY, tablita, new boolean[tablita.length][tablita[0].length]);
    System.out.println(String.format("%d", resultado));
  }
  
  private static int LCSDinamico(String x, String y, int lengthX, int lengthY, int[][] tablita, boolean[][] visitados){
    if(visitados[lengthX][lengthY]){
      return tablita[lengthX][lengthY];
    }
    if (lengthX == 0 || lengthY == 0) {
      tablita[lengthX][lengthY] = 0;
    } else if (x.charAt(lengthX-1) == y.charAt(lengthY-1)){
      tablita[lengthX][lengthY] = 1 + LCS(x, y, lengthX - 1, lengthY - 1);
    } else {
      tablita[lengthX][lengthY] = Math.max(LCS(x, y, lengthX, lengthY-1), LCS(x, y, lengthX-1, lengthY));
    }
    visitados[lengthX][lengthY] = true;
    return tablita[lengthX][lengthY];
  }
  
  private static int LCS(String x, String y, int lengthX, int lengthY) {
    if (lengthX == 0 || lengthY == 0) {
      return 0;
    } else if (x.charAt(lengthX-1) == y.charAt(lengthY-1)){
      return 1 + LCS(x, y, lengthX - 1, lengthY - 1);
    } else {
      return Math.max(LCS(x, y, lengthX, lengthY-1), LCS(x, y, lengthX-1, lengthY));
    }
  }
}
