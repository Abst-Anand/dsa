package striverSdeSheet;

import java.util.Arrays;

public class SortInPlace {

	static void sortInPlace(int[] arr) {
		// arr contains only 0's, 1's and 2
		int left = 0;
		int mid = 0;
		int right = arr.length -1;
		
		while(mid <= right) {
			
			if(arr[mid] == 0) {
				int temp = arr[left];
				arr[left] = arr[mid];
				arr[mid] = temp;
				left++;
				mid++;				
			}
			
			else if(arr[mid] == 1) {
				mid++;				
			}
			
			else {
				int temp = arr[right];
				arr[right] = arr[mid];
				arr[mid] = temp;
				right--;
			}
			
		}
		
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,0,2,1,1,0};
		sortInPlace(arr);

	}

}
