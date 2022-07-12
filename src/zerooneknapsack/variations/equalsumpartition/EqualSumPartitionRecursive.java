package zerooneknapsack.variations.equalsumpartition;

public class EqualSumPartitionRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int n = arr.length;
        System.out.println(findPartition(arr, n));
    }

    static Boolean findPartition(int[] arr, int n) {
        int arrSum = 0;
        for (int x : arr)
            arrSum += x;
        if (arrSum % 2 != 0)
            return false; // there is no way equal sum partition exists in case arrSum is odd
        return subsetSum(arr, arrSum / 2, n);
    }

    static Boolean subsetSum(int[] arr, int sum, int n) {
        if (n == 0)
            return false;
        if (sum == 0)
            return true;
        if (arr[n - 1] <= sum)
            return subsetSum(arr, sum - arr[n - 1], n - 1) || subsetSum(arr, sum, n - 1);
        else return subsetSum(arr, sum, n - 1);
    }
}
