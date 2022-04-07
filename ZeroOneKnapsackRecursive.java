//Recursive approach

public class ZeroOneKnapsackRecursive {
    public static int knapSack(int[] wt, int[] val, int W, int n) {
        if(n == 0 || W == 0)
        return 0;
        
        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if(wt[n-1] > W) {
            return knapSack(wt, val, W, n-1);
        }
        else { //(wt[n-1] <= W)
            return max(val[n-1] + knapSack(wt, val, W-wt[n-1], n-1), knapSack(wt, val, W, n-1));
        }
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(wt, val, W, n));
    }
}

//T.C: O(2n)
//S.C: O(1)
//Since subproblems are evaluated again, this problem has Overlapping Sub-problems property, 
//K(1, 1) is being evaluated twice. The time complexity of this naive recursive solution is exponential (2^n)
//
/*
K(n, W)
                       K(3, 2)  
                   /            \ 
                 /                \               
            K(2, 2)                  K(2, 1)
          /       \                  /    \ 
        /           \              /        \
       K(1, 2)      K(1, 1)        K(1, 1)     K(1, 0)
       /  \         /   \              /        \
     /      \     /       \          /            \
K(0, 2)  K(0, 1)  K(0, 1)  K(0, 0)  K(0, 1)   K(0, 0)
*/