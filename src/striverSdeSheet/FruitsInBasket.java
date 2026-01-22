package src.striverSdeSheet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsInBasket {
	
	static int naiveSolution(int[] arr) {
		int maxLen = 0;
		int start =0, end =0;
		for(int i=0; i<arr.length; i++) {
			Set<Integer> types = new HashSet<>();
			
			for(int j=i; j<arr.length; j++) {
				types.add(arr[j]);
				if(types.size() <= 2) {
					int len = j-i+1;
					if(len > maxLen) {
						maxLen = len;
						start = i;
						end = j;
					}
				}
			}
		}
		System.out.println(start + ", " + end);
		System.out.println(maxLen);
		return maxLen;
	}
	
	static int optimalSolution(int[] arr) {
		int left = 0;
		int right = 0;
		int maxLen = 0;
		int start = 0;
		int end = 0;
		Map<Integer, Integer> freq = new HashMap<>();
		
		while(right < arr.length) {
			int currentFreq = freq.getOrDefault(arr[right], 0);
			freq.put(arr[right], currentFreq + 1);
			
			if(freq.size() <= 2) {
				int len = right - left + 1;
				if(len > maxLen) {
					maxLen = len;
					start = left;
					end = right;
				}
			}
			else {
				int leftFreq = freq.get(arr[left]);
				leftFreq--;
				freq.put(arr[left], leftFreq);
				if(leftFreq == 0) {
					freq.remove(arr[left]);
				}
				left = left + 1; 
			}
			right++;
		}
		System.out.println(start + ", " + end);
		System.out.println(maxLen);
		return maxLen;
	}

	public static void main(String[] args) {
		
		int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
		naiveSolution(arr);
		optimalSolution(arr);

	}

}
