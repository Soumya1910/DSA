package com.dsa.dp;

public class Minimum_SubSet_Sum_Difference_5 {

	/*
	 * Problem Statement: Given an integer array arr[], divide it into two subsets S1 and S2 such
	 * that the absolute difference between the sum of elements in the two subsets is minimum.
	 * Return this minimum possible difference.
	 * */

	public static void main(String[] args) {
		// int arr[] = {1, 6, 5, 11, 10, 2};
		// int arr[] = {3, 1, 4, 2, 2};
		int arr[] = {8, 5, 1};
		// This array should be divided into two parts where difference will be minimum.
		int minDiff = minDifference(arr); System.out.println("Minimum difference is " + minDiff);
	}

	private static int minDifference(int[] arr) {
		// abs(s1 - s2) should be minimum.
		// If we find the sum of any subset (S1) and then we can easily derive the sum of another
		// set by deducting it from the total sum (S2 = Total Sum - S1).
		// |S2 - S1| should be minimum i.e.
		// |Total Sum - 2* S1| should be minimum.
		// Let's take an example of {1, 6, 5, 2} where total_sum = 14
		// S1 should lie between 0 and 14.
		// Possible points are: 0, 1, 2, 3, 5, 6, 7, 8, 9, 11, 12, 13, 14.. remaining points
		// should be discarded. This is a similar problem like SubSet_Sum Problem
		// Difference will be minimum when sum of S1 is 7 so that total_sum - 2*S1 = 0
		// If it's not possible then we have to find the lesser value of 7 through which a subset
		// can be formed.

		// Find the total sum
		int total_sum = 0; for (int num : arr) {
			total_sum += num;
		}

		// calculate the dp table
		boolean[][] dp = findSubSetSum(arr, total_sum);
		// print the dp table
		printDpTable(dp, arr, total_sum);

		// find the minimum difference
		int minDiff = total_sum; int n = dp.length; for (int i = total_sum / 2; i >= 0; i--) {
			if (dp[n - 1][i]) {
				minDiff = total_sum - 2 * i; break;
			}
		}

		return minDiff;
	}

	private static boolean[][] findSubSetSum(int[] arr, int sum) {
		int n = arr.length; boolean[][] dp = new boolean[n + 1][sum + 1];

		// default sum can be 0
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		// Build the dp table in bottom-up manner
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp;
	}

	private static void printDpTable(boolean[][] dp, int[] arr, int sum) {
		int n = arr.length;

		// Print column headings (fixed width)
		System.out.printf("%-8s", ""); // space for row label
		for (int j = 0; j <= sum; j++) {
			System.out.printf("%3d ", j);
		} System.out.println();

		// Print table rows with fixed alignment
		for (int i = 0; i <= n; i++) {
			String rowLabel; if (i == 0) {
				rowLabel = String.format("i=%d{}", i);
			} else {
				rowLabel = String.format("i=%d{%d}", i, arr[i - 1]);
			}

			// fixed width for row label (8 spaces)
			System.out.printf("%-8s", rowLabel);

			for (int j = 0; j <= sum; j++) {
				System.out.printf("%3s ", dp[i][j] ? "T" : "F");
			} System.out.println();
		}
	}

}
