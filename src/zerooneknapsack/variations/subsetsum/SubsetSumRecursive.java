package zerooneknapsack.variations.subsetsum;

public class SubsetSumRecursive {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9, n = arr.length;
        Boolean isSubsetSum = subsetSum(arr, sum, n);
        System.out.println(isSubsetSum);
    }

    static Boolean subsetSum(int[] arr, int sum, int n) {
        // base cases
        if (n == 0)
            return false;
        if (sum == 0)
            return true;

        if (arr[n - 1] <= sum) {
            return subsetSum(arr, sum - arr[n - 1], n - 1) || subsetSum(arr, sum, n - 1);
        } else {
            return subsetSum(arr, sum, n - 1);
        }
    }
}
