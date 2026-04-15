package src.recursionl1;

import java.util.ArrayList;
import java.util.Collections;

public class Revision {

        // array questions
    static void displayReverse(int[] arr ,int idx){
        if(idx >= arr.length) return;
        displayReverse(arr, idx + 1);
        System.out.print(arr[idx] + " ");
    }

    static int max(int[] arr, int idx){
        if(idx >= arr.length) return Integer.MIN_VALUE;

        int maxSoFar = max(arr, idx + 1);

        return Math.max(arr[idx], maxSoFar);
    }

    static int firstOcc(int[] arr, int idx, int target){
        if(idx >= arr.length) return -1;

        if(arr[idx] == target){
            return idx;
        }

        return firstOcc(arr, idx + 1, target);
    }

    static int lastOcc(int[] arr, int idx, int target){
        if(idx >= arr.length) return -1;

        int lo = lastOcc(arr, idx+1, target);
        if(lo != -1) return lo;

        if(arr[idx] == target) return idx;
        return -1;
    }

    static void allOcc(int[] arr, int idx, int target, ArrayList<Integer> res){
        if(idx >= arr.length) return;

        if(arr[idx] == target){
            res.add(idx);
        }

        allOcc(arr, idx+1, target, res);
    }


    // subsequence questions
    static ArrayList<String> findSubSeq(String str){
        if(str.length() == 0){
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        char ch = str.charAt(0);
        String restOfString = str.substring(1);

        ArrayList<String> subseqWithRestOfString = findSubSeq(restOfString);

        ArrayList<String> res = new ArrayList<>();
        for (String s : subseqWithRestOfString){
            res.add("" + s);
            res.add(ch + s);
        }

        return res;
    }

    private static String[] keypad = {",;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    static ArrayList<String> keypadCombinations(String str){
        if(str.length() == 0){
            ArrayList<String> b = new ArrayList<>();
            b.add("");
            return b;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> kcros = keypadCombinations(ros);

        ArrayList<String> res = new ArrayList<>();

        String code = keypad[Character.getNumericValue(ch)];

        for(int i=0; i<code.length(); i++){
            char c = code.charAt(i);
            for(String s :kcros){
                res.add(c + s);
            }

        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {30, 2, 30, 4 , 30};
        displayReverse(arr, 0);
        System.out.println();
        System.out.println(max(arr, 0));

        int target = 30;
        System.out.println(firstOcc(arr, 0, target));
        System.out.println(lastOcc(arr, 0, target));

        ArrayList<Integer> res = new ArrayList<>();
        allOcc(arr, 0, target, res);
        System.out.println(res);

        String str = "abc";
        ArrayList<String> ssres = findSubSeq(str);
        System.out.println(ssres);

        ArrayList kcres = keypadCombinations("678");
        System.out.println(kcres);
    }
}
