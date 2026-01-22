package striverSdeSheet;

public class MaxConsecutiveOnes {

	static int maxConsecutiveOnes(int[] arr, int k) {
		int maxLen = 0;
		int start = 0;
		int end = 0;
		
		for(int i=0; i<arr.length; i++) {
			int zeroes = 0;
			
			for(int j=i; j<arr.length; j++) {
				if(arr[j] == 0) {
					zeroes++;
				}
				
				if(zeroes <=k) {
					int len = j - i + 1;
					if(len > maxLen) {
						start = i;
						end = j;
						maxLen = len;
					}
				}else {
					break;
				}
			}
			
		}
		System.out.println(start + ", " + end);

		return maxLen;
	}
	
	static void maxConsecutiveOnesOptimal(int[] arr, int k) {
		// approach: find max subArray such that at least k zeros are there.
		int left = 0;
		int right = 0;
		int maxLen = 0;
		int zeros = 0;
		int start = 0;
		int end = 0;
		
		while(right < arr.length) {
			if(arr[right] == 0) {
				zeros++;
			}
			
			if(zeros <= k) {
				int len = right - left + 1;
				if(len >= maxLen) {
					maxLen = len;
					start = left;
					end = right;
				}
			}
			else {
				if(arr[left] == 0) zeros--;
				left++;
			}
			right++;
		}
		System.out.println(start + ", " + end);
		System.out.println(maxLen);
	}
	
	public static void main(String[] args) {

		int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
		System.out.println(maxConsecutiveOnes(arr,2));
		
		System.out.println();
		maxConsecutiveOnesOptimal(arr, 2);

	}

}
