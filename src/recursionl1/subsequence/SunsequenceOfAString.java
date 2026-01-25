package src.recursionl1.subsequence;

import java.util.ArrayList;
import java.util.List;

public class SunsequenceOfAString {

    public static ArrayList<String> findSubsequence(String str){
        if(str.length() == 0){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }

        char ch = str.charAt(0);
        String ss = str.substring(1);
        ArrayList<String> ssoss = findSubsequence(ss); //sub sequence of smaller string (ssoss)

        ArrayList<String> ans = new ArrayList<>();

        for(String s : ssoss){
            ans.add(s);
            ans.add(ch + s);
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "123";
        ArrayList<String> res = findSubsequence(str);
        System.out.println(res);
    }
}
