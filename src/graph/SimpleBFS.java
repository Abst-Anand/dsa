package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SimpleBFS {

	public static void main(String[] args) {
		
		int vertices = 5;

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);

		
		for(int i=0; i<10; i++) {
			graph.add(new ArrayList());
		}
		

		graph.get(0).add(1);
		graph.get(0).add(2);
		
		graph.get(2).add(3);
		graph.get(2).add(4);
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the source:");
		int source = in.nextInt();
		in.close();
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[vertices];
		
		q.add(source);
		isVisited[source] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			System.out.println(v + " ");
			
			for(int child : graph.get(v)) {
				if(!isVisited[child]) {
					q.add(child);
					isVisited[child] = true;
				}
			}
		}
		
		
		
		
		

		
		
		
	}

}
