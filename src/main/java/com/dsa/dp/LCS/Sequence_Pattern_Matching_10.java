package com.dsa.dp.LCS;

public class Sequence_Pattern_Matching_10 {
	/*
	 * Problem Statement: Given two strings str1 and str2, find if str1 is a subsequence of str2.
	 * */

	/*
	 * Solution Approach: Find the LCS (Longest Common Subsequence) of str1 and str2.
	 * If the length of LCS and the first string are equal, return true.
	 * */
	public static void main(String[] args) {
		String str1 = "AXY";
		String str2 = "ABXGYZ";
		System.out.println("Is " + str1 + " a subsequence of " + str2 + ": " + isSubsequence(str1,
				str2));
	}

	private static boolean isSubsequence(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];

		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return str1.length() == dp[length1][length2];
	}
}
