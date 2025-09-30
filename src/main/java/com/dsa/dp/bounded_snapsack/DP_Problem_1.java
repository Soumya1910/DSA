package com.dsa.dp.bounded_snapsack;

/*
* You are given: n items, each with: a weight and a value (profit)
A knapsack (bag) with a maximum carrying capacity W.
You must determine:
The maximum total value you can carry without exceeding capacity.
0/1 means:
Each item can be either taken completely (1) or not taken at all (0) — no fractions.
*
*
* Items:     Value   Weight
Item 1       60       10
Item 2      100       20
Item 3      120       30

Capacity W = 50
*
* Best selection: Item 2 + Item 3 = Value = 220, Weight = 50
* */


/*
* Why “0/1”?
0 means you leave the item.
1 means you take the item fully.
You can’t take a fractional part (which is possible in the Fractional Knapsack problem solved using Greedy).
* */

public class DP_Problem_1 {
	public static void main(String[] args) {
		int[] value = {15, 8, 10};
		int[] weight = {1, 3, 4};
		int W = 6;
		System.out.println("Maximum value: " + knapsack(weight, value, W));
	}

	private static int knapsack(int[] weight, int[] value, int maxWeight) {
		int n = weight.length;
		int[][] dp = new int[n + 1][maxWeight + 1]; // create a 2D array with n+1 rows and w+1 columns

		/*
		* Why 0th row and 0th Columns are initialized as 0.
		* 0th row represents the case when there are no items (i.e., all weights are 0),
		* 0th column represents the case when the maximum weight is 0 (i.e., all items can be left out).
		* */


		// Build the dp table in bottom-up manner
		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= maxWeight; w ++) {
				if (weight[i - 1] <= w) { // if the current item can fit in the knapsack
					dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
					/*
					* value[i - 1] = profit/value of the current item (arrays are 0-indexed, hence i - 1)
If we take it, capacity reduces by its weight → w - weight[i - 1]
We can then add the best value possible without this item for the remaining capacity:
					*
					*
					* This means:Profit from current item + best profit from previous items with reduced capacity.
					* */
				} else {
                    dp[i][w] = dp[i - 1][w];  // if the current item cannot fit in the knapsack, then take the maximum value from the previous item
                }
			}
		}

		// Print DP table for debugging
		System.out.println("DP Table:");
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= maxWeight; w++) {
				System.out.print(dp[i][w] + "\t");
			}
			System.out.println();
		}

		return dp[n][maxWeight];  // return the maximum value that can be carried in the knapsack
		// with the given capacity
	}
}
