package src.striverSdeSheet.twoPointer;

// TODO count number of sub arrays which contain k odd numbers
public class CountNiceSubarrays {

	static int countNiceSubarrays(int[]arr, int k) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			int oddNumCount = 0;
			
			for(int j=i; j<arr.length; j++) {
				if(arr[j] % 2 == 1) {
					oddNumCount++;
				}
				if(oddNumCount == k) {
					count++;
				}
			}
		}
		System.out.println(count);
		return count;	
	}
	
	static int countNiceSubarraysOptimal(int[]arr, int k) {
		int count = 0;
		int left = 0;
		int right = 0;
		int oddNumsCount = 0;
		while(right < arr.length) {
			if(arr[right] % 2 == 1) {
				oddNumsCount++;
			}
			
			if(oddNumsCount <= k) {
				count+= right-left +1;
			}
			else  {
				if(arr[left] % 2 == 1)
					oddNumsCount--;
				left++;
			}
			
			right++;
		}
		System.out.println(count);
		return count;
	}
	public static void main(String[] args) {
		
		int[] arr = {1,1,2,1,1};
		int k = 3;
		countNiceSubarrays(arr, k);
		countNiceSubarraysOptimal(arr, k);

	}

}
