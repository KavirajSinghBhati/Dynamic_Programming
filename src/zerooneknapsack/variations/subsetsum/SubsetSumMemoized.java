package zerooneknapsack.variations.subsetsum;

import java.util.Arrays;

public class SubsetSumMemoized {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9, n = arr.length;
        Boolean isSubsetSum = subsetSum(arr, sum, n);
        System.out.println(isSubsetSum);
    }

    static Boolean subsetSum(int[] arr, int sum, int n) {
        Boolean[][] t = new Boolean[n + 1][sum + 1];
        for (Boolean[] row : t) {
            Arrays.fill(row, false);
        }
        return isSubsetSum(arr, sum, n, t);
    }

    static Boolean isSubsetSum(int[] arr, int sum, int n, Boolean[][] t) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (arr[n - 1] <= sum) {
            return t[n][sum] = isSubsetSum(arr, sum - arr[n - 1], n - 1, t) ||
                    isSubsetSum(arr, sum, n - 1, t);
        }
        else {
            return t[n][sum] = isSubsetSum(arr, sum, n - 1, t);
        }
    }
}
