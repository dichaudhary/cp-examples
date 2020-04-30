package practice.cp.fun.graph;

//this can be done using stack also which will be O(n)
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class TopologicalSorting {
    int V; // no of vertices in the graph
    int source; // source of the graph from which the shortest distance has to be measured
    public List<List<Node>> adj = new ArrayList<>();
    Map<Integer, Integer> incomingEdges = new HashMap<>();

    public TopologicalSorting(int V, int source) {
        this.V = V;
        this.source = source;
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<Node>());
            incomingEdges.put(i, 0);
        }
    }

    public void addEdge(int source, Node node) {
        if (adj.get(source) != null) {
            adj.get(source).add(node);
        } else {
            adj.add(new ArrayList<>());
            adj.get(source).add(node);
        }
        if (incomingEdges.get(node.getTargetVertex()) == null){
            incomingEdges.put(node.getTargetVertex(), 1);
        } else {
            incomingEdges.put(node.getTargetVertex(), incomingEdges.get(node.getTargetVertex())+1);
        }
    }

    public Integer[] topologicalSort() {
        Set<Map.Entry<Integer, Integer>> entrySet = incomingEdges.entrySet();
        List<Map.Entry<Integer, Integer>> sortedByValues = new ArrayList<>(entrySet);
        Collections.sort(sortedByValues, valueComparator);
        List<Integer> sortedVertices = sortedByValues.stream().map(entry->{
            return entry.getKey();
        }).collect(Collectors.toList());
        Iterator<Integer> integerIterator = sortedVertices.iterator();
        Integer[] sorted = new Integer[V];
        int i = 0;
        while(integerIterator.hasNext()) {
            sorted[i++] = integerIterator.next().intValue();
        }
        return sorted;
    }

    Comparator<Map.Entry<Integer, Integer>> valueComparator = (e1, e2) -> {
        Integer v1 = e1.getValue();
        Integer v2 = e2.getValue();
        return v1.compareTo(v2);
    };

    public void topologicalSortingUtil(int v, boolean[] visited, Stack<Integer> topologicalStack) {
        visited[v] = true;
        Iterator<Node> edges = adj.get(v).iterator();
        while (edges.hasNext()) {
            Node node = edges.next();
            if (!visited[node.getTargetVertex()]) {
                topologicalSortingUtil(node.getTargetVertex(), visited, topologicalStack);
            }
        }
        topologicalStack.push(v);
    }
}
