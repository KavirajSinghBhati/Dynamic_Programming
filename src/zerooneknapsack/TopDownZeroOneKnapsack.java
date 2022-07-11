package zerooneknapsack;

public class TopDownZeroOneKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int n = 3, W = 50;
        int maximumProfit = knapsack(wt, val, W, n);
        System.out.println("Maximum profit: " + maximumProfit);
    }

    static int knapsack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0)
            return 0;

        int[][] t = new int[n + 1][W + 1];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (wt[i - 1] <= j)
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[n][W];
    }
}
