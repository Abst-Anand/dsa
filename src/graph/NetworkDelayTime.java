//743
package src.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class NetworkDelayTime {
	static int MAX = Integer.MAX_VALUE;
	static int findMinimumCost(int[][]arr, int start, int end) {

		if(start == end) return 0;
		if(arr[start][end] == MAX) return MAX;

		int ans = arr[start][end];
		
		for(int i=1; i<arr[start].length; i++) {
			if(i== end || arr[start][i] == Integer.MAX_VALUE) continue;
			if(i != end) {
//				System.out.println(start +"," + i);
				int current = arr[start][i];
				current += findMinimumCost(arr, i, end);
				ans = Math.min(ans, current);
			}
		}
		System.out.println("returned val: " + ans);
		return ans;
	}
	
	static int minNetworkDelay(int[][] arr, int src) {
		int ans = -1;
		HashMap<Integer,Integer> dist = new HashMap<>();
		
		for(int i=1; i<arr[src].length; i++) {
			if(i != src) {
				int minDist = findMinimumCost(arr, src, i);
				dist.put(i, minDist);
			}
		}
		
		for(Entry<Integer, Integer> ent : dist.entrySet()) {
			System.out.println(ent.getKey() +"-> " + ent.getValue());
		}
		
		return ans == MAX ? -1 : ans;
	}

	public static void main(String[] args) {
		
		int[][] arr = {
			    {0,  0,  0,  0,  0},
			    {0, MAX, MAX, MAX, MAX}, 
			    {0,  12, MAX, 2, MAX}, 
			    {0,  16, MAX, MAX, 3}, 
			    {0,  5, MAX, MAX, MAX}
			};

		int min = findMinimumCost(arr, 3,4);
		System.out.println(min);
		
//		ProcessBuilder pb = new ProcessBuilder("cmd","ls" ,"/c", "start");
//		try {
//			pb.start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
