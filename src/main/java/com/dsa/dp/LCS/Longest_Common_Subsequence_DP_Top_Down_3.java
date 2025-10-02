package com.dsa.dp.LCS;

public class Longest_Common_Subsequence_DP_Top_Down_3 {
	public static void main(String[] args) {
		String str1 = "abcdfh";
		String str2 = "abegh";

		System.out.println("The length of longest common subsequence is : " + findLengthOfLongestCommonSubsequenceWithTopDown(str1, str2));
	}

	private static int findLengthOfLongestCommonSubsequenceWithTopDown(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];

		// Recursion Code
		/*if (length1 == 0 || length2 == 0) {
			return 0;
		}
		if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) {
		return 1 + findLengthOfLongestCommonSubsequence(str1, str2, length1 - 1, length2 - 1);
		} else {
		return Math.max(
				findLengthOfLongestCommonSubsequence(str1, str2, length1, length2 - 1),
				findLengthOfLongestCommonSubsequence(str1, str2, length1 - 1, length2)
			);
		}
		*

		Base condition will be replaced with initialization of dp array
		length1 --> i
		length2 --> j
		for each and every time I need to fill the DP table.


		* */


		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		printDP(dp);
		return dp[length1][length2];
	}

	private static void printDP(int[][] dp) {
		for (int[] row : dp) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
		System.out.println("\n\n");
	}
}
