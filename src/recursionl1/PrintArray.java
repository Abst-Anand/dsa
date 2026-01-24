package src.recursionl1;

public class PrintArray {

    public static void printArray(int[] arr, int idx){
        if(idx == arr.length) return;
        System.out.println(arr[idx]);
        printArray(arr, idx + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5,79};
        printArray(arr, 0);
    }
}
