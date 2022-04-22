import java.util.Arrays;

public class CoinChange {
    
    public static int coinChange(int[] a, int v, int n, int[][] dp) {
        if(v == 0)
            return dp[n][v] = 1;
        if(n == 0)
            return 0;
        if(dp[n][v] != -1)
            return dp[n][v];
        
            if(a[n-1] <= v) {
               return dp[n][v] = coinChange(a, v, n-1, dp) + coinChange(a, v-a[n-1], n, dp);
            }
            else {
                return dp[n][v] = coinChange(a, v, n-1, dp);
            }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int n = 3;
        int v = 4;
        int[][] dp = new int[n+1][v+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int res = coinChange(a, v, n, dp);
        System.out.println(res);
    }
}
