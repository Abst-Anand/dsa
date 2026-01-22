package src.hashing.openAddressing;
import java.util.HashSet;

public class ZeroSumSubArray {
	
	static void naiveZeroSum(int[] arr,int sum) {
		
		for(int i=0;i<arr.length;i++) {
			int currentSum = 0;
			for(int j=i;j<arr.length;j++) {
				currentSum += arr[j];
				if(currentSum == sum) {
					System.out.println("Yes from " + i +" to " + j);
					return;
				}
			}
		}
		System.out.println("No Possible Sub-Array");
	}
	
	static void zeroSum(int[] arr,int sum) {
		HashSet<Integer> s = new HashSet<>();
		
		int cumulativeSum=0;
		for(int i=0;i<arr.length;i++) {
			cumulativeSum += arr[i];
			if(cumulativeSum == sum || s.contains(cumulativeSum-sum)) {
				System.out.println("Yes");
				return;
			}
			s.add(cumulativeSum);
		}
		System.out.println("No");
	}

	
	static void printAllSubArrays(int[]arr) {
		for(int i=0;i<arr.length;i++) {
			//System.out.println(arr[i]);
			for(int j=i;j<arr.length;j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		int[]arr= {10,20,30};
		naiveZeroSum(arr, 30);
		zeroSum(arr, 30);
		//printAllSubArrays(arr);
	}

}
