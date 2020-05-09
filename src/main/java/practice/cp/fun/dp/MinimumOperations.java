/*You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:

       1. Double the number
       2.Add one to the number*/

package practice.cp.fun.dp;

public class MinimumOperations {
    public int N;
    public int[] dp;

    public MinimumOperations(int N) {
        this.N = N;
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
    }

    public int getMinimumOperations() {
        for (int i= 3;i<=N; i++) {
            int first , second;
            if (i%2==0) {
                first = dp[i/2]+1;
                second = dp[i-1]+1;
            }  else {
                first = dp[(i-1)/2] + 2;
                second = dp[i-1] + 1;
            }
            dp[i] = Math.min(first, second);
        }
        return dp[N];
    }

    /*public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int N = s.nextInt();
            int[] dp;
            dp = new int[ N + 1 ];
            dp[ 0 ] = 0;
            dp[ 1 ] = 1;
            dp[ 2 ] = 2;
            for (int j = 3; j <= N; j++) {
                int first, second;
                if (j % 2 == 0) {
                    first = dp[ j / 2 ] + 1;
                    second = dp[ j - 1 ] + 1;
                } else {
                    first = dp[ (j - 1) / 2 ] + 2;
                    second = dp[ j - 1 ] + 1;
                }
                dp[ j ] = Math.min(first, second);
            }
            System.out.println(dp[ N ]);
        }
    }*/

}
