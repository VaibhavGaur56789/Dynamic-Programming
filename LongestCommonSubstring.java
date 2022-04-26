// Same as LCS(Longest common Subsequence) with minor change

public class LongestCommonSubstring {
    public int longestCommonSubstring(String x, String y) {
        int m = x.length();
        int n = y.length();
        int maxLen = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 0;                     //Change 1
                }
                maxLen = Math.max(dp[i][j], maxLen);  //Change 2
            }
        }
        return maxLen;
    }
}
