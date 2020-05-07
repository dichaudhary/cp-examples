package practice.cp.fun.dp;

class LPS {

    public int[][] findLPSLength(String st) {
        // dp[i][j] stores the length of LPS from index 'i' to index 'j'
        int[][] dp = new int[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = 1;

        for (int endIndex = 0; endIndex <st.length(); endIndex++) {
            for (int startIndex = 0; startIndex < endIndex; startIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        LPS lps = new LPS();
        int[][] dp = lps.findLPSLength("pqr");
        for (int k = 0; k < dp.length; k++) {         //this equals to the row in our matrix.
            for (int l = 0; l < dp[k].length; l++) {   //this equals to the column in each row.
                System.out.print(dp[k][l] + " ");
            }
            System.out.println();//change line on console as row comes to end in the matrix.
        }
        //System.out.println(lps.findLPSLength("abdbca"));
        //System.out.println(lps.findLPSLength("cddpd"));
        //System.out.println(lps.findLPSLength("pqr"));
    }
}
