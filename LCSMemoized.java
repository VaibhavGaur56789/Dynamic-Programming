public class LCSMemoized {
    
    //
    public static int LCS(char[] x, char[] y, int m, int n, int[][] dp) {
        if(m == 0 || n == 0) {
            return 0;
        }
        if(x[m-1] == y[n-1]) {
            return dp[m][n] = 1 + LCS(x, y, m-1, n-1, dp);
        }
        if(dp[m][n] != -1) {
            return dp[m][n];
        }
        return dp[m][n] = Math.max(LCS(x, y, m, n-1, dp), LCS(x, y, m-1, n, dp));
    }

    public int max(int a, int b)
    {
        return (a > b)? a : b;
    }

    public static void main(String[] args) {
        LCSMemoized lcs = new LCSMemoized();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int m = x.length;
        int n = y.length;
        int dp[][] = new int[m+1][n+1];
        System.out.println("Length of LCS is" + " " + lcs.LCS(x, y, m, n,dp));
    }
}
