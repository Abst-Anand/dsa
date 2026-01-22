package src.striverSdeSheet.graph;

import java.util.ArrayList;
import java.util.Collections;

public class FindDegreesOfNodes {
	
	static ArrayList<Integer> getInDegrees(ArrayList<ArrayList<Integer>> adjList){
		
		ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(adjList.size(), 0));
			
		for(int i=1; i<adjList.size(); i++) {
			
			for(int neighbour : adjList.get(i)) {
				ans.set(neighbour, ans.get(neighbour) + 1);
			}
		}
		
		ans.remove(0);
		
		return ans;
	}
	
	static ArrayList<Integer> getOutDegrees(ArrayList<ArrayList<Integer>> adjList){
		
		ArrayList<Integer> outDegrees = new ArrayList<>(Collections.nCopies(adjList.size(), 0));
		
		for(int i=1; i<adjList.size(); i++) {
			outDegrees.set(i, adjList.get(i).size());
		}
		outDegrees.remove(0);
		return outDegrees;
	}

	public static void main(String[] args) {
		int numOfNodes = 6;
		
		int[][] edges = {
				{3,4},
				{4,2},
				{5,3},
				{5,1},
				{6,3},
				{6,1},
		};
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<= numOfNodes; i++) {
			list.add(new ArrayList<>());			
		}

		for(int i=0; i<edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
//			list.get(edges[i][1]).add(edges[i][0]);
		}
		
		ArrayList<Integer> ans = getInDegrees(list);
		System.out.println(ans);

	}

}
