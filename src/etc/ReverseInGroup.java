package src.etc;

import java.util.Arrays;

public class ReverseInGroup {
	
	static int[] reverse(int[] arr) {
		
		int[] brr = new int[arr.length];
		int j=0;
		
		for(int i=arr.length-1;i>=0;i++) {
			brr[j++] = arr[i];
		}
		return brr;		
		
	}
	
	static void display(int[] arr) {
		for(int e: arr) {
			System.out.print(e+" ");
		}
	}
	
	public static void main(String [] aa) {
		
		int arr[] = {10,2,3,4,5,1};
		for(int j=0;j<3;j++) {
		int f = arr[0];
		
		for(int i=1;i<arr.length;i++) {			
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = f;
		}
		
		
		
		
		//arr = reverse(arr,2);
		display(arr);
		
		
		
		
		
	}
 
}
