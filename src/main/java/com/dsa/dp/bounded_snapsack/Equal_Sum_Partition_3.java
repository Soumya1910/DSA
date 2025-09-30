package com.dsa.dp.bounded_snapsack;

public class Equal_Sum_Partition_3 {
	public static void main(String[] args) {
		int[] arr = {1, 5, 11, 5};
        System.out.println("Can we form a subset with equal sum? " + canPartitionWithEqualDivision(arr));
	}

	private static boolean canPartitionWithEqualDivision(int[] arr) {
		// first find the sum of the array element.
		int sum = 0;
		for(int num: arr) {
			sum += num;
		}

		// if the sum is odd, then we can't form a subset with equal sum.'
		if (sum % 2 != 0) {
			return false;
		} else {
			// We need to find if any subset is possible where sum = sum / 2
			return canPartition(arr, sum/2);
		}
	}

	private static boolean canPartition(int[] arr, int sum) {
		int n = arr.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize the first column as true (as 0 sum is possible with empty sub-array)
		for (int i = 0; i<=n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i<=n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i-1] <= j) {
					dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}
}
