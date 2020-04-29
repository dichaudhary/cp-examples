package practice.cp.fun.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    int V; // no of vertices in the graph
    int source; // source of the graph from which the shortest distance has to be measured
    List<List<Node>> adj = new ArrayList<>();

    public Dijkstra(int V, int source) {
        this.V = V;
        this.source = source;
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
    }

    public ResultingNode[] findShortestPathToEachNode() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Node> sourceEdges =  adj.get(source);
        ResultingNode[] shortestDistances = new ResultingNode[this.V];
        for (int i=0; i<this.V; i++) {
            shortestDistances[i] = new ResultingNode(Integer.MAX_VALUE, 0);
        }
        shortestDistances[this.source] = new ResultingNode(0, 0);
        sourceEdges.forEach(edge-> {
           pq.add(edge);
        });
        while (!pq.isEmpty()) {
            Node p = pq.poll();
            int targetVertex = p.getTargetVertex();
            int cost = p.getCost();
            if(shortestDistances[targetVertex].cost > shortestDistances[p.getSourceVertex()].cost + cost) {
                shortestDistances[targetVertex].predecessor = p.getSourceVertex();
                shortestDistances[targetVertex].cost = shortestDistances[p.getSourceVertex()].cost + cost;
                adj.get(targetVertex).stream().forEach(edge-> {
                    pq.add(edge);
                });
            }
        }
        return shortestDistances;
    }
}

