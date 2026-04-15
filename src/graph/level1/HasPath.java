package src.graph.level1;

import java.util.ArrayList;

public class HasPath {

    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }

        visited[src] = true;
        // check if there is a path from any neighbor of src to dest
        for(Edge edge : graph[src]){
            if(!visited[edge.neighbor]){
                return hasPath(graph, edge.neighbor, dest, visited);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        boolean[] visited = new boolean[vertices];

        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<>();
        }

        Edge e1 = new Edge(0 , 1, 10);
        Edge e2 = new Edge(0 , 2, 10);
        graph[0].add(e1);
        graph[0].add(e2);

        e1 = new Edge(1, 0, 10);
        e2 = new Edge(1, 2, 10);
        graph[1].add(e1);
        graph[1].add(e2);

        e1 = new Edge(2,1, 10);
        e2 = new Edge(2,3, 10);
        graph[2].add(e1);
        graph[2].add(e2);

        System.out.println(hasPath(graph, 0, 3, visited));

    }
}
