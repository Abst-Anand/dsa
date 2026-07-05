package src.pepcoding.graph.level1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Path {

    // checks if there exists a path from src to dest
    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }

        visited[src] = true;
        // check if there is a path from any neighbor of src to dest
        for(Edge edge : graph[src]){
            if(!visited[edge.nbr]){
                boolean hasNeighborPath = hasPath(graph, edge.nbr, dest, visited);
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
            if(!visited[path.nbr]){
                printAllPaths(graph, path.nbr, dest, visited, (pathSoFar + path.nbr + " -> "));
            }
        }
        visited[src] = false;
    }

    // Dijkstra Algo: find shortest path to all other nodes given a source node
    static class Pair implements Comparable<Pair>{
        int src;
        int cost;
        String psf;

        public Pair(int src, int cost, String psf){
            this.src = src;
            this.cost = cost;
            this.psf = psf;
        }


        @Override
        public String toString() {
            return "[" + src + " via " + psf + " @ " + cost + "]\n";
        }


        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }
    static ArrayList<Pair> dijkstraShortestPath(ArrayList<Edge>[] graph, int source, boolean[] visited){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Pair> res = new ArrayList<>();

        pq.add(new Pair(source, 0, "0"));

        while (!pq.isEmpty()){
            // remove
            Pair curr = pq.poll();

            // mark
            if(visited[curr.src]){
                continue;
            }
            visited[curr.src] = true;

            // work
            res.add(curr);

            // add neighbors
            for(Edge e : graph[curr.src]){
                if(!visited[e.nbr]){
                    pq.add(new Pair(e.nbr, curr.cost + e.cost, curr.psf + e.nbr + ""));
                }
            }

        }

        System.out.println(res);
        return res;
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
       // printAllPaths(graph, 0 ,3, visited, "0 -> ");

        boolean[] vis = new boolean[vertices];
        dijkstraShortestPath(graph, 0, vis);

    }
}
