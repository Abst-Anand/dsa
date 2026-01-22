package striverSdeSheet.graph;

import java.util.ArrayList;

public class DFS {
	
	static void internalDfs(int source, ArrayList<Integer> result,int[] visited, ArrayList<ArrayList<Integer>> adjList) {
		
//		if(visited[source] == 1) return;
		
		visited[source] = 1;
		result.add(source);
		
		for(int e : adjList.get(source)) {
			if(visited[e] == 0) {
				internalDfs(e, result, visited, adjList);
			}
		}
	}
	
	static ArrayList<Integer> dfs(int source, ArrayList<ArrayList<Integer>> adjList){
		int[] visited = new int[adjList.size()];
		ArrayList<Integer> dfsResult = new ArrayList<>();
		internalDfs(source, dfsResult, visited, adjList);
		return dfsResult;
	}

	public static void main(String[] args) {
		
		int numOfNodes = 7;
		
		int[][] edges = {
				{1,2},
				{1,3},
				{2,4},
				{2,5},
				{3,6},
				{3,7},
		};
		
		ArrayList<ArrayList < Integer > > list = new ArrayList<>(numOfNodes + 1);
		
		for(int i=0; i<= numOfNodes; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
			list.get(edges[i][1]).add(edges[i][0]);
		}
		
		for(var t : list) {
			System.out.print(list.indexOf(t) + " ->");
			for(var e : t) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
		ArrayList<Integer> res = dfs(1, list);
		
		for(int e : res) {
			System.out.print(e + " ");
		}
	}

}
