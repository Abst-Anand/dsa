package striverSdeSheet;

import java.util.Arrays;

public class NextPermutation {
	
	static int findBreakPoint(int[]arr) {
		
		int bp = -1;
		
		for(int i = arr.length-2; i>=0 ; i--) {
			if(arr[i] < arr[i+1])
				bp = i;
		}
		return bp;
	}
	
	static void nextPermutation(int[] arr) {
		
		int bp = findBreakPoint(arr);
		System.out.println("bp:" + bp);
		
		if(bp != -1) {
			for(int i = arr.length-1; i>=0; i--) {
				if(arr[i] > arr[bp]) {
					int temp = arr[bp];
					arr[bp] = arr[i];
					arr[i] = temp;
					break;
				}
			}
		}
		
		
		int left = bp+1;
		int right = arr.length -1;
		while(left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		
		System.out.println("after sorting" +Arrays.toString(arr));
	}

	public static void main(String[] args) {
		
		int[] arr = {2, 1, 5, 4, 3, 0, 0};
		nextPermutation(arr);

	}

}
