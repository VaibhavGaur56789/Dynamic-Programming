public class CountOfSubsetOfGivenSum {
    public static int countOfSubset(int[] arr, int n, int sum) {
        
        int dp[][] = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int i=1; i<=sum; i++) {
            dp[0][i] = 0;
        }
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int n = 4;
        int arr[] = { 3, 3, 3, 3 };
        int sum = 6;
        System.out.println(countOfSubset(arr, n, sum));
    }
}

