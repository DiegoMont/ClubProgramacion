import java.util.Hashtable;

class SubsetSumProblem {

private static boolean subsetExists(int[] set, int sum, int n, int index){
  if(sum == 0){
    return true;
  } else if(index == n || sum < 0){
    return false;
  } else {
    return subsetExists(set, sum, n, index+1) || subsetExists(set, sum-set[index], n, index+1);
  }
}

private static boolean subsetExistsDynamic(int[] set, int sum, int n, int index, Hashtable<String, Boolean> tabla){
  if (sum == 0) {
    return true;
  } else if(index == n || sum < 0){
    return false;
  } else if(!tabla.containsKey(sum + " " + index)){
    boolean toBe = subsetExistsDynamic(set, sum-set[index], n, index+1, tabla);
    boolean notToBe = subsetExistsDynamic(set, sum, n, index+1, tabla);
    tabla.put(sum + " " + index, toBe || notToBe);
  }
  return tabla.get(sum + " " + index);
}

public static void main(String[] args){
  int[] set = {7, 3, 2, 5, 8};
  int sum = 14;
  if(subsetExists(set, sum, set.length, 0)){
    System.out.println("True");
  } else {
    System.out.println("False\n");
  }
  System.out.println(subsetExistsDynamic(set, sum, set.length, 0, new Hashtable<>()));
}
}
