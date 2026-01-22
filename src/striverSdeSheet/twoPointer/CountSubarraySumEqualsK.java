package src.striverSdeSheet.twoPointer;

public class CountSubarraySumEqualsK {

	static int countSubArraysWithSumAsK(int[] arr, int k) {
		int count = 0;
		
		for(int i=0; i<arr.length; i++) {
			int currentSum = 0;
			for(int j=i; j<arr.length; j++) {
				currentSum += arr[j];
				if(currentSum == k) {
					count++;
				}
			}
		}
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,0,1,0,1};
		int k = 2;
		countSubArraysWithSumAsK(arr, k);

	}

}
