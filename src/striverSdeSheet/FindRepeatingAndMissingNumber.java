package src.striverSdeSheet;

import java.util.Arrays;

public class FindRepeatingAndMissingNumber {
	
	static int[] findRepeatingAndMissingNumbers(int[] arr) {
		int[] res = new int[2];
		int[] temp = new int[arr.length +1];
		
		for(int i=0; i<arr.length; i++) {
			temp[arr[i]]++;
		}
		
		for(int i=1; i<temp.length; i++) {
			if(temp[i] == 0) {
				res[1] = i;
			}
			if(temp[i] == 2) res[0] = i;
		}
		
		
		return res;
	}

	public static void main(String[] args) {

		int[] arr = {3,1,2,5,4,6,7,5};
		
		System.out.println(Arrays.toString(findRepeatingAndMissingNumbers(arr)));

	}

}
