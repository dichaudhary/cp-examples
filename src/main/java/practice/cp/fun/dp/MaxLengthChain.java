package practice.cp.fun.dp;

public class MaxLengthChain {
    int[][] numberPairs ;
    int[] dp;
    boolean[][][]check;
    int noOfRows;

    public MaxLengthChain(int[][] numberPairs) {
        this.noOfRows = numberPairs.length;
        this.numberPairs = numberPairs;
        dp = new int[noOfRows];
        for (int i=0; i<noOfRows; i++) {
            dp[i] = 1;
        }
    }

    public int getMaxLengthChain() {
        for (int i=1; i<noOfRows; i++) {
            for (int j=0; j<i; j++) {
                if (numberPairs[i][0] > numberPairs[j][1] && dp[i]< dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = -1;
        for (int i=0; i<noOfRows; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
