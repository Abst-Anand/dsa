package src.striverSdeSheet.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	
	static ArrayList<Integer> bfs(int source, ArrayList<ArrayList<Integer>> adjList){
		int numOfNodes = adjList.size();
		
		int[] visited = new int[numOfNodes + 1];
		ArrayList<Integer> bfsResult = new ArrayList<>(numOfNodes);
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(source);
		visited[source] = 1;
		
		while(!queue.isEmpty()) {
			int front = queue.poll();
			bfsResult.add(front);
			
			for(int n : adjList.get(front)) {
				if(visited[n] == 0) {
					queue.add(n);
					visited[n] = 1;
				}
			}
		}
		
		return bfsResult;
	}

	public static void main(String[] args) {
		
		int numOfNodes = 7;
		
		int[][] edges = {
				{1,2},
				{1,3},
				{2,4},
				{2,5},
				{3,6},
				{3,7}
				
		};
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<= numOfNodes; i++) {
			list.add(new ArrayList<>());			
		}

		for(int i=0; i<edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
			list.get(edges[i][1]).add(edges[i][0]);
		}
		
		
		
		for(int i=1; i<list.size(); i++) {
			System.out.print(i + "->" );
			for(int e : list.get(i)) {
				System.out.print(e + " ");
			}
			System.out.println();
		}

		
		ArrayList<Integer> res = bfs(1, list);
		
//		res = DFS.dfs(1, list);
		for(int e: res) {
			System.out.print(e + " ");
		}

	}

}
