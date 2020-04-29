package practice.cp.fun;

import practice.cp.fun.dp.KnapsackNoRepetition;
import practice.cp.fun.graph.Dijkstra;
import practice.cp.fun.graph.Node;
import practice.cp.fun.graph.ResultingNode;

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
        System.out.println(resultingNodes[2]);
    }
}
