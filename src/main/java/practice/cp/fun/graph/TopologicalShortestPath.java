package practice.cp.fun.graph;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TopologicalShortestPath {
    int V;
    List<List<Node>> edges;
    int source;
    public TopologicalShortestPath(int V, List<List<Node>> edges, int source) {
        this.V = V;
        this.edges = edges;
        this.source = source;
    }

    public ResultingNode[] findShortestPathToEachNode(Integer[] topologicalSortedArray) {
        ResultingNode[] shortestDistances = new ResultingNode[V];
        for (int i=0; i<V; i++) {
            shortestDistances[i] = new ResultingNode(Integer.MAX_VALUE, source);
        }
        shortestDistances[source].cost = 0;
        for (int i=0; i<V; i++) {
            Iterator<Node> nodes = edges.get(topologicalSortedArray[i]).listIterator();
            while (nodes.hasNext()) {
                Node edge = nodes.next();
                if (shortestDistances[edge.getSourceVertex()].cost != Integer.MAX_VALUE && shortestDistances[edge.getTargetVertex()].cost > (shortestDistances[edge.getSourceVertex()].cost + edge.getCost())) {
                    shortestDistances[edge.getTargetVertex()].cost = shortestDistances[edge.getSourceVertex()].cost + edge.getCost();
                    shortestDistances[edge.getTargetVertex()].predecessor = edge.getSourceVertex();
                }
            }
        }
        return shortestDistances;
    }

    public ResultingNode[] findShortestPathToEachNode(Stack<Integer> topologicalSortedArray) {
        Integer[] integers = new Integer[topologicalSortedArray.size()];
        int count = 0;
        while (!topologicalSortedArray.isEmpty()) {
            integers[count++] = topologicalSortedArray.pop();
        }
        return findShortestPathToEachNode(integers);
    }
}
