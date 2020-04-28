package practice.cp.fun.dp;

public class ExecuteFun {
    public static void main (String ...args) {
        KnapsackNoRepetition knapsackNoRepetition = new KnapsackNoRepetition(new int[] {1, 5, 3, 9}, new int[] {4, 3, 5, 7}, 10);
        knapsackNoRepetition.solveKnapsack();
    }
}
