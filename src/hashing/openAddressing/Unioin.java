package src.hashing.openAddressing;

import java.util.HashSet;


public class Unioin {
	
	static void union(int[]arr,int[]brr) {
		HashSet<Integer> s = new HashSet<>();
		
		for(int a : arr)
			s.add(a);
		
		for(int b : brr)
			s.add(b);
		
		for(Integer e : s)
			System.out.print(e.byteValue()+ " ");
			
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {1,2,3,4,-1};
		int[] br = {5,10,2};
		
		union(ar, br);

	}

}
