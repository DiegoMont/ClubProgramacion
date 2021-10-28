import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] arreglo = {5,3,7,6,-5,2,1,4,3};
        //int[] arreglo = {-4,0,7,4,9,-5,-1,0,-7,-1};
        Solution s = new Solution();
        s.sortArray(arreglo);
        System.out.println(Arrays.toString(arreglo));
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        return nums;       
    }

    private void quicksort(int[] nums, int izq, int der){
        int index = partition(nums, izq, der);
        if(izq < index - 1)
            quicksort(nums, izq, index - 1);
        if(index < der)
            quicksort(nums, index, der);
    }

    private int partition(int[] arr, int i, int j){
        int pivot = arr[(i + j) / 2];
        while(i <= j){
            while(arr[i] < pivot)
                i++;
            while(arr[j] > pivot)
                j--;
            if(i <= j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    private void swap(int[] arr, int i, int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
