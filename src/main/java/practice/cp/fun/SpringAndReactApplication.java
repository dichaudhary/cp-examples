package practice.cp.fun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import practice.cp.fun.backtracking.GraphColoring;
import practice.cp.fun.backtracking.NQueenProb;
import practice.cp.fun.bitmagic.MaximumSubsetXOR;
import practice.cp.fun.dp.Box;
import practice.cp.fun.dp.BoxStackingProblem;
import practice.cp.fun.dp.KnapsackNoRepetition;
import practice.cp.fun.dp.MaxLengthChain;
import practice.cp.fun.dp.MaxLengthChainTopDown;
import practice.cp.fun.dp.MinimumOperations;
import practice.cp.fun.dp.ShortestPathFromSRCToDEST;
import practice.cp.fun.graph.BellmanFord;
import practice.cp.fun.graph.Dijkstra;
import practice.cp.fun.graph.KruskalAlgorithm;
import practice.cp.fun.graph.Node;
import practice.cp.fun.graph.PrimsAlgorithm;
import practice.cp.fun.graph.SortedDictionaryAlienLanguage;
import practice.cp.fun.graph.TopologicalShortestPath;
import practice.cp.fun.graph.TopologicalSorting;
import practice.cp.fun.recursion.EggProblem;
import practice.cp.fun.sort.HeapSort;
import practice.cp.fun.sort.MergeSort;
import practice.cp.fun.sort.QuickSort;

import java.util.Stack;

@SpringBootApplication
public class SpringAndReactApplication {

	public static void main(String[] args) {
		solveKnapsack();
		solveDijkstra();
		//graph
		solveBellmanFord();
		solveTopological();
		solveEggProblem();
		solvePrimsAlgo();
		solveKruskalAlgo();
		solveAlienDictionary();
		//backtracking
		solveNQueen();
		solveGraphColoring();
		//soring
		mergeSort();
		quickSort();
		heapSort();
		//more standard dp problems
		solveMinimumOperations();
		solveMaxLengthChain();
		solveBoxStackingProb();
		solveSRTPathFromSRCToDest();
		//recursion
		solveEggProblemRecursion();
		//bit magic
		solveGausianElimination();
		//spring boot jar
		SpringApplication.run(SpringAndReactApplication.class, args);
	}

