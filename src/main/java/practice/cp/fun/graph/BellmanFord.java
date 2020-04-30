package practice.cp.fun.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BellmanFord {
    public int V;
    public int source;
    List<List<Node>> edges = new ArrayList<>();
    boolean isNegativeCycle = false;

    public BellmanFord(int V, int source) {
        this.V = V;
        this.source = source;
        for (int i=0; i<V; i++) {
            edges.add(new ArrayList<Node>());
        }
    }

    public void addEdge(int source, Node node) {
        if (edges.get(source) != null) {
            edges.get(source).add(node);
        } else {
            edges.add(new ArrayList<>());
            edges.get(source).add(node);
        }
    }

    public ResultingNode[] findShortestPathToEachNode() {
        ResultingNode[] shortestDistances = new ResultingNode[V];
        for (int i=0; i<V; i++) {
            shortestDistances[i] = new ResultingNode(Integer.MAX_VALUE, 0);
        }
        shortestDistances[source].cost = 0;
        for (int i=0; i<V; i++) {
            Iterator<Node> nodes = edges.get(i).listIterator();
            while (nodes.hasNext()) {
                Node edge = nodes.next();
                if (shortestDistances[edge.getTargetVertex()].cost > shortestDistances[edge.getSourceVertex()].cost + edge.getCost()) {
                    shortestDistances[edge.getTargetVertex()].cost = shortestDistances[edge.getSourceVertex()].cost + edge.getCost();
                    shortestDistances[edge.getTargetVertex()].predecessor = edge.getSourceVertex();
                }
            }
        }

        for (int i=0; i<V; i++) {
            Iterator<Node> nodes = edges.get(i).listIterator();
            while (nodes.hasNext()) {
                Node edge = nodes.next();
                if (shortestDistances[edge.getTargetVertex()].cost > shortestDistances[edge.getSourceVertex()].cost + edge.getCost()) {
                    isNegativeCycle = true;
                    break;
                }
            }
            if(isNegativeCycle) {
                break;
            }
        }
        return shortestDistances;
    }


}
