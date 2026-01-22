package src.string;

import java.util.Arrays;

public class LeftmostRepeatingCharacter {
	
	//return index of the leftmost repeating letter given a string

	static int leftmostRepeatIndex(String str) {
		
		int[] arr = new int[256];
		Arrays.fill(arr, 0);
		
		for(int i=0; i<str.length();i++) {
			int ind = (int)str.charAt(i);
			arr[ind]++;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > 1) {
				System.out.println((char)i);
				char ch = (char)i;
				return str.indexOf(ch);
			}
			
		}
		
		return -1;
	}
	
	static int gfgEfficientSolution(String str) {
		
		int res = Integer.MAX_VALUE;
		int[] arr = new int[256];
		Arrays.fill(arr, 0);
		
		for(int i=0;i<str.length();i++) {
			int f = arr[str.charAt(i)];
			if(f == 0)
				arr[str.charAt(i)] = i;
			else
				res = Math.min(res, arr[str.charAt(i)]);
		}
		
		return (res == Integer.MAX_VALUE?-1:res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abccbd";
		int index = leftmostRepeatIndex(s);
		System.out.println(index);
		
		System.out.println(gfgEfficientSolution(s));
	}
	
	
	
   

}
