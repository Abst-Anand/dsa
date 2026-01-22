package leetcode;

import java.util.HashMap;

public class TwoSum {
	
	static int[] twoSum(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] res = {-1, -1};
		
		for(int i=0; i<arr.length; i++) {
			int current = target - arr[i];
			if(map.containsKey(current)) {
				res[0] = map.get(current);
				res[1] = i;
			}
			else {
				map.put(arr[i], i);
			}
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,8,15,2,1};
		int targetSum = 13;
		
		int[] res = twoSum(arr, targetSum);
		System.out.println(res[0] + ", " + res[1]);
	}
	

}
