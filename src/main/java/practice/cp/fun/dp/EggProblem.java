/*Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break.
 You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.
 There are few rules given below.

    An egg that survives a fall can be used again.
    A broken egg must be discarded.
    The effect of a fall is the same for all eggs.
    If the egg doesn't break at a certain floor, it will not break at any floor below.
    If the eggs breaks at a certain floor, it will break at any floor above.
    */

package practice.cp.fun.dp;

public class EggProblem {
    public int nEggs;
    public int kFloors;
    public int[][] dp;

    public EggProblem(int nEggs, int kFloors) {
        this.nEggs = nEggs;
        this.kFloors = kFloors;
        dp = new int[nEggs+1][kFloors+1];
        for (int i=0; i<=nEggs;i++) {
            dp[i][0]=0;
        }
        for (int i=0; i<=kFloors;i++) {
            dp[0][i]=0;
            dp[1][i]=i;
        }
    }

    public int findEggNonBreaking() {
        return findEggNonBreakingFloorUtil(nEggs, kFloors);
    }

    private int findEggNonBreakingFloorUtil(int nEggs, int kFloors) {
        for (int i=2; i<=nEggs;i++) {
            for (int j=1; j<=kFloors;j++) {
                int minimum=Integer.MAX_VALUE;
                for (int k=1; k<=j;k++) {
                    minimum = Math.min(minimum, 1 + Math.max(dp[ i - 1 ][ k - 1 ], dp[ i ][ j - k ]));
                }
                dp[i][j] = minimum;
            }
        }
        //Prints numeggs
        for(int i=0;i<=nEggs;i++){
            for(int j=0;j<=kFloors;j++){
                System.out.println(dp[i][j]);
            }
        }
        return dp[nEggs][kFloors];
    }
}
