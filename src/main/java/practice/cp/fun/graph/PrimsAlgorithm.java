package practice.cp.fun.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimsAlgorithm {

    int V; // no of vertices in the graph
    int source; // source of the graph from which the shortest distance has to be measured
    List<List<Node>> adj = new ArrayList<>();
    Set<Integer> nodes = new HashSet<>();
    int totalcost = 0;

    public PrimsAlgorithm(int source, int V) {
        this.source = source;
        this.V = V;
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<Node>());
        }
    }
    public void addEdge(int source, Node node) {
        if (adj.get(source) != null) {
            adj.get(source).add(node);
        } else {
            adj.add(new ArrayList<>());
            adj.get(source).add(node);
        }
        if (!nodes.contains(node.getTargetVertex())) {
            nodes.add(node.getTargetVertex());
        }
        if (!nodes.contains(node.getSourceVertex())) {
            nodes.add(node.getSourceVertex());
        }
    }

    public ResultingNode[] findMSTUsingPrimsAlgorithm() {
        int currentVertex = source;
        ResultingNode[] resultingNodes = new ResultingNode[ V ];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        nodes.remove(source);
        pq.addAll(adj.get(currentVertex));
        while(!nodes.isEmpty()) {
            Node smallestEdge = pq.poll();
            if (nodes.contains(smallestEdge.getTargetVertex())) {
                nodes.remove(smallestEdge.getTargetVertex());
                resultingNodes[ smallestEdge.getTargetVertex() ] = new ResultingNode(smallestEdge.getCost(), smallestEdge.getSourceVertex());
                totalcost = totalcost + smallestEdge.getCost();
                currentVertex = smallestEdge.getTargetVertex();
                pq.addAll(adj.get(currentVertex));
            }
        }
        return resultingNodes;
    }
}
