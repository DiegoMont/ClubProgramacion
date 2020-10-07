public class LongestCommonSubstring {
  public static void main(String[] args){
    String x = "ABABC", y = "BABCA";
    System.out.println(LCS(x, y));
    x = "ABAB";
    y = "BABA";
    System.out.println(LCS(x, y));
  }

  public static int LCS(String x, String y){
    int[][] tablita = new int[x.length()][y.length()];
    int maxLength = 0;
    for (int i = 0; i < tablita.length; i++) {
      for (int j = 0; j < tablita[i].length; j++) {
        int subAnterior = 0;
        if (i-1 > -1 && j-1 > -1) {
          subAnterior = tablita[i-1][j-1];
        }
        tablita[i][j] = (x.charAt(i) == y.charAt(j)) ? subAnterior + 1: 0;
        maxLength = Math.max(maxLength, tablita[i][j]);
      }
    }
    return maxLength;
  }
}