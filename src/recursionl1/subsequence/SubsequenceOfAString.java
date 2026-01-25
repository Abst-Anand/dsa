package src.recursionl1.subsequence;

import java.util.ArrayList;

public class SubsequenceOfAString {

    public static ArrayList<String> getSubsequence(String str){
        if(str.length() == 0){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }

        char ch = str.charAt(0);
        String ss = str.substring(1);
        ArrayList<String> ssoss = getSubsequence(ss); //sub sequence of smaller string (ssoss)

        ArrayList<String> ans = new ArrayList<>();

        for(String s : ssoss){
            ans.add(s);
            ans.add(ch + s);
        }

        return ans;
    }

    public static void printSubsequence(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        printSubsequence(ros, ans + "");
        printSubsequence(ros, ans + ch);
    }

    public static void main(String[] args) {
        String str = "123";
        ArrayList<String> res = getSubsequence(str);
        System.out.println(res);
        printSubsequence(str, "");
    }
}
