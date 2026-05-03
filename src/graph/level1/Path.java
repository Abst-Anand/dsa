package src.graph.level1;

import java.util.ArrayList;

public class Path {

    // checks if there exists a path from src to dest
    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }

        visited[src] = true;
        // check if there is a path from any neighbor of src to dest
        for(Edge edge : graph[src]){
            if(!visited[edge.neighbor]){
                boolean hasNeighborPath = hasPath(graph, edge.neighbor, dest, visited);
                if(hasNeighborPath)
                    return true;
            }
        }

        return false;
    }

    // prints all paths from src to dest
    static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathSoFar){
        if(src == dest){
            System.out.println(pathSoFar);
            return;
        }

        visited[src] = true;

        for(Edge path : graph[src]){
            if(!visited[path.neighbor]){
                printAllPaths(graph, path.neighbor, dest, visited, (pathSoFar + path.neighbor + " -> "));
            }
        }
        visited[src] = false;
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

        e1 = new Edge(3,2, 10);
        e2 = new Edge(3,4, 10);
        graph[3].add(e1);
        graph[3].add(e2);

        e1 = new Edge(4,3, 10);
        e2 = new Edge(4,4, 10);
        Edge e3 = new Edge(4,6, 10);
        graph[4].add(e1);
        graph[4].add(e2);
        graph[4].add(e3);

        e1 = new Edge(5,4, 10);
        e2 = new Edge(5,6, 10);
        graph[5].add(e1);
        graph[5].add(e2);

        e1 = new Edge(6,4, 10);
        e2 = new Edge(6,5, 10);
        graph[6].add(e1);
        graph[6].add(e2);

        //System.out.println(hasPath(graph, 0, 3, visited));
        printAllPaths(graph, 0 ,3, visited, "0 -> ");

    }
}
