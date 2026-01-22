package hashing.openAddressing;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctElements {

	static int countDistinct(int[] arr) {
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int e : arr)
			set.add(e);
		
		return set.size();
		
//		HashSet<Integer> set2 = new HashSet(Arrays.asList(arr));
//		System.out.println(set2);
//		return set2.size();
	}
	
	public static void main(String[]aa) {
		int[] arr = {15,12,13,12,13,18,15};
		
		System.out.println(countDistinct(arr));
	}
}
