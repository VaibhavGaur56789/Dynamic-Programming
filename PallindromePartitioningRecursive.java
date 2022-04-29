public class PallindromePartitioningRecursive {
    public static boolean isPallindrome(String s, int i, int j) {
        while(i < j) { //s = "a b c b a"
            if(s.charAt(i) != s.charAt(j)) 
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int minPalPartition(String s, int i, int j) {
        if(i >= j || isPallindrome(s, i, j))
            return 0;
        int ans = Integer.MAX_VALUE, count;
        for(int k = i; k < j; k++) {
            count = 1 + minPalPartition(s, i, k) + minPalPartition(s, k+1, j);
            ans = Math.min(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababbbabbababa";
    System.out.println("Min cuts needed for "+ "Palindrome Partitioning is " + minPalPartition(s, 0, s.length() - 1));
    }
}

