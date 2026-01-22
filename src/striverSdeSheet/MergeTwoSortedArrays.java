package striverSdeSheet;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	
	static void merge(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		
		int left = n-1;
		int right = 0;
		while(left >= 0 && right < m) {
			if(arr1[left] > arr2[right]) {
				int temp = arr1[left];
				arr1[left] = arr2[right];
				arr2[right] = temp;
			}
			left--;
			right++;
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}

	public static void main(String[] args) {
		
		int[] arr1 = {1,3,5};
		int[] arr2 = {-8,2,4};
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		merge(arr1,arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

	}

}
