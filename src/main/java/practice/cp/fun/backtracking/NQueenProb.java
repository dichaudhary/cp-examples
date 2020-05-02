package practice.cp.fun.backtracking;

public class NQueenProb {
    public int[][] board;

    public NQueenProb(int[][] board) {
        this.board = board;
    }

    public boolean solveNQueen(int col) {
        if (col >= board.length) {
            return true;
        }
        for (int i=0; i<board.length; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solveNQueen(col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }


    public boolean isSafe(int row, int col) {
        int i, j;
        for (i=0; i<col; i++) {
            if (board[row][i]==1) {
                return false;
            }
        }
        for (i= row-1, j= col-1; i>=0 && j>=0 ; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i= row+1, j= col-1; j>=0 && i<board.length ; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
