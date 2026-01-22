package src.striverSdeSheet.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
	private int getParent(int n) {
		return (n-1)/2;
	}
	
	private int getLeftChild(int n) {
		return 2*n + 1;
	}
	
	private int getRightChild(int n) {
		return 2*n +2;
	}
	
	private void swap(ArrayList<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	void insert(ArrayList<Integer> arr, int val) {
		arr.add(val);
		int n = arr.size() - 1;
		
		int i = n;
		while(i>0) {
			int parent = getParent(i);
			if(arr.get(i) > arr.get(parent)) {
				swap(arr, i, parent);
				i = parent;
			}else {
				break;
			}
		}
		System.out.println(arr);
	}
	
	int delete(ArrayList<Integer> arr) {
		int ans = arr.get(0);
		int n = arr.size();
		arr.set(0, arr.get(n-1));
		arr.remove(n-1);
		int i = 0;
		n = arr.size();
		while(true) {
			int maxIndex = i;

			int right = getRightChild(i);
			if(right < n) {
				if(arr.get(right) > arr.get(maxIndex))
					maxIndex = right;
			}
			
			int left = getLeftChild(i);
			if(left < n) {
				if(arr.get(left) > arr.get(maxIndex))
					maxIndex = left;
			}
			
			if(maxIndex != i) {				
				swap(arr, i, maxIndex);
				i = maxIndex;
			}else {
				break;
			}
		}
		
		System.out.println("deleted: " + ans);
		System.out.println("After deletion: " + arr);
		return ans;
	}

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		
		PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
		
		Heap heap = new Heap();
		
		// find kth largest from an array a
		int[] a = {-1, 3, 21, 1, 50};
		int k = 3;

//		for(int e : a) {
//			heap.insert(arr, e);
//			if(arr.size() > k) {
//				heap.delete(arr);
//			}
//		}
//		System.out.println(arr.get(0));
		
		ArrayList<Integer> sorted = new ArrayList<>();
		for(int i=1; i<=a.length; i++) {
			for(int e : a) {
				heap.insert(arr, e);
				if(arr.size() > i) {
					heap.delete(arr);
				}
			}
			sorted.add(arr.get(0));
			arr.clear();
		}
		
		System.out.println(sorted);
	}

}
