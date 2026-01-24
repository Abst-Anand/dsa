package src.recursionl1;

public class FirstOccurence {

    public static int firstOccurance(int[] arr, int idx, int target){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == target) return idx;
        return firstOccurance(arr, idx + 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {11,76, 7, 89, 6, 7, 90};
        int target = 7;
        int res = firstOccurance(arr, 0, target);
        System.out.println(res);
    }
}
