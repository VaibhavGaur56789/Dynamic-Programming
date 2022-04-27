//Minimum number of deletions and insertions to transform one string into another

public class TransformString {
    public static int lcs(String str1, String str2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i == 0 || j == 0)
                dp[i][j] = 0;
                
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];

                else 
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    public static void printMinDelAndIns(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int len = lcs(str1, str2, m, n);
        System.out.println("Minimum number of "+ "deletions = ");
        System.out.println(m - len);
        System.out.println("Minimum number of "+ "insertions = ");
        System.out.println(n - len);
    }

    public static void main(String[] args) {
        String str1 = new String("heap");
        String str2 = new String("pea");
       
          // Function Call
        printMinDelAndIns(str1, str2);
    }
}
