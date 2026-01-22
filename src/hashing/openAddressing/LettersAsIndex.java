package src.hashing.openAddressing;

import java.util.Arrays;

public class LettersAsIndex {
	
	//find freq of each letter from a string in O(1).
	
	public static void main(String[]aa) {
		
		int[] arr = new int[256];
	
		Arrays.fill(arr, 0);
		
		System.out.println( (int)'a' );
		
		String str = "akAK(!&#(*klnkAKJNJ!!NSAAAniuaasf";
		
		for(int i=0;i<str.length();i++) {
			arr[str.charAt(i)]++;	//Letters as index of the array.
		}
		
		char freqOf = '#';
		
		System.out.println(arr[freqOf]);
		
		
	}

}
