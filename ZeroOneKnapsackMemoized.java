public class ZeroOneKnapsackMemoized {
    public static int knapSackRec(int[] wt, int[] val, int W, int n, int dp[][]) {
        if(n == 0 || W == 0)
        return 0;

        if(dp[n][W] != -1)
        return dp[n][W];

        if(wt[n-1] <= W) {
            return dp[n][W] = max(val[n-1] + knapSackRec(wt, val, W-wt[n-1], n-1, dp), knapSackRec(wt, val, W, n-1, dp));
        }
        else {
            return dp[n][W] = knapSackRec(wt, val, W, n-1, dp);
        }
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int knapSack(int[] wt, int[] val, int W, int n) {
        int dp[][] = new int[n+1][W+1];    //Declaring table dynamically
        for(int i=0; i<n+1; i++) {         //Assign matrix with -1
            for(int j=0; j<W+1; j++) {
                dp[i][j] = -1;
            }
        }
        return knapSackRec(wt, val, W, n, dp);
    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };   
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;

        System.out.println(knapSack(wt, val, W, n));
    }
}
