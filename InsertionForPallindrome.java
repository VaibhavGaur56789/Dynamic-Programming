public class InsertionForPallindrome {
    public int minInsertions(String s) {
        StringBuffer sb = new StringBuffer(s);
        String sReverse = sb.reverse().toString();
        
        int m = s.length();
        int n = sReverse.length();
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i == 0 || j == 0) 
                    dp[i][j] = 0;
                else if(s.charAt(i-1) == sReverse.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return m - dp[m][n];
    }
}
