package com.dsa.dp.bounded_snapsack;

public class Count_SubSet_Sum_4 {
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 5, 6, 8, 10};
		int sum = 10;
		System.out.println("Count of Subset whose sum is equal to " + sum + "is : " + countOfSubSetSum(arr, sum));
	}

	private static int countOfSubSetSum(int[] arr, int sum) {
		int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize the first column as 1 (as 0 sum is possible with empty sub-array)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

		// Build the dp table in bottom-up manner
		for (int i = 1; i <=n; i++) {
			for(int j= 1; j<= sum; j++) {
				if (arr[i-1] <= j) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		// Draw the dp table
		for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        // Return the count of subsets with sum equal to 'n'
        return dp[n][sum];
	}
}
