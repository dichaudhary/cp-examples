package practice.cp.fun.dp;

public class MaxLengthChainTopDown {
    int[][] numberPairs ;
    int[][] dp;
    int noOfRows;

    public MaxLengthChainTopDown(int[][] numberPairs) {
        this.noOfRows = numberPairs.length;
        this.numberPairs = numberPairs;
        dp = new int[noOfRows][noOfRows];
    }

    /*public int getMaxLengthChain(int count, int prev, int i) {
        if (i>=noOfRows) {
            return count;
        }
        int first = 0, second = 0, third = 0;
        if (numberPairs[prev][1] < numberPairs[i][0]) {
            first = getMaxLengthChain(count + 1, i, i+1);
        }
        second = getMaxLengthChain(count, prev, i+1);
        if (prev<i-1) {
            third = getMaxLengthChain(count, prev + 1, i);
        }
        return Math.max(first, Math.max(second, third));
    }*/

    //this seems to be wrong
    public int getMaxLengthChain(int count, int prev, int i) {
        if (i>=noOfRows) {
            return count;
        }
        if (dp[prev][i]==0) {
            int first = 0, second = 0, third = 0;
            if (numberPairs[ prev ][ 1 ] < numberPairs[ i ][ 0 ]) {
                first = getMaxLengthChain(count + 1, i, i + 1);
            }
            second = getMaxLengthChain(count, prev, i + 1);
            if (prev < i - 1) {
                third = getMaxLengthChain(count, prev + 1, i);
            }
            dp[prev][i]= Math.max(first, Math.max(second, third));
        }
        return dp[prev][i];
    }
}
