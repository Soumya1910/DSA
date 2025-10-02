package com.dsa.dp.bounded_knapsack;

public class SubSet_Sum_Problem_2 {
	public static void main(String[] args) {
		int[] arr = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		System.out.println("Can we form a subset with given sum? " + canPartition(arr, sum));
	}

	private static boolean canPartition(int[] arr, int sum) {
		int n = arr.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];

		// Initialize the first row as true (as 0 sum is possible with empty sub-array)
		for(int i=0; i<=n; i++) {
			dp[i][0] = true;
		}

		// Initialize the first column as False except first row (as 0 sum with any positive
		// number is not possible)

		for (int j = 1; j<=sum; j++) {
			dp[0][j] = false;
		}

		// Build the dp table in bottom-up manner
		for (int i = 1; i<=n; i++) {
			for( int j= 1; j<=sum; j++) {
				if (arr[i-1] <= j) {
					dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}


		// print the dp table
		for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

		// Return the last cell value
		return dp[n][sum];
	}
}
