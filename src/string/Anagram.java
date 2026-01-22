package string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	
	static boolean isAnagram(String s1,String s2) {
		
		if(s1.length() != s2.length())
			return false;
		
		HashMap<Character,Integer> freq = new HashMap<>();
		
		for(int i=0;i<s1.length();i++) {
			int f = freq.getOrDefault(s1.charAt(i), 0);
			freq.put(s1.charAt(i), f+1);			
		}
		
		for(int i=0;i<s2.length();i++) {
			freq.put(s2.charAt(i), freq.get(s2.charAt(i))-1);
		}
		
		for(Map.Entry<Character, Integer> ent : freq.entrySet()) {
			//System.out.println(ent.getKey() + " " + ent.getValue() );
			if(ent.getValue() != 0)
				return false;
		}
		return true;
		
	}
	
	public static void main(String[]aa) {
		String s1 = "aab";
		String s2 = "bab";
		
		System.out.println(isAnagram(s1, s2));
	}

}
