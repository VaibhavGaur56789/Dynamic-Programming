//Minimum number of deletions to make a string palindrome

public class MinimumDeletionForPallindromic {
    public static int lps(String s) {
        StringBuffer sb = new StringBuffer(s);
        String sReverse = sb.reverse().toString();
        int m = s.length();
        int n = sReverse.length();
        int[][] dp = new int[m+1][n+1];
        
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
        return dp[m][n];
    }

    static int minimumNumberOfDeletions(String str)
    {
        int n = str.length();
 
        // Find longest palindromic
        // subsequence
        int len = lps(str);
 
        // After removing characters
        // other than the lps, we get
        // palindrome.
        return (n - len);
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        String str = "geeksforgeeks";
        System.out.println("Minimum number " +
                            "of deletions = "+
               minimumNumberOfDeletions(str));
    }
}
