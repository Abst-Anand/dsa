package src.hashing.openAddressing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

public class Intersection {

	static void intersection(int[] arr, int[] brr) {
		
		HashMap<Integer,Integer> intersect = new HashMap<>();
		
		for(int a : arr)
			intersect.put(a, 1);
		
		
		for(int b : brr) 
			intersect.put(b, intersect.getOrDefault(b, 0)+1);
		
		
		
		Iterator<Map.Entry<Integer, Integer>> it = intersect.entrySet().iterator();
		
		while(it.hasNext()) {
			if(it.next().getValue() == 1) {
				it.remove();
			}
		}
		
		
		for(Map.Entry<Integer, Integer> ent : intersect.entrySet()) {
			System.out.print(ent.getKey() + " ");
		}
	}
	
	static void intersectUsingSet(int[]arr,int[]brr) {
		HashSet<Integer> s = new HashSet<>();
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++)
			s.add(arr[i]);
		
		for(int i=0;i<brr.length;i++) {
			if(s.contains(brr[i]) && !res.contains(brr[i])) {
				res.add(brr[i]);
			}
		}
		
		for(int e : res) {
			System.out.print(e + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {10,10,10};
		int[] br = {10,10,10};
		
		intersectUsingSet(ar, br);
		
/*
 * 23 568 93 9
 * */
	}

}
