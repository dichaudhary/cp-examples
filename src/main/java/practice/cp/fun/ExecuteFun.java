package practice.cp.fun;

import practice.cp.fun.dp.KnapsackNoRepetition;
import practice.cp.fun.graph.BellmanFord;
import practice.cp.fun.graph.Dijkstra;
import practice.cp.fun.graph.Node;
import practice.cp.fun.graph.ResultingNode;
import practice.cp.fun.graph.TopologicalShortestPath;
import practice.cp.fun.graph.TopologicalSorting;

import java.util.Stack;
import java.util.stream.Collectors;

public class ExecuteFun {
    public static void main (String ...args) {
        KnapsackNoRepetition knapsackNoRepetition = new KnapsackNoRepetition(new int[] {1, 5, 3, 9}, new int[] {4, 3, 5, 7}, 10);
        knapsackNoRepetition.solveKnapsack();

        Dijkstra dijkstra = new Dijkstra(5, 0);
        dijkstra.addEdge(0, new Node(0, 1, 9));
        dijkstra.addEdge(0, new Node(0, 2, 6));
        dijkstra.addEdge(0, new Node(0, 3, 5));
        dijkstra.addEdge(0, new Node(0, 4, 3));
        dijkstra.addEdge(0, new Node(2, 1, 2));
        dijkstra.addEdge(0, new Node(2, 3, 4));
        ResultingNode[] resultingNodes = dijkstra.findShortestPathToEachNode();


        BellmanFord bellmanFord = new BellmanFord(5, 0);
        bellmanFord.addEdge(0, new Node(0, 1, -1));
        bellmanFord.addEdge(0, new Node(0, 2, 4));
        bellmanFord.addEdge(1, new Node(1, 2, 3));
        bellmanFord.addEdge(1, new Node(1, 3, 2));
        bellmanFord.addEdge(1, new Node(1, 4, 2));
        bellmanFord.addEdge(3, new Node(3, 1, 1));
        bellmanFord.addEdge(3, new Node(3, 2, 5));
        bellmanFord.addEdge(4, new Node(4, 3, -3));
        ResultingNode[] resultingNode = bellmanFord.findShortestPathToEachNode();


        TopologicalSorting topologicalSorting = new TopologicalSorting(6, 0);
        topologicalSorting.addEdge(0, new Node(0, 1, 5));
        topologicalSorting.addEdge(0, new Node(0, 2, 3));
        topologicalSorting.addEdge(1, new Node(1, 3, 6));
        topologicalSorting.addEdge(1, new Node(1, 2, 2));
        topologicalSorting.addEdge(2, new Node(2, 4, 4));
        topologicalSorting.addEdge(2, new Node(2, 5, 2));
        topologicalSorting.addEdge(2, new Node(2, 3, 7));
        topologicalSorting.addEdge(3, new Node(3, 4, -1));
        topologicalSorting.addEdge(4, new Node(4, 5, -2));
        Integer[] integers = topologicalSorting.topologicalSort();
        Stack<Integer> topologicalStack = new Stack<Integer>();
        topologicalSorting.topologicalSortingUtil(0, new boolean[6], topologicalStack);
        TopologicalShortestPath topologicalShortestPath = new TopologicalShortestPath(6, topologicalSorting.adj, 1);
        ResultingNode[] results = topologicalShortestPath.findShortestPathToEachNode(integers);
        ResultingNode[] resultingNodes1 = topologicalShortestPath.findShortestPathToEachNode(topologicalStack);
    }
}
