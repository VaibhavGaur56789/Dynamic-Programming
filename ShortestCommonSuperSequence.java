public class ShortestCommonSuperSequence {
    public static int shortestCommonSuperSequence(String x, String y) {
        int m = x.length();
        int n = y.length();
        int l = LCS(x, y, m, n);
        
        return m + n - l;
    }

    public static int LCS(String x, String y, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i == 0 || j == 0)
                dp[i][j] = 0;

                else if(x.charAt(i-1) == y.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];

                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }

        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of the shortest "+ "supersequence is "+ shortestSuperSequence(X, Y));
    }
}
