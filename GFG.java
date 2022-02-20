package algos.dp.RodCutting;
// { Driver Code Starts

import java.util.*;

public class GFG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int[][] arr;
    public int cutRod(int price[], int n) {
        arr = new int[n+1][n+1];
        for(int i =0;i<n+1;i++)
            for(int j =0;j<n+1;j++)
                arr[i][j]=-1;
        return getValue(price,n,n);
    }
    public int getValue(int[] price,int n, int len){
        if(len<=0 || n==0)
            return 0;
        if(arr[n][len]!=-1)
            return arr[n][len];
        int maxValue=Math.max((price[n-1]+getValue(price,len-n,len-n)),getValue(price,n-1,len));
        arr[n][len]=maxValue;
        return maxValue;
    }
}
