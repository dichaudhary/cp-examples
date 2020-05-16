package practice.cp.fun.dp;

import practice.cp.fun.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathFromSRCToDEST {
    public boolean[][] visited;
    public int[][] matrix;
    public int destRow;
    public int destCol;
    public int minSteps;
    public int r;
    public int c;
    public int[][] dp;
    public List<List<Node>> adj = new ArrayList<>();

    public ShortestPathFromSRCToDEST(int[][] matrix, int sourceRow, int sourceCol, int destRow, int destCol) {
        this.matrix = matrix;
        this.destRow = destRow-sourceRow;
        this.destCol = destCol-sourceCol;
        this.r = matrix.length;
        this.c = matrix[0].length;
        this.dp = new int[this.destRow+1][this.destCol+1];
        for (int i=0; i<=this.destRow; i++) {
            for (int j=0; j<=this.destCol; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        dp[0][1] = matrix[0][1] == 1 ? 1 : dp[0][1];
        dp[1][0] = matrix[1][0] == 1 ? 1 : dp[1][0];
        dp[1][1] = matrix[1][1] == 1 ? 1 : dp[1][1];
    }

    public ShortestPathFromSRCToDEST(int[][] matrix, int sourceRow, int sourceCol, int destRow, int destCol, boolean isGraph) {
        this.matrix = matrix;
        this.destRow = destRow-sourceRow;
        this.destCol = destCol-sourceCol;
        this.r = matrix.length;
        this.c = matrix[0].length;
        for (int i=0; i<=this.destRow; i++) {
            for (int j=0; j<=this.destCol; j++) {
                if (matrix[i][j] == 1) {
                    //add an edge
                    if (adj.get(i) != null) {
                        adj.get(i).add(new Node(i, j, 0));
                    } else {
                        List<Node> edges = new ArrayList<>();
                        edges.add(new Node(i, j, 0));
                        adj.add(edges);
                    }
                }
            }
        }
        visited = new boolean[r][c];
    }

    public int getShortestPath() {
        return getShortestPathUtil(0, 0, this.destRow, this.destCol);
    }

    public int getShortestPathUsingGraph() {
        return getShortestPathUtilUsingGraph(0, 0);
    }

    private int getShortestPathUtilUsingGraph(int currentRow, int currrentCol) {
        for (int i=0; i<=destRow; i++) {
            for (int j=0; j<=destCol; j++) {
                int up = Integer.MAX_VALUE,down = Integer.MAX_VALUE,left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if (i>0 && matrix[i-1][j]==1 && dp[ i - 1 ][ j ] != Integer.MAX_VALUE) {
                    up = dp[ i - 1 ][ j ] + 1;
                }
                if (i<destRow && matrix[ i + 1 ][ j ]==1 && dp[ i + 1 ][ j ]!=Integer.MAX_VALUE) {
                    down = dp[ i + 1 ][ j ] + 1;
                }
                if (j<destCol && matrix[ i ][ j + 1 ]==1 && dp[ i ][ j + 1 ]!=Integer.MAX_VALUE) {
                    right = dp[ i ][ j + 1 ] + 1;
                }
                if (j>0 && matrix[i][j-1]==1 && dp[i][j-1]!=Integer.MAX_VALUE) {
                    left = dp[i][j-1] + 1;
                }
                dp[i][j] = Integer.min(Integer.min(up, down),Integer.min(left, right));
            }
        }
        return 0;
    }

    //not the right way we end up missing some paths
    private int getShortestPathUtil(int sourceRow, int sourceCol, int destRow, int destCol) {
        for (int i=0; i<=destRow; i++) {
            for (int j=0; j<=destCol; j++) {
                int up = Integer.MAX_VALUE,down = Integer.MAX_VALUE,left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if (i>0 && matrix[i-1][j]==1 && dp[ i - 1 ][ j ] != Integer.MAX_VALUE) {
                    up = dp[ i - 1 ][ j ] + 1;
                }
                if (i<destRow && matrix[ i + 1 ][ j ]==1 && dp[ i + 1 ][ j ]!=Integer.MAX_VALUE) {
                    down = dp[ i + 1 ][ j ] + 1;
                }
                if (j<destCol && matrix[ i ][ j + 1 ]==1 && dp[ i ][ j + 1 ]!=Integer.MAX_VALUE) {
                    right = dp[ i ][ j + 1 ] + 1;
                }
                if (j>0 && matrix[i][j-1]==1 && dp[i][j-1]!=Integer.MAX_VALUE) {
                    left = dp[i][j-1] + 1;
                }
                dp[i][j] = Integer.min(Integer.min(up, down),Integer.min(left, right));
            }
        }
        for (int i=destRow; i>=0; i--) {
            for (int j=destCol; j>=0; j--) {
                int up = Integer.MAX_VALUE,down = Integer.MAX_VALUE,left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if (i>0 && matrix[i-1][j]==1 && dp[ i - 1 ][ j ] != Integer.MAX_VALUE) {
                    up = dp[ i - 1 ][ j ] + 1;
                }
                if (i<destRow && matrix[ i + 1 ][ j ]==1 && dp[ i + 1 ][ j ]!=Integer.MAX_VALUE) {
                    down = dp[ i + 1 ][ j ] + 1;
                }
                if (j<destCol && matrix[ i ][ j + 1 ]==1 && dp[ i ][ j + 1 ]!=Integer.MAX_VALUE) {
                    right = dp[ i ][ j + 1 ] + 1;
                }
                if (j>0 && matrix[i][j-1]==1 && dp[i][j-1]!=Integer.MAX_VALUE) {
                    left = dp[i][j-1] + 1;
                }
                dp[i][j] = Integer.min(dp[i][j], Integer.min(Integer.min(up, down),Integer.min(left, right)));
            }
        }
        return dp[destRow][destCol];
    }

}
