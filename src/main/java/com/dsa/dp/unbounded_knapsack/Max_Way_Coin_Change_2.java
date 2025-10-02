package com.dsa.dp.unbounded_knapsack;

public class Max_Way_Coin_Change_2 {
	/*
	 * Problem Statement: Given an array of coins of different denominations and a total amount.
	 * You need to determine the maximum number of ways to make change for the given amount.
	 * Return the count of all possible combinations.
	 * Note: Coins can be of any denomination and unlimited supply.
	 * */

	public static void main(String[] args) {
		int[] coins = {1, 2, 3};
		int amount = 5;
		System.out.println("Maximum number of ways to make change for " + amount + " is : " + maxCoins(coins, amount));

		/*
		 * Possible ways are:
		 * {2 + 3}
		 * {1 + 1 + 3}
		 * {1 + 1 + 1 + 2}
		 * {1 + 2 + 2}
		 * {1 + 1 + 1 + 1 + 1}
		 *
		 * */
	}

	private static int maxCoins(int[] coins, int amount) {
		int n = coins.length;
		int dp[][] = new int[n + 1][amount + 1];

		// base condition
		// initialize first column with 1 as 0 sum is possible with an empty array
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		// build the dp table
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][amount];
	}
}
