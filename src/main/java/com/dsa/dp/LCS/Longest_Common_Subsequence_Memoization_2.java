package com.dsa.dp.LCS;

public class Longest_Common_Subsequence_Memoization_2 {

	// Why memoization technique is required?
	// Memoization allows us to store the results of expensive function calls and reuse them when
	// the same inputs occur again.
	// This significantly reduces the time complexity of the program.
	// When we are calling the method with the same input which had already computed, it's
	// unnecessary to compute once again.
	public static void main(String[] args) {
		String str1 = "abcdfh";
		String str2 = "abegh";
		int m = str1.length();
		int n = str2.length();
		int[][] t = new int[m + 1][n + 1];
		// initialize the array with the lower value
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				t[i][j] = Integer.MIN_VALUE;
			}
		}
		System.out.println("The length of longest common subsequence is : " + findLengthOfLongestCommonSubsequenceByMemoization(str1, str2, t, m, n));

	}

	private static int findLengthOfLongestCommonSubsequenceByMemoization(String str1, String str2
			, int[][] t, int length1, int length2) {
		// Base case: If either of the strings is empty, then the longest common subsequence is 0
		if (length1 == 0 || length2 == 0) {
			return 0;
		}
		/*
		* If result already computed, return it.
		  Else, compute, store in t[length1][length2], return it.
		* */
		else {
			if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) {
				if (t[length1][length2] != Integer.MIN_VALUE) {
					return t[length1][length2];
				} else {
					t[length1][length2] =
							1 + findLengthOfLongestCommonSubsequenceByMemoization(str1, str2, t,
									length1 - 1, length2 - 1);
					return t[length1][length2];
				}
			} else {
				if (t[length1][length2] != Integer.MIN_VALUE) {
					return t[length1][length2];
				} else {
					t[length1][length2] =
							Math.max(findLengthOfLongestCommonSubsequenceByMemoization(str1, str2,
									t, length1 - 1, length2),
									findLengthOfLongestCommonSubsequenceByMemoization(str1, str2,
											t, length1, length2 - 1));
					return t[length1][length2];
				}
			}
		}
	}
}
