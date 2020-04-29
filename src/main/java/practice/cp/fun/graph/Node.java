package practice.cp.fun.graph;

public class Node implements Comparable<Node> {
    private int targetVertex;
    private int sourceVertex;
    private int cost;

    Node() {
    }

    public int getSourceVertex() {
        return sourceVertex;
    }

    public Node(int sourceVertex, int targetVertex, int cost) {
        this.targetVertex = targetVertex;
        this.sourceVertex = sourceVertex;
        this.cost = cost;
    }

    int getTargetVertex() {
        return this.targetVertex;
    }

    int getCost() {
        return this.cost;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cost > o.cost) {
            return 1;
        }
        if (o.cost > this.cost) {
            return -1;
        }
        return 0;
    }
}
