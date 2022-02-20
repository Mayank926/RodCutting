package algos.dp.RodCutting;

import java.util.Scanner;

public class RodCuttingTopDown {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            SolutionTopDown ob = new SolutionTopDown();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class SolutionTopDown {
    static int[][] arr;

    public int cutRod(int price[], int n) {
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                    continue;
                }
                int origIdx=i-1;
                if(i<=j)
                    arr[i][j]=Math.max((price[origIdx]+arr[i][j-i]),arr[i-1][j]);
                else
                    arr[i][j]=arr[i-1][j];
            }
        }
        return arr[n][n];
    }
}
