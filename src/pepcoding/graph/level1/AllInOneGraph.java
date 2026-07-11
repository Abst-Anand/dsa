package src.pepcoding.graph.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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



    // Q11: is graph cyclic

    // Q12:

    // Q13: Spread Infection, given a infected node at t=1, infection spreads to its neighbor each unit time, count infected nodes for a given time t
    static class Pair{
        int src;
        int time;

        public Pair(int scr, int time){
            this.src = scr;
            this.time = time;
        }

        @Override
        public String toString() {
            return "[" +
                    "Node=" + src +
                    ", time=" + time +
                    ']';
        }
    }
    static int countInfectedNodes(ArrayList<Edge>[] graph, int vertices, int src, int t){

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 1));

        int[] visited = new int[vertices];
        int count = 0;

        while (!queue.isEmpty()){
            Pair currNode = queue.poll();

            if(visited[currNode.src] != 0){
                continue;
            }
//            System.out.println(currNode);
            visited[currNode.src] = currNode.time;

            if(currNode.time > t){
                break;
            }

            count++;

            for(Edge e : graph[currNode.src]){
                if(visited[e.nbr] == 0){
                    queue.add(new Pair(e.nbr, currNode.time+1));
                }
            }

        }

        return count;
    }

    // Q 13.1: Rotting Oranges, given a mxn matrix with each cell having value from [0,1,2]
    // 0 => empty cell, 1 => rotten orange, 2 => fresh orange
    // find the minimum time it will take such that no fresh oranges are left
    static class OrangeInfo{
        int row;
        int col;
        int time;

        public OrangeInfo(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public String toString() {
            return "OrangeInfo{" +
                    "row=" + row +
                    ", col=" + col +
                    ", time=" + time +
                    '}';
        }
    }
    static int rottingOranges(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int totalOranges = 0;
        int rottenOranges = 0;
        Queue<OrangeInfo> queue = new LinkedList<>();
        int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1 || mat[i][j] == 2)
                    totalOranges++;
                if(mat[i][j] == 2){
                    queue.add(new OrangeInfo(i,j,0));
                    rottenOranges++;
                }
            }
        }

        int minimumTimeToRot = 0;

        while (!queue.isEmpty()){
            OrangeInfo curr = queue.poll();

            for(int[] d : dir){
                int nextRow = curr.row + d[0];
                int nextCol = curr.col + d[1];

                if(nextRow<0 || nextRow >= m || nextCol<0 || nextCol >=n || mat[nextRow][nextCol] != 1){
                    continue;
                }
                mat[nextRow][nextCol] = 2;
                rottenOranges++;

                OrangeInfo next = new OrangeInfo(nextRow, nextCol, curr.time+1);
                queue.add(next);
                minimumTimeToRot = Math.max(minimumTimeToRot, curr.time+1);
            }
        }

        return (totalOranges == rottenOranges) ? minimumTimeToRot : -1;
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

//===========================================================================================================
        System.out.println("+++Q13++++++++++++++++++++++");
        int res13 = countInfectedNodes(graph, vert, 6, 7);
        System.out.println(res13);
//===========================================================================================================
        System.out.println("+++Q13.1++++++++++++++++++++++");
        int[][] mat13 = {{2,1,1}, {1,1,0}, {0,1,1}};
        int res131 = rottingOranges(mat13);
        System.out.println(res131);

    }
}
