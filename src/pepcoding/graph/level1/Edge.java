package src.pepcoding.graph.level1;

// we are making a priority queue of Edge type, but in order for the PQ to maintain order , it needs what to compare => implement Comaparable<Edge> and override compareTo
public class Edge implements Comparable<Edge>{
    int src;
    int nbr;
    int cost;
    int level;
    String psf;

    public Edge(int src, int nbr, int cost) {
        this.src = src;
        this.nbr = nbr;
        this.cost = cost;
    }

    public Edge(int src, int nbr, int cost, String psf) {
        this.src = src;
        this.nbr = nbr;
        this.cost = cost;
        this.psf = psf;
    }

    public Edge(int src, int nbr, int cost, int level) {
        this.src = src;
        this.nbr = nbr;
        this.cost = cost;
        this.level = level;
    }

    public Edge(String psf, int cost){
        this.psf = psf;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
