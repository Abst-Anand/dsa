package striverSdeSheet;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
	
	static int findDuplicate(int[] arr) {
		Set<Integer> elementSet = new HashSet<>();
		int ans = -1;
		
		for(int e : arr) {
			if(elementSet.contains(e)) {
				ans = e;
			}else {
				elementSet.add(e);
			}
		}
		
		return ans;
	}
	
	static int findDuplicateOptimal(int[]arr) {
		int slow = arr[0];
		int fast = arr[0];
		
		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
		}while(slow != fast);
		
		slow = arr[0];
		while(slow != fast) {
			slow = arr[slow];
			fast = arr[fast];
		}
		
		return slow;
	}

	public static void main(String[] args) {
		
		int[] arr = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
		System.out.println(findDuplicate(arr));
		
		System.out.println(findDuplicateOptimal(arr));

	}

}
