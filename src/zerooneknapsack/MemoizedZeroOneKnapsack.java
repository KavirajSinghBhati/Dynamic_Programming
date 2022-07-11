package zerooneknapsack;

import java.util.Arrays;

public class MemoizedZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int n = 4, W = 7;
        int maximumProfit = knapsack(wt, val, W, n);
        System.out.println("Maximum profit: " + maximumProfit);
    }

    static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n + 1][W + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return knap(wt, val, W, n, t);
    }

    static int knap(int[] wt, int[] val, int W, int n, int[][] t) {
        if (n == 0 || W == 0)
            return 0;
        if (t[n][W] != -1)
            return t[n][W];
        if (wt[n - 1] <= W)
            return t[n][W] = Math.max(val[n - 1] + knap(wt, val, W - wt[n - 1], n - 1, t),
                    knap(wt, val, W, n - 1, t));
        else
            return t[n][W] = knap(wt, val, W, n - 1, t);
    }
}
