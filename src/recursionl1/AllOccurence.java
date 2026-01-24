package src.recursionl1;

import java.util.ArrayList;

public class AllOccurence {

    public static void allOccurences(int[] arr, int idx, int target, ArrayList<Integer> result){
        if(idx == arr.length) return;
        if(arr[idx] == target) result.add(idx);
        allOccurences(arr, idx + 1, target, result);
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 66, 12, 12, 87};
        int target = 12;
        ArrayList<Integer> res = new ArrayList<>();
        allOccurences(arr, 0, target, res);
        System.out.println(res);
    }
}
