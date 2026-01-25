package src.recursionl1;

import java.util.ArrayList;

public class KeypadCombination {

    private static String[] keypad = {",;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> getAllKeypadCombinations(String keyStrokes){
        if(keyStrokes.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> smallCombinations = getAllKeypadCombinations(keyStrokes.substring(1));
        String keys = keypad[Character.getNumericValue(keyStrokes.charAt(0))];

        ArrayList<String> ans = new ArrayList<>();

        for(String sc : smallCombinations){
            for(int i=0; i<keys.length(); i++){
                char ch = keys.charAt(i);
                ans.add(ch + sc);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String keyStrokes = "567";

        ArrayList<String> res = getAllKeypadCombinations(keyStrokes);
        System.out.println(res);
    }
}
