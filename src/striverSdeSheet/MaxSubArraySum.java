package src.striverSdeSheet;

public class MaxSubArraySum {
	
	static int maxSum(int[] arr) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		int tempStart = -1;
		int start = -1;
		int end = -1;
		
		for(int i=0; i<arr.length; i++) {
			
			sum += arr[i];
			
			if(sum > max) {
				max = sum;
				start = tempStart;
				end = i;
			}
			
			if(sum < 0) {
				sum = 0;
				tempStart = i+1;
			}
		}
		
		System.out.print("The Sub Array giving max sum is: [");
		for(int i=start; i<end; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[end] + "]");
		
		if(max < 0) {
			System.out.println("No positive sum");
			max = 0;
		}
		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
		
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		maxSum(arr);
		

	}

}
