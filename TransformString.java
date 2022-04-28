//Minimum number of deletions and insertions to transform one string into another

public class TransformString {
    public static int lps(String str) {
        StringBuffer sb = new StringBuffer(str);
        String sReverse = sb.reverse().toString();
        int m = str.length();
        int n = sReverse.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(str.charAt(i-1) == sReverse.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    } 

    public static int minNumDeletions(String str) {
        int n = str.length();
        int len = lps(str);
        return n-len;
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
       
          // Function Call
          System.out.println("Minimum Number of Deletion is"+" "+minNumDeletions(str));
    }
}
