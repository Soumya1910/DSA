package com.dsa.dp.unbounded_knapsack;

/*
* Problem Statement: Given a rod of length n inches and an array price[], where price[i] denotes
* the value of a piece of length i. Your task is to determine the maximum value obtainable by
* cutting up the rod and selling the pieces.
Note: n = size of price, and price[] is 1-indexed array.
* */

public class Rod_Cutting_Problem_1 {
	public static void main(String[] args) {
		//int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
		int[] price = {2, 5, 7, 8, 10};
		System.out.println("Maximum obtainable value: " + cutRod(price, price.length));
	}

	public static int cutRod(int price[], int n) {
		// Write your code here.
		int dp[][] = new int[n + 1][n + 1];
		int[] length = new int[n];
		for (int i = 0; i < n; i++) {
			length[i] = i+1;
		}

		// fill the dp table
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (length[i - 1] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - length[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][n];
	}
}
