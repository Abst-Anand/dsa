package src.pepcoding.graph.level1;

import java.util.ArrayList;

public class Graph {

    static ArrayList<Edge>[] createGraph(int vertices, String edgesStr, boolean isDirected){

        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for(int i = 0; i < vertices; i++){
            graph[i] = new ArrayList<>();
        }

        String[] lines = edgesStr.split("\n");

        for(String line : lines){

            line = line.trim();

            if(line.isEmpty()) continue;

            String[] parts = line.split(",");

            int src = Integer.parseInt(parts[0].trim());
            int dest = Integer.parseInt(parts[1].trim());
            int wt = Integer.parseInt(parts[2].trim());

            graph[src].add(new Edge(src, dest, wt));

            if(!isDirected) {
                graph[dest].add(new Edge(dest, src, wt));
            }
        }

        return graph;
    }

    static int[][] createMatrix(){
        String[] lines = matrixWithIslands.split("\n");
        int rows = lines.length;
        int cols = lines[0].trim().split(" ").length;

        int[][] mat = new int[rows][cols];

        int i=0;
        for(String line : lines){
            line = line.trim();

            if(line.isEmpty()) continue;

            String[] parts = line.split(" ");

            for(int j=0; j<cols; j++){
                mat[i][j] = Integer.parseInt(parts[j]);
            }
            i++;
        }

        return mat;
    }

    static String graphWithSevenVertices = """
            0,1,10
            0,3,40
            1,2,10
            2,3,10
            3,4,2
            4,5,3
            4,6,8
            5,6,3
            """;

    static String graphWithComponents = """
            0,1,10
            2,3,10
            3,4,10
            """;

    static String matrixWithIslands = """
            0 0 1 1 1 1
            0 0 1 1 1 1
            1 1 1 1 1 0
            1 0 0 1 1 0
            1 1 1 1 1 0
            0 0 1 1 0 0
            """;

    static String clubsAndMembers = """
            0,1,10
            2,3,10
            4,5,10
            4,6,10
            5,6,10
            """;
}
