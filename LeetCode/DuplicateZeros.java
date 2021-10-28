import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        //int[] arreglo = {1,0,2,3,0,4,5,0};
        int[] arreglo = {-4,0,7,4,9,-5,-1,0,-7,-1};
        Solution s = new Solution();
        s.duplicateZeros(arreglo);
        System.out.println(Arrays.toString(arreglo));
    }
}

class Solution {
    public void duplicateZeros(int[] arr) {
        int[] arregloDuplicado = new int[arr.length];
        int i = 0;
        for(int valor: arr){
            if(i == arr.length)
                break;
            arregloDuplicado[i] = valor;
            i++;
            if(valor == 0 && i < arr.length){
                arregloDuplicado[i] = 0;
                i++;
            }
        }
        for(i = 0; i < arr.length; i++)
            arr[i] = arregloDuplicado[i];
    }
}
