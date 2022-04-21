import java.io.*;

public class CuttingRod {
    
    static int[][] t = new int[9][9];
    public static int maxPrice(int price[], int[] length, int n, int maxLen) {
        if(n == 0 || maxLen == 0) {
            return 0;
        }
        if(length[n-1] <= maxLen) {
            t[n][maxLen] = Math.max(price[n-1] + maxPrice(price, length, maxLen - length[n-1], n), maxPrice(price, length, maxLen, n-1));
        }
        else {
            t[n][maxLen] = maxPrice(price, length, maxLen, n-1);
        }
        return t[n][maxLen];
    }

    public static void main(String[] args) {
        int[] price = new int[]{ 1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        int[] length = new int[n];
        for(int i=0; i<n; i++) {
            length[i] = i+1;
        }
        int maxLen = n;
        System.out.println("Maximum obtained value is "+ maxPrice(price, length, n, maxLen));
    }
}
