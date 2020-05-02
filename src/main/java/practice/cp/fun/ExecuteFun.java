package practice.cp.fun;

import practice.cp.fun.backtracking.GraphColoring;
import practice.cp.fun.backtracking.NQueenProb;
import practice.cp.fun.dp.KnapsackNoRepetition;
import practice.cp.fun.graph.BellmanFord;
import practice.cp.fun.graph.Dijkstra;
import practice.cp.fun.graph.Node;
import practice.cp.fun.graph.ResultingNode;
import practice.cp.fun.graph.TopologicalShortestPath;
import practice.cp.fun.graph.TopologicalSorting;
import practice.cp.fun.sort.MergeSort;
import practice.cp.fun.sort.QuickSort;

import java.util.Stack;

public class ExecuteFun {
    public static void main (String ...args) {
        //dp
        solveKnapsack();
        solveDijkstra();
        //graph
        solveBellmanFord();
        solveTopological();
        //backtracking
        solveNQueen();
        solveGraphColoring();
        //soring
        mergeSort();
        quickSort();
    }

    private static void solveTopological() {
        TopologicalSorting topologicalSorting = getTopologicalSortingObject();
        Integer[] integers = solveTopologicalSorting();
        Stack<Integer> topologicalStack = new Stack<Integer>();
        topologicalSorting.topologicalSortingUtil(0, new boolean[6], topologicalStack);
        TopologicalShortestPath topologicalShortestPath = new TopologicalShortestPath(6, topologicalSorting.adj, 1);
        ResultingNode[] results = topologicalShortestPath.findShortestPathToEachNode(integers);
        ResultingNode[] resultingNodes1 = topologicalShortestPath.findShortestPathToEachNode(topologicalStack);
    }

    private static void quickSort() {
        int[] arr;
        arr = new int[] {7, 6, 9, 3, 10, 1, 2, 80, 50, 5, 3, 10, 6};
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(arr, 0, arr.length-1);
    }

    private static void mergeSort() {
        int[] arr = new int[] {7, 6, 9, 3, 10, 1, 2, 80, 50, 5, 3, 10, 6};
        MergeSort mergeSort = new MergeSort(arr, arr.length);
        arr = mergeSort.doMergeSort(arr, 0, arr.length-1);
    }

    private static void solveGraphColoring() {
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        GraphColoring graphColoring = new GraphColoring(graph, new int[4], 4, 3);
        int [] color = graphColoring.colorGraph();
    }

    private static void solveNQueen() {
        int[][] board = new int[4][4];
        NQueenProb nQueenProb = new NQueenProb(board);
        nQueenProb.solveNQueen(0);
    }

    private static Integer[] solveTopologicalSorting() {
        TopologicalSorting topologicalSorting = getTopologicalSortingObject();
        return topologicalSorting.topologicalSort();
    }

    private static TopologicalSorting getTopologicalSortingObject() {
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
        return topologicalSorting;
    }

    private static void solveKnapsack() {
        KnapsackNoRepetition knapsackNoRepetition = new KnapsackNoRepetition(new int[] {1, 5, 3, 9}, new int[] {4, 3, 5, 7}, 10);
        knapsackNoRepetition.solveKnapsack();
    }

    private static void solveBellmanFord() {
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
    }

    private static void solveDijkstra() {
        Dijkstra dijkstra = new Dijkstra(5, 0);
        dijkstra.addEdge(0, new Node(0, 1, 9));
        dijkstra.addEdge(0, new Node(0, 2, 6));
        dijkstra.addEdge(0, new Node(0, 3, 5));
        dijkstra.addEdge(0, new Node(0, 4, 3));
        dijkstra.addEdge(0, new Node(2, 1, 2));
        dijkstra.addEdge(0, new Node(2, 3, 4));
        ResultingNode[] resultingNodes = dijkstra.findShortestPathToEachNode();
    }
}
