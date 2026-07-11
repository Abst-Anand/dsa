package src.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Main2 {

    // Q3: Find number of anagrams of @param pattern present in @param str
    static int findNumberOfAnagrams(String str, String pattern){
        int count = 0;

        int windowSize = pattern.length();
        Map<Character, Integer> freq = new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            int charFreq = freq.getOrDefault(pattern.charAt(i), 0);
            freq.put(pattern.charAt(i), charFreq+1);
        }

        int distinctChars = freq.size();

        int i=0, j=0;

        while(j < str.length()){
            Integer temp = freq.get(str.charAt(j));
            if(temp != null){
                temp--;
                freq.put(str.charAt(j), temp);
                if(temp == 0)
                    distinctChars--;
            }

            if(j-i+1 == windowSize){
                if(distinctChars == 0){
                    count++;
                }
                Integer removeTemp = freq.get(str.charAt(i));
                if(removeTemp != null){
                    if(removeTemp == 0)
                        distinctChars++;
                    freq.put(str.charAt(i), removeTemp+1);
                }
                i++;
            }
            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "abxuabcabcaby";
        String prt = "abc";
        int res = findNumberOfAnagrams(str, prt);
        System.out.println(res);
    }
}
