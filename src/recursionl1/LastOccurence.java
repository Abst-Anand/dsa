package src.recursionl1;

public class LastOccurence {

    public static int lastOccurence(int[]arr, int idx, int target){
        if(idx == arr.length) return -1;

        //last occurence in smaller array == liisa
        int liisa = lastOccurence(arr, idx + 1, target); // it will return either the last index of target or -1
        if(liisa != -1) return liisa; // this means that we have already found the last index
        if(arr[idx] == target) return idx; // this means we have got -1 from faith and need to check if remaining item is target, if yes then return this index itself else -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 30, 20, 10};
        int target = 2;
        int res = lastOccurence(arr, 0, target);
        System.out.println(res);
    }
}
