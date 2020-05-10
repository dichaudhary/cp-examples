package practice.cp.fun.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KruskalAlgorithm {
    int V; // no of vertices in the graph
    int source; // source of the graph from which the shortest distance has to be measured
    List<List<Node>> adj = new ArrayList<>();
    //this is one of the  difference between prims and kruskal algo we have exclusive list of all the edges
    List<Node> exclusiveList = new ArrayList<>();

    //this is not needed for kruskal
    Set<Integer> nodes = new HashSet<>();
    int e = 1;

    Subset[] subsets;

    public KruskalAlgorithm(int source, int V) {
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
        exclusiveList.add(node);
    }

    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(Subset Subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (Subsets[i].parent != i)
            Subsets[i].parent = find(Subsets, Subsets[i].parent);

        return Subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    void Union(Subset Subsets[], int x, int y)
    {
        int xroot = find(Subsets, x);
        int yroot = find(Subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (Subsets[xroot].rank < Subsets[yroot].rank)
            Subsets[xroot].parent = yroot;
        else if (Subsets[xroot].rank > Subsets[yroot].rank)
            Subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else
        {
            Subsets[yroot].parent = xroot;
            Subsets[xroot].rank++;
        }
    }
    public ResultingNode[] findMSTUsingKruskalAlgorithm() {
        ResultingNode[] resultingNodes = new ResultingNode[V];
        Collections.sort(exclusiveList);
        subsets = new Subset[V];
        for (int i=0; i<V; i++) {
            Subset subset = new Subset();
            subset.parent = i;
            subset.rank = 0;
            subsets[i] = subset;
        }
        while (e<V) {
            Node edge = exclusiveList.remove(0);
            int x = find(subsets, edge.getSourceVertex());
            int y = find(subsets, edge.getTargetVertex());
            if (x != y) {
                Union(subsets, x, y);
                ResultingNode resultingNode = new ResultingNode(edge.getCost(), edge.getSourceVertex());
                resultingNodes[edge.getTargetVertex()] = resultingNode;
                e++;
            }

        }
        return resultingNodes;
    }
}

class Subset
{
    int parent, rank;
};
