package src.striverSdeSheet.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Revisit {

	static void bfs(ArrayList<ArrayList<Integer>> adjList, int source) {
		int V = adjList.size();
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		int[] level = new int[V];
		q.add(source);
		visited[source] = true;
		
		level[source] = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			result.add(node);
			System.out.println(level[node] + "->" + node);
			for(int neighbour : adjList.get(node)) {
				if(!visited[neighbour]) {
					q.add(neighbour);
					visited[neighbour] = true;
					level[neighbour] = level[node] + 1;
				}
			}
		}
		System.out.println(result);
	}
	
	static void dfsInternal(int node, ArrayList<Integer> result, boolean[] vis, ArrayList<ArrayList<Integer>> adjList) {
		vis[node] = true;
		result.add(node);
		for(int neighbor : adjList.get(node)) {
			if(!vis[neighbor]) {
				dfsInternal(neighbor, result, vis, adjList);
			}
		}
	}
	
	static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjList,int source) {
		ArrayList<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[adjList.size()];
		dfsInternal(source, result, visited, adjList);
		System.out.println(result);
		return result;
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
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		
		for(int i=0; i<=numOfNodes;i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0; i<edges.length;i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			adjList.get(from).add(to);
			// undirected graph
			from = edges[i][1];
			to = edges[i][0];
			adjList.get(from).add(to);
		}
		System.out.println(adjList);
		bfs(adjList, 1);
		
		dfs(adjList,1);

	}

}
