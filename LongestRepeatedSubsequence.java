//Input: str = "aabb"
//Output: "ab"


public class LongestRepeatedSubsequence {
    static String longestRepeatedSubSeq(String str)
    {
        int n = str.length();
        
        // Create and initialize DP table
        int dp[][] = new int[n+1][n+1];
        for (int i=0; i<=n; i++)
            for (int j=0; j<=n; j++)
                dp[i][j] = 0;
        
        // Fill dp table (similar to LCS loops)
        for (int i=1; i<=n; i++)
        {
            for (int j=1; j<=n; j++)
            {
                // If characters match and indexes are 
                // not same
                if (str.charAt(i-1)== str.charAt(j-1) && i != j)  //only change
                    dp[i][j] =  1 + dp[i-1][j-1];          
                             
                // If characters do not match
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        //Printing Longest Repeated Subsequence
        String res = "";
        int i = n, j = n;
        while (i > 0 && j > 0)
        {
            // If this cell is same as diagonally
        // adjacent cell just above it, then 
        // same characters are present at 
        // str[i-1] and str[j-1]. Append any 
        // of them to result.
        if (dp[i][j] == dp[i - 1][j - 1] + 1)
        {
        res = res + str.charAt(i - 1);
        i--;
        j--;
        }
  
        // Otherwise we move to the side
        // that that gave us maximum result
        else if (dp[i][j] == dp[i - 1][j])
            i--;
        else
            j--;
        }
        // Since we traverse dp[][] from bottom,
    // we get result in reverse order.
    String reverse = "";
          
          
    for(int k = res.length() - 1; k >= 0; k--)
        {
            reverse = reverse + res.charAt(k);
        } 
  
  
    return reverse;
}
  
// Driver code
public static void main(String args[])
{
    String str = "AABEBCDD";
    System.out.println(longestRepeatedSubSeq(str));
}
}


