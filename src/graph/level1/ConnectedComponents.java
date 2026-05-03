package src.graph.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {

    static void getConnectedComponents(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){
        if(visited[src]){
            return;
        }

        visited[src] = true;
        comp.add(src);
        for(Edge edge : graph[src]){
            if(!visited[edge.neighbor]){
                getConnectedComponents(graph, edge.neighbor, visited, comp);
            }
        }
    }

    // if a graph is connected, then it should yeild only one component when we try to find all its components on each vertex
    static boolean isGraphConnected(ArrayList<Edge>[] graph, int vertices){
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[vertices];

        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                ArrayList<Integer> c = new ArrayList<>();
                getConnectedComponents(graph, i, visited, c);
                components.add(c);
            }
        }

        return components.size() == 1;
    }

    // check if a graph is bipartite => when we can divide each vertex in one of two sets such that there is no edge among vertices of same set
    // acyclic graph is always bipartite
    // cyclic graph with even number of vertices is always bipartite
    // cyclic graph with odd vertices is never bipartite
    static class Pair{
        int vertex;
        String psf; // path so far
        int level;

        public Pair(int vertex, String psf, int level){
            this.vertex = vertex;
            this.psf = psf;
            this.level = level;
        }

        @Override
        public String toString() {
            return "[" +
                    vertex + " ┃ " +
                    psf + " ┃ " +
                    level +
                    ']';
        }
    }
    static boolean isBipartie(ArrayList<Edge>[] graph, int src, int[] visited){
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(src, src+"", 0));

        while (!queue.isEmpty()){
            // remove
            Pair curr = queue.poll();
            System.out.println(curr);

            // mark visited and work
            if(visited[curr.vertex] != -1){
                if(curr.level != visited[curr.vertex])
                    return false;
            }else {
                visited[curr.vertex] = curr.level;
            }

            // add neighbors who are not visited
            for(Edge e : graph[curr.vertex]){
                if(visited[e.neighbor] == -1){
                    queue.add(new Pair(e.neighbor, curr.psf + " " + e.neighbor, curr.level+1));
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int vertices = 3;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<>();
        }
        Edge e1 = new Edge(0, 0,10);
        Edge e2 = new Edge(1, 2, 10);
        Edge e3 = new Edge(2, 1, 10);
        graph[0].add(e1);
        graph[1].add(e2);
        graph[2].add(e3);

        boolean[] visited = new boolean[vertices];

        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                ArrayList<Integer> c = new ArrayList<>();
                getConnectedComponents(graph, i, visited, c);
                components.add(c);
            }
        }
        System.out.println(components);

        System.out.println(isGraphConnected(graph, vertices));

        int vtces = 5; // cyclic graph with odd vertices is never bipartite
        ArrayList<Edge>[] g1 = new ArrayList[vtces];
        for(int i=0; i<vtces; i++){
            g1[i] = new ArrayList<>();
        }
        // a pentagon => cyclic graph with odd no. of vertices

        Edge e01 = new Edge(0, 1, 10);
        Edge e04 = new Edge(0,4,10);
        g1[0].add(e01);
        g1[0].add(e04);

        Edge e10 = new Edge(1,0,10);
        Edge e12 = new Edge(1,2,10);
        g1[1].add(e10);
        g1[1].add(e12);

        Edge e21 = new Edge(2,1,10);
        Edge e23 = new Edge(2,3,10);
        g1[2].add(e21);
        g1[2].add(e23);

        Edge e32 = new Edge(3,2,10);
        Edge e34 = new Edge(3,4,10);
        g1[3].add(e32);
        g1[3].add(e34);

        Edge e40 = new Edge(4,0,10);
        Edge e43 = new Edge(4,3,10);
        g1[4].add(e40);
        g1[4].add(e43);

        int[] vis = new int[vtces];
        Arrays.fill(vis, -1);

        System.out.println("is bipartite: ");
        boolean res = false;

        for(int i=0; i<vtces; i++){
            if(vis[i] == -1){
                res = isBipartie(g1, i, vis);
            }
        }
        System.out.println(res);

    }

}
