package practice.cp.fun.dp;

import org.junit.Assert;
import org.junit.Test;
import practice.cp.fun.graph.Dijkstra;
import practice.cp.fun.graph.Node;
import practice.cp.fun.graph.ResultingNode;

public class TestDPSolutions {

    @Test
    public void testKnapsack() {
        KnapsackNoRepetition knapsackNoRepetition = new KnapsackNoRepetition(new int[] {1, 5, 3, 9}, new int[] {4, 3, 5, 7}, 10);
        Assert.assertEquals(knapsackNoRepetition.solveKnapsack(), 10);
    }

    @Test
    public void testDijkstra() {
        Dijkstra dijkstra = new Dijkstra(5, 0);
        dijkstra.addEdge(0, new Node(0, 1, 9));
        dijkstra.addEdge(0, new Node(0, 2, 6));
        dijkstra.addEdge(0, new Node(0, 3, 5));
        dijkstra.addEdge(0, new Node(0, 4, 3));
        dijkstra.addEdge(2, new Node(2, 1, 2));
        dijkstra.addEdge(2, new Node(2, 3, 4));
        ResultingNode[] resultingNodes = dijkstra.findShortestPathToEachNode();
        Assert.assertEquals(resultingNodes[0].cost, 0);
        Assert.assertEquals(resultingNodes[1].cost, 8);
    }
}
