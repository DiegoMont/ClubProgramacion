public class MaximizeEspression {
  public static void main(String[] args) {
    int[] A = {3, 9, 10, 1, 30, 40};
    System.out.println(ME(A));
    System.out.println(MEDynamic(A));
  }

  private static int ME(int[] A){
    int maxExpresion = Integer.MIN_VALUE;
    final int n = A.length;
    for (int i = n-1; i > 2; i--) {
      for(int j = i-1; j > 1; j--){
        for(int k = j-1; k > 0; k--){
          for(int l = k-1; l > -1; l--){
            maxExpresion = Math.max(maxExpresion, A[i] - A[j] + A[k] - A[l]);
          }
        }
      }
    }
    return maxExpresion;
  }

  private static int MEDynamic(int[] A){
    int[][] tabla = new int[4][A.length];
    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        tabla[i][j] = Integer.MIN_VALUE;
      }
    }
    int maxNum = A[A.length-1];
    tabla[0][A.length-1] = maxNum;
    for(int i = A.length-2; i > 2; i--){
      maxNum = Math.max(maxNum, A[i]);
      tabla[0][i] = maxNum;
    }
    for(int i = A.length-2; i > 1; i--){
      tabla[1][i] = Math.max(tabla[1][i+1], tabla[0][i+1] - A[i]);
    }
    for(int i = A.length-3; i > 0; i--){
      tabla[2][i] = Math.max(tabla[2][i+1], tabla[1][i+1] + A[i]);
    }
    for(int i = A.length-4; i > -1; i--){
      tabla[3][i] = Math.max(tabla[3][i+1], tabla[2][i+1] - A[i]);
    }

    /*for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        System.out.print(tabla[i][j] + " ");
      }
      System.out.println(" ");
    }*/
    return tabla[3][0];
  }

}
