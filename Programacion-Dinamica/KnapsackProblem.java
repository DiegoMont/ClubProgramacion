public class KnapsackProblem {
  public static void main(String[] args) {
    int[] values = {20, 5, 10, 40, 15, 25};
    int[] weights = {1, 2, 3, 8, 7, 4};
    //int[] values = {20, 5, 10};
    //int[] weights = {1, 2, 3};
    int W = 10;
    System.out.println(knapsackProblem(values, weights, W, 0));
    int[][] tablita = new int[W+1][values.length];
    for (int i = 0; i < tablita.length; i++) {
      for (int j = 0; j < tablita[i].length; j++) {
        tablita[i][j] = -1;
      }
    }
    System.out.println(knapsackDynamic(values, weights, W, 0, tablita));
  }

  private static int knapsackProblem(int[] values, int[] weights, int limite, int index){
    if(index == values.length){
      return 0;
    } else if(limite - weights[index] > -1){
      return Math.max(
        knapsackProblem(values, weights, limite-weights[index], index+1) + values[index],
        knapsackProblem(values, weights, limite, index+1)
      );
    } else 
      return 0;
  }

  private static int knapsackDynamic(int[] values, int[] weights, int limite, int index, int[][] tablita){
    if (index == values.length){
      return 0;
    } else if(tablita[limite][index] == -1){
      if(limite - weights[index] > -1) {
      int resultado = Math.max(
        knapsackDynamic(values, weights, limite-weights[index], index+1, tablita) + values[index],
        knapsackDynamic(values, weights, limite, index+1, tablita)
      );
      tablita[limite][index] = resultado;
      } else {
        tablita[limite][index] = 0;
      }
    }
    return tablita[limite][index];
  }

}
