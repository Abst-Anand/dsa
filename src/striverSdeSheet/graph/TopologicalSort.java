package striverSdeSheet.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

	private static ArrayList<Integer> getInDegrees(ArrayList<ArrayList<Integer>> adjList){
		
		int n = adjList.size();
		ArrayList<Integer> inDegrees = new ArrayList<>(Collections.nCopies(n, 0));
		
		for(int i=1; i<n; i++) {
			for(int neighbour : adjList.get(i)) {
				inDegrees.set(neighbour, inDegrees.get(neighbour) + 1);
			}
		}
		inDegrees.set(0, -1);
		return inDegrees;
	}
	
	static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adjList){
		
		ArrayList<Integer> inDegrees = getInDegrees(adjList);

		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<inDegrees.size(); i++) {
			if(inDegrees.get(i) == 0) {
				q.add(i);
			}
		}
		
		ArrayList<Integer> topo = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int node = q.poll();
			topo.add(node);
			for(int neighbour : adjList.get(node)) {
				inDegrees.set(neighbour, inDegrees.get(neighbour) - 1);
				if(inDegrees.get(neighbour) == 0) {
					q.add(neighbour);
				}
			}
		}
		
		return topo;		
	}	
	
	public static void main(String[] args) {
		int numOfNodes = 5;
		
		int[][] edges = {
				{1,2},
				{2,3},
				{3,5},
				{3,4},
				{4,2}
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
		
		ArrayList<Integer> topo = topoSort(list);
		System.out.println(topo);
		
		
	}

}
