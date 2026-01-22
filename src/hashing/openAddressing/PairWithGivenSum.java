package src.hashing.openAddressing;

import java.util.HashSet;
public class PairWithGivenSum {
	
	static void naiveFindPair(int[]arr, int sum) {
		
		int flag=0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) { //j=0 may add the same element twice
				if(arr[i]+arr[j] == sum) {
					flag=1;
					break;
				}
			}
		}
		if(flag==1) 
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
	
	static void findPair(int[]arr,int sum) {
		
		HashSet<Integer> s = new HashSet<>();
		for(int e : arr) {
			int diff = sum-e;
			if(s.contains(diff)) {
				System.out.println("Yes");
				return;
			}
			s.add(e);
			
		}
		System.out.println("No");
		
	}

	public static void main(String[] args) {
		
		
		int[]ar = {11,5,6};
		int sum = 10;
		
		naiveFindPair(ar, sum);
		findPair(ar, sum);
	}

}
