public class MaximumSumIncreasingSubsequence {
    class Solution {
        int maxSumSubsequence(int[] arr) {
            // add you logic here
            int omax = 0;
            int n = arr.length;
            int[] dp = new int[n];
            for(int i=0; i<arr.length; i++) {
                int max = 0;
                for(int j = 0; j < i; j++) {
                    if(arr[j] < arr[i]) {
                        if(max == 0) {
                            max = dp[j];
                        }
                        else if(dp[j] > max) {
                            max = dp[j]; //no. of ways
                        }
                    }
                }
                if(max == 0) {
                    dp[i] = arr[i];
                }else {
                    dp[i] = max + arr[i];
                }
                if(dp[i] > omax) {
                    omax = dp[i];
                }
            }
            return omax;
        }
    }
}