	private static void solveSRTPathFromSRCToDest() {
		int[][] matrix = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
				{0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
				{1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
				{1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
		ShortestPathFromSRCToDEST shortestPathFromSRCToDEST = new ShortestPathFromSRCToDEST(matrix, 0, 0, 8, 9);
		shortestPathFromSRCToDEST.getShortestPath();
	}

	private static void solveAlienDictionary() {
		SortedDictionaryAlienLanguage sortedDictionaryAlienLanguage = new SortedDictionaryAlienLanguage(new String[]{"baa", "abcd", "abca", "cab", "cad"}, 4);
		sortedDictionaryAlienLanguage.getSortedVertices();
	}

	private static void solveKruskalAlgo() {
		KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(0, 5);
		kruskalAlgorithm.addEdge(0, new Node(0, 1, 2));
		kruskalAlgorithm.addEdge(0, new Node(0, 3, 6));
		kruskalAlgorithm.addEdge(1, new Node(1, 2, 3));
		kruskalAlgorithm.addEdge(1, new Node(1, 3, 8));
		kruskalAlgorithm.addEdge(1, new Node(1, 4, 5));
		kruskalAlgorithm.addEdge(2, new Node(2, 4, 7));
		kruskalAlgorithm.addEdge(3, new Node(3, 4, 9));
		kruskalAlgorithm.findMSTUsingKruskalAlgorithm();
	}

	private static void solvePrimsAlgo() {
		PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm(0, 5);
		primsAlgorithm.addEdge(0, new Node(0, 1, 2));
		primsAlgorithm.addEdge(0, new Node(0, 3, 6));
		primsAlgorithm.addEdge(1, new Node(1, 2, 3));
		primsAlgorithm.addEdge(1, new Node(1, 3, 8));
		primsAlgorithm.addEdge(1, new Node(1, 4, 5));
		primsAlgorithm.addEdge(2, new Node(2, 4, 7));
		primsAlgorithm.addEdge(3, new Node(3, 4, 9));
		primsAlgorithm.findMSTUsingPrimsAlgorithm();
	}

	private static void solveGausianElimination() {
		MaximumSubsetXOR maximumSubsetXOR = new MaximumSubsetXOR(new int[]{1, 2, 3, 4, 5, 6, 22, 33, 44, 22, 111});
		maximumSubsetXOR.getMaximumsubsetXOR();
	}

	private static void solveEggProblem() {
		practice.cp.fun.dp.EggProblem eggProblem = new practice.cp.fun.dp.EggProblem(2, 10);
		eggProblem.findEggNonBreaking();
	}

	private static void solveEggProblemRecursion() {
		EggProblem eggProblem = new EggProblem(2, 10);
		eggProblem.findEggNonBreakingFloorRecursive();
	}

	private static void solveBoxStackingProb() {
		Box[] arr = new Box[4];
		arr[0] = new Box(4, 6, 7);
		arr[1] = new Box(1, 2, 3);
		arr[2] = new Box(4, 5, 6);
		arr[3] = new Box(10, 12, 32);
		BoxStackingProblem boxStackingProblem = new BoxStackingProblem(arr);
		boxStackingProblem.getMaxHeight();
	}

	private static void solveMaxLengthChain() {
		MaxLengthChain maxLengthChain = new MaxLengthChain(new int[][] {{778, 887}, {794, 916}, {336, 387}, {493, 650}, {363, 422}, {28, 691}, {60, 764}, {541, 927}, {173, 427}, {212, 737}, {369, 568}, {430, 783}, {531, 863}, {68, 124}, {136, 930}, {23, 803}, {59, 70}, {168, 394}, {12, 457}, {43, 230}, {374, 422}, {785, 920}, {199, 538}, {316, 325}, {371, 414}, {92, 527}, {957, 981}, {863, 874}, {171, 997}, {282, 306}, {85, 926}, {328, 337}, {506, 847}, {314, 730}});
		maxLengthChain.getMaxLengthChain();
		MaxLengthChainTopDown maxLengthChainTopDown = new MaxLengthChainTopDown(new int[][] {{778, 887}, {794, 916}, {336, 387}, {493, 650}, {363, 422}, {28, 691}, {60, 764}, {541, 927}, {173, 427}, {212, 737}, {369, 568}, {430, 783}, {531, 863}, {68, 124}, {136, 930}, {23, 803}, {59, 70}, {168, 394}, {12, 457}, {43, 230}, {374, 422}, {785, 920}, {199, 538}, {316, 325}, {371, 414}, {92, 527}, {957, 981}, {863, 874}, {171, 997}, {282, 306}, {85, 926}, {328, 337}, {506, 847}, {314, 730}});
        maxLengthChainTopDown.getMaxLengthChain(0, 0, 1);
	}

	private static void solveMinimumOperations() {
		MinimumOperations minimumOperations = new MinimumOperations(8);
		minimumOperations.getMinimumOperations();
	}

	private static void heapSort() {
		HeapSort heapSort = new HeapSort(new int[]{7, 6, 9, 3, 10, 1, 2, 80, 50, 5, 3, 10, 6}, 13);
		heapSort.heapSort();
	}

	private static void solveTopological() {
		TopologicalSorting topologicalSorting = getTopologicalSortingObject();
		Integer[] integers = solveTopologicalSorting();
		Stack<Integer> topologicalStack = new Stack<Integer>();
		topologicalSorting.topologicalSortingUtil(0, new boolean[6], topologicalStack);
		TopologicalShortestPath topologicalShortestPath = new TopologicalShortestPath(6, topologicalSorting.adj, 1);
		topologicalShortestPath.findShortestPathToEachNode(integers);
		topologicalShortestPath.findShortestPathToEachNode(topologicalStack);
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
		mergeSort.doMergeSort(arr, 0, arr.length-1);
	}

	private static void solveGraphColoring() {
		int graph[][] = {{0, 1, 1, 1},
				{1, 0, 1, 0},
				{1, 1, 0, 1},
				{1, 0, 1, 0},
		};
		GraphColoring graphColoring = new GraphColoring(graph, new int[4], 4, 3);
		graphColoring.colorGraph();
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
		bellmanFord.findShortestPathToEachNode();
	}

	private static void solveDijkstra() {
		Dijkstra dijkstra = new Dijkstra(5, 0);
		dijkstra.addEdge(0, new Node(0, 1, 9));
		dijkstra.addEdge(0, new Node(0, 2, 6));
		dijkstra.addEdge(0, new Node(0, 3, 5));
		dijkstra.addEdge(0, new Node(0, 4, 3));
		dijkstra.addEdge(0, new Node(2, 1, 2));
		dijkstra.addEdge(0, new Node(2, 3, 4));
		dijkstra.findShortestPathToEachNode();
	}
}
