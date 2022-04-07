public class EqualSumPartition {
    public static boolean findPartition(int[] arr, int n) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        boolean part[][] = new boolean[n+1][sum/2 + 1];  //dp
        
        for(int i=0; i<part.length; i++) {
            for(int j=0; j<part[0].length; j++) {
                if(i == 0 && j == 0) {
                    part[i][j] = true;
                }
                else if(i == 0) {
                    part[i][j] = false;
                }
                else if(j == 0) {
                    part[i][j] = true;
                }
                else {
                    if(part[i-1][j] == true) {
                        part[i][j] = true;
                    }
                    else {
                        int val = arr[i-1];
                        if(j >= val) {
                            if(part[i-1][j-val] = true) {
                                part[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return part[n][sum/2];

    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 3};
        int n = arr.length;
        if(findPartition(arr, n) == true) {
            System.out.println("Can be divided into two "+"subsets of equal sum");
        }
        else {
            System.out.println("Can not be divided into two "+"subsets of equal sum");
        }
    }
}
