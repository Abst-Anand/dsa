package src.graph.level1;

public class Edge {
    int src;
    int neighbor;
    int cost;

    public Edge(int src, int neighbor, int cost) {
        this.src = src;
        this.neighbor = neighbor;
        this.cost = cost;
    }
}
