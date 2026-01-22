package src.hashing.openAddressing;

import java.util.ArrayList;
import java.util.HashMap;


public class LongestSubArrayWithGivenSum {
	
	static void naiveLongestSubArray(int[]arr,int sum) {
		
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			int currSum = 0;
			
			for(int j=i;j<arr.length;j++) {
				currSum += arr[j];
				
				if(currSum == sum) {
					x.add(i);
					y.add(j);
				}
				
			}
		}
		
		int diff = y.get(0)- x.get(0);
		int ind =0;
		for(int i=0;i<x.size();i++) {
			if(diff < y.get(i)- x.get(i)) {
				ind++;
				diff = y.get(i) - x.get(i);
			}
//			System.out.print(x.get(i) + " , " + y.get(i));
//			System.out.println();
		}
		diff++;
		System.out.println("Longest SubArray is from : " + x.get(ind) + " to " + y.get(ind));
		System.out.println("Length:"+ diff);
		
		
	}
	
	static void longestSubArray(int[] arr, int sum) {
		
		HashMap<Integer,Integer> h = new HashMap<>();
		ArrayList<Integer> x = new ArrayList<>();
		
		int currSum=0;
		
		for(int i=0;i<arr.length;i++) {
			currSum += arr[i];
			
			if(!h.containsKey(currSum)) {
				h.put(currSum, i);
			}
			
			if(h.containsKey(currSum)) {
				
				continue;
				
			}
			
		}
		System.out.println(h);
	}

	public static void main(String[] args) {
		
		
		int[]a = {5,8,-4,4,9,-2,2};
		naiveLongestSubArray(a, 13);
		longestSubArray(a, 13);

	}

}
