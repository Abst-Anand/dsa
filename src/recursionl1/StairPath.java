package src.recursionl1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StairPath {

    private static int[] POSSIBLE_JUMPS = {1, 2, 3};

    public static ArrayList<String> getAllPossiblePaths(int src){
        if(src == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if(src < 0) return new ArrayList<String>();

        ArrayList<String> paths1 = getAllPossiblePaths(src - POSSIBLE_JUMPS[0]);
        ArrayList<String> paths2 = getAllPossiblePaths(src - POSSIBLE_JUMPS[1]);
        ArrayList<String> paths3 = getAllPossiblePaths(src - POSSIBLE_JUMPS[2]);

        ArrayList<String> ans = new ArrayList<>();

        for(String path : paths1){
            ans.add("1" + path);
        }
        for(String path : paths2){
            ans.add("2" + path);
        }
        for(String path : paths3){
            ans.add("3" + path);
        }

        return ans;
    }

    public static void main(String[] args) {
        int source = 3;
        ArrayList<String> res = getAllPossiblePaths(source);
        System.out.println(res);
    }
}
