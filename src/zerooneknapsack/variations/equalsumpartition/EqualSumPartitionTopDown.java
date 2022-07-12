package zerooneknapsack.variations.equalsumpartition;

public class EqualSumPartitionTopDown {
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
        int sum = arrSum / 2;
        Boolean[][] t = new Boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }
}
