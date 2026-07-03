package src.graph.level1;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Q1 to Q3 => Path based
Q4 to Q7 => Connected Component based

 */

public class AllInOneGraph {

    // Q1: check if path exist between a source and destination
    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }

        visited[src] = true;

        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                boolean hasPathNeighbor = hasPath(graph, e.nbr, dest, visited);
                return hasPathNeighbor;
            }
        }

        return false;
    }

    // Q2: find all path(s) from source to destination
    static void findAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path, boolean[] visited, ArrayList<String> allPaths){
        if(src == dest){
            allPaths.add(path);
//            System.out.println(path); // each path will be printed here
            return;
        }

        visited[src] = true;

        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                findAllPaths(graph, e.nbr, dest, path + e.nbr + " ", visited, allPaths);
            }
        }
        visited[src] = false;
    }

    // Q3: from source to destination, find the smallest, largest, ceil and floor path to a given cost and k'th largest path
    static int largestPathCost = Integer.MIN_VALUE;
    static String lPath;
    static int smallestPathCost = Integer.MAX_VALUE;
    static String sPath;
    static int ceilPathCost = Integer.MAX_VALUE;
    static String ceilPath;
    static int floorPathCost = Integer.MIN_VALUE;
    static String flootPath;
    static PriorityQueue<Edge> pq = new PriorityQueue(); // Edge class needs to implement Comparable interface
    static void findAllPathsWithCriteria(ArrayList<Edge>[] graph, int src, int dest, String psf, int wsf, boolean[] visited, int criteria, int k){
        if(src == dest){
            if(wsf < smallestPathCost){
                smallestPathCost = wsf;
                sPath = psf;
            }

            if(wsf > largestPathCost){
                largestPathCost = wsf;
                lPath = psf;
            }

            // this is like finding the smallest but more than criteria, hence initialize = +infinity
            if(wsf > criteria && wsf < ceilPathCost){
                ceilPathCost = wsf;
                ceilPath = psf;
            }

            // this is like finding the largest but less than criteria, initialize = -infinity
            if(wsf < criteria && wsf > floorPathCost){
                floorPathCost = wsf;
                flootPath = psf;
            }

            // for kth largest things use min heap
            if(pq.size() < k){
                pq.add(new Edge(psf, wsf));
            }else{
                if(pq.peek().cost < wsf){
                    pq.poll();
                    pq.add(new Edge(psf, wsf));
                }
            }
            return;
        }

        visited[src] = true;

        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                findAllPathsWithCriteria(graph, e.nbr, dest, psf + e.nbr + "", wsf + e.cost, visited, criteria, k);
            }
        }

        visited[src] = false;
    }

    // Q4: find all the connected components of a graph
    static void findAllConnectedComponents(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){
        comp.add(src);
        visited[src] = true;

        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                findAllConnectedComponents(graph, e.nbr, visited, comp);
            }
        }
    }

    // Q5: check if the given graph is connected. If connected then there should be only one component
    static void checkGraphConnected(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){
        comp.add(src);
        visited[src] = true;

        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                checkGraphConnected(graph, e.nbr, visited, comp);
            }
        }
    }

    // Q6: count islands from a given matrix. 0 => land and 1 => water
    static void markConnectedIslands(int[][] matrix, int i, int j, boolean[][] visited){

        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j] || matrix[i][j] == 1){
            return;
        }

        visited[i][j] = true;
        markConnectedIslands(matrix, i-1, j , visited); // top
        markConnectedIslands(matrix, i+1, j, visited); // bottom
        markConnectedIslands(matrix, i, j+1, visited); // right
        markConnectedIslands(matrix, i, j-1, visited); // left
    }

    // Q7: Perfect Friends: given clubs (edges) between friends, find number of ways to select any two friends scuh that they do not belong to the same club (same component)
    static void findClubsAndMembers(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> members){
        visited[src] = true;
        members.add(src);

        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                findClubsAndMembers(graph, e.nbr, visited, members);
            }
        }
    }


    public static void main(String[] args) {

        // Q1
        int vert = 7;
        ArrayList<Edge>[] graph = Graph.createGraph(vert, Graph.graphWithSevenVertices, false);

        boolean[] vis = new boolean[vert];

        System.out.println("Q1: \n" + hasPath(graph,0,6, vis));

        // Q2
        System.out.println("Q2:");
        boolean[] vis2 = new boolean[vert];
        ArrayList<String> allPaths = new ArrayList<>();
        int src2 = 0;
        int dest = 6;
        String path = src2 + " ";
        findAllPaths(graph, src2, dest, path, vis2, allPaths);
        System.out.println(allPaths);

        // Q3
        System.out.println("Q3:");
        int k = 3;
        int criteria = 40; // the weight whose ceil & floor will be calculated
        int src3 = 0;
        int dest3 = 6;

        findAllPathsWithCriteria(graph,src3, dest3, src3+"", 0, vis2, criteria, k);
        System.out.println("Smallest Path = "  + sPath + "@" + smallestPathCost);
        System.out.println("Largest Path = "  + lPath + "@" + largestPathCost);
        System.out.println("Just smaller Path than criteria = "  + flootPath + "@" + floorPathCost);
        System.out.println("Just larger Path than criteria = "  + ceilPath + "@" + ceilPathCost);
        System.out.println("Kth largest Path  = "  + pq.peek().psf + "@" + pq.peek().cost);

        // Q4
        int vertices4 = 5;
        ArrayList<Edge>[] graph4 = Graph.createGraph(vertices4, Graph.graphWithComponents, false);

        System.out.println("Q4:");
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] vis4 = new boolean[vertices4];
        for(int i=0; i<vertices4; i++){
            if(!vis4[i]){
                ArrayList<Integer> comp = new ArrayList<>();
                findAllConnectedComponents(graph4, i, vis4, comp);
                components.add(comp);
            }
        }
        System.out.println(components);
        components.clear();

        // Q5
        System.out.println("Q5:");
        boolean[] vis5 = new boolean[vertices4];
        for(int i=0; i<vertices4; i++){
            if(!vis5[i]){
                ArrayList<Integer> comp = new ArrayList<>();
                checkGraphConnected(graph4, i, vis5, comp);
                components.add(comp);
            }
        }
        System.out.println("Is connected: " + (components.size() == 1));

        // Q6
        System.out.println("Q6:");
        int[][] mat = Graph.createMatrix();
        boolean[][] vis6 = new boolean[mat.length][mat[0].length];
        int count = 0;

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
                if (mat[i][j] == 0 && !vis6[i][j]) {
                    markConnectedIslands(mat, i, j, vis6);
                    count++;
                }
            }
            System.out.println();
        }
        System.out.println("Number of islands: " + count);

        // Q7
        System.out.println("Q7:");
        int friends = 7;
        ArrayList<Edge>[] g7 = Graph.createGraph(friends, Graph.clubsAndMembers, false);
        ArrayList<ArrayList<Integer>> clubs = new ArrayList<>();
        boolean[] vis7 = new boolean[friends];

        for(int i=0; i<friends; i++){
            if(!vis7[i]){
                ArrayList<Integer> members = new ArrayList<>();
                findClubsAndMembers(g7, i, vis7, members);
                clubs.add(members);
            }
        }
        System.out.println(clubs);
        int c7 = 0;
        for(int i=0; i<clubs.size(); i++){
            for(int j=i+1; j<clubs.size(); j++){
                ArrayList<Integer> club1 = clubs.get(i);
                ArrayList<Integer> club2 = clubs.get(j);
                int totalCombinations = club1.size() * club2.size();
                c7 += totalCombinations;
            }
        }
        System.out.println(c7);


    }
}
