import java.util.*;

public class MCM {
    static int[][] dp = new int[100][100];

    public static int matrixChainMultiplication(int[] arr, int i, int j) {
        if(i > j || i == j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            dp[i][j] = Math.min(dp[i][j], matrixChainMultiplication(arr, i, k) + matrixChainMultiplication(arr, k+1, j) + arr[i-1] * arr[k] * arr[j]);
        }
        return dp[i][j];
    }

    public static int matrixChainOrder(int[] arr, int n) {
        int i = 1, j = n-1;
        return matrixChainMultiplication(arr, i, j);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;

        for(int[] row : dp)
        Arrays.fill(row, -1);

        System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr, n));
    }
}
