package striverSdeSheet.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
	
	static boolean bfs(ArrayList<ArrayList<Integer>> adjList, int source, int[] visited) {
		
		Queue<int[]> parentQueue = new LinkedList<>();
		
		visited[source] = 1;
		parentQueue.add(new int[] {source, -1});
		
		while(!parentQueue.isEmpty()) {
			int[] pair = parentQueue.poll();
			int node = pair[0];
			int parent = pair[1];
			
			for(int neighbour : adjList.get(node)) {
				if(visited[neighbour] == 0) {
					visited[neighbour] = 1;
					parentQueue.add(new int[] {neighbour, node});
				}
				else if(parent != neighbour) {
					return true;
				}
			}
			
			
		}
		return false;
	}
	static boolean checkCycleUsingBfs(ArrayList<ArrayList<Integer>> adjList, int numOfNodes) {
		int[] visited = new int[adjList.size()];
		for(int i=1; i<=numOfNodes; i++) {
			if(visited[i] == 0 && bfs(adjList, i, visited))
				return true;
		}
		return false;	
	}

	static boolean dfs(ArrayList<ArrayList<Integer>> adjList, int node,int parent, boolean[] vis) {
		
		System.out.println(node + ", " + parent);
		vis[node] = true;
		
		for(int neighbour : adjList.get(node)) {
			if(!vis[neighbour]) {
//				dfs(adjList, neighbour, node, vis);
				if(dfs(adjList, neighbour, node, vis)) {
					return true;
				}
			}
			else if(parent != neighbour) {
				return true;
			}
		}
		
		return false;
	}
	
	static boolean checkCycleUsingDfs(ArrayList<ArrayList<Integer>> adjList, int numOfNodes) {
		boolean[] visited = new boolean[adjList.size()];
		
		
		for(int i=1; i<= numOfNodes; i++) {
		    if (!visited[i]) {
		        if(dfs(adjList, i, -1, visited)) {
		            return true;  // stop immediately once a cycle is found
		        }
		    }
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int numOfNodes = 6;
		
		int[][] edges = {
				{1,2},
				{2,3},
				{4,5},
				{5,6},
				{6,4},
			
		};
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<= numOfNodes; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
//			list.get(edges[i][1]).add(edges[i][0]);
		}
		
		for(int i=1; i<list.size(); i++) {
			System.out.print(i + "->" );
			for(int e : list.get(i)) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
		System.out.println(checkCycleUsingBfs(list, numOfNodes));
		System.out.println(checkCycleUsingDfs(list, numOfNodes));
		
	}
}
