public class LCSRecursive {
    
    public static int LCS(char[] x, char[] y, int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        if(x[m-1] == y[n-1]) {
            return 1 + LCS(x, y, m-1, n-1);
        }
        else {
            return max(LCS(x, y, m-1, n), LCS(x, y, m, n-1));
        }
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        LCSRecursive lcs = new LCSRecursive();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int m = x.length;
        int n = y.length;
        System.out.println("Length of LCS is" + " " + lcs.LCS(x, y, m, n));
    }
}
