public class PrintingLCS {
    public String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return LCS(text1, text2, m, n);
    }

    public String LCS(String text1, String text2, int m, int n) {
        int[][] dp = new int[1001][1001];
        for(int i=0; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(i == 0 || j == 0)
                dp[i][j] = 0;
            }
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0) {
            if(text1.charAt(i-1) == text2.charAt(j-1)) {
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else {
                if(dp[i][j-1] > dp[i-1][j]) {
                    j--;
                }
                else {
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
