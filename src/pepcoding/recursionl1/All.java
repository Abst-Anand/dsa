package src.pepcoding.recursionl1;

import java.util.ArrayList;

public class All {

    // sr = source row, sc = source col, dr = destination row, dc = destination col
    static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc){
        if(sr == dr && dr == dc){
            ArrayList<String> reached = new ArrayList<>();
            reached.add("");
            return reached;
        }

        ArrayList<String> horizontalPaths = new ArrayList<>();
        ArrayList<String> verticalPaths = new ArrayList<>();

        if(sc < dc){
            horizontalPaths = getMazePaths(sr, sc+1, dr, dc);
        }

        if(sr < dr){
            verticalPaths = getMazePaths(sr+1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();

        for(String s : horizontalPaths){
            paths.add('h' + s);
        }
        for(String s : verticalPaths){
            paths.add('v' + s);
        }

        return paths;
    }


    public static void main(String[] args) {
        ArrayList<String> res = getMazePaths(1,1,3,3);
        System.out.println(res);
        System.out.println(res.size());
    }
}
