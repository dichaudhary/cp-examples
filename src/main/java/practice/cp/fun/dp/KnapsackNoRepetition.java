package practice.cp.fun.dp;

public class KnapsackNoRepetition {
    int[] weight;
    int[] profit;
    int capacity;

    public KnapsackNoRepetition(int[] weight, int[] profit, int capacity) {
        this.weight = weight;
        this.profit = profit;
        this.capacity = capacity;
    }

    public int solveKnapsack() {
        int n = profit.length;
        int [][] dp = new int[capacity+1][profit.length];
        for (int i = 0; i<n; i++) {
            dp[0][i] = 0;
        }
        for (int j=0; j<=capacity; j++) {
            if (weight[0] <= j) {
                dp[j][0] = weight[0];
            }
        }
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j< dp[0].length; j++) {
                int profit1 = 0;
                int profit2 = 0;
                if (weight[j] <= i) {
                    profit1 = weight[j] + dp[i-weight[j]][j-1];
                }
                profit2 = dp[i][j-1];
                dp[i][j] = Integer.max(profit1, profit2);
            }
        }
        return dp[capacity][n-1];
    }
}
