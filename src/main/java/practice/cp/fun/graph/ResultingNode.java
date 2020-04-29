package practice.cp.fun.graph;

public class ResultingNode {
    public int cost;
    public int predecessor;

    ResultingNode(int cost, int predecessor) {
        this.cost = cost;
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return "cost is " + this.cost + " predecessor is " + this.predecessor;
    }
}
