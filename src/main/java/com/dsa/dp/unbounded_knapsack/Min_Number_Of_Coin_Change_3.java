package com.dsa.dp.unbounded_knapsack;

public class Min_Number_Of_Coin_Change_3 {

	/*
	* Problem Breakdown
Given:
1. A target amount X.
2. A set of available coin denominations (e.g., {1, 2, 5, 10}).
3. An infinite supply of each coin denomination.
Goal: Find the minimum total number of coins that add up exactly to the target amount X.
Output: The minimum count of coins required.
Example
Target Amount: 11
Available Denominations: {1, 5, 7}
Solution: 5 + 5 + 1 (3 coins) is the optimal solution, using the minimum number of coins.
	*
	* */


	public static void main(String[] args) {
		int[] coins = {1, 5, 7};
		int amount = 11;
		System.out.println("Minimum coins used to achieve a sum of " + amount + " is: " + minCoinChangeCount(coins, amount));

	}

	private static int minCoinChangeCount(int[] coins, int amount) {
		int n = coins.length;
		int dp[][] = new int[n + 1][amount + 1];

		// base condition
		// Initialize first column with 0 because 0 coins are needed to make amount 0.
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}

		// initialize other cells for amount > 0 with a large value to represent "infinity"
		for (int j = 1; j <= amount; j++) {
			dp[0][j] = Integer.MAX_VALUE - 1; // can't form a sum without any coins
		}

		// Build the dp table
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); //  you must
					// add 1 when you include a coin because using a coin means one more coin is
					// counted
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
	}
}
