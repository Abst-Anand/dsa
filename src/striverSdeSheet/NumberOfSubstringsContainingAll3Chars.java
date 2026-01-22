package striverSdeSheet;

import java.util.HashSet;
import java.util.Set;

public class NumberOfSubstringsContainingAll3Chars {

	static int countSubstrings(String str) {
		int count = 0;
		
		for(int i=0; i<str.length(); i++) {
			Set<Character> chars = new HashSet<>();
			for(int j=i; j<str.length(); j++) {
				chars.add(str.charAt(j));
				if(chars.size() == 3) {
					count++;
				}
			}
		}
		System.out.println("count=" + count);
		
		return count;
	}
	
	static int countSubstringsOptimal(String str) {
		int count = 0;
		int[] lastSeen = {-1, -1, -1};
		
		for(int i=0; i<str.length(); i++) {
			lastSeen[str.charAt(i) - 'a'] = i;
			
//			if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
				int abMin = Math.min(lastSeen[0], lastSeen[1]);
				int min = Math.min(abMin, lastSeen[2]);
				count += min + 1;
//			}
		}
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
		String str = "bbacba";
		countSubstrings(str);
		countSubstringsOptimal(str);
	}
}
