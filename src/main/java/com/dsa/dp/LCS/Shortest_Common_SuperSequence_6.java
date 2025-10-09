package com.dsa.dp.LCS;

public class Shortest_Common_SuperSequence_6 {

	/*
	* A supersequence of these two strings must be long enough to include all characters from both
	*  in their respective order.
	*
	* Definition:
	*
Subsequence: A sequence derived from another by deleting some (or no) characters without changing
*  the order of remaining characters.
Supersequence: A sequence that contains the given sequences (strings) as subsequences.
*
SuperSequence Length Formula: Length of SCS = a.length() + b.length() - LCS.length()
Because:
The LCS counts only once in the SCS.
All non-common characters from both strings are included.
	 *
	* */
	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		int length_LCS = findLargestCommonSubsequence(a, b, a.length(), b.length(), dp); // LCS =
		// "GTAB" (length 4)
		int shortest_supersequence_length = a.length() + b.length() - length_LCS; // SCS length =
		// 6 + 7 - 4 = 9
		System.out.println("Length of Shortest Common Supersequence: " + shortest_supersequence_length);
		System.out.println("Shortest common supersequence is: " + buildSCS(a, b, dp));

	}

	public static int findLargestCommonSubsequence(String str1, String str2, int length1,
	                                               int length2, int[][] dp) {

		// initialize the base condition with 0.

		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[length1][length2];
	}

	private static String buildSCS(String str1, String str2, int[][] dp) {
		StringBuilder sb = new StringBuilder("");
		int i = str1.length();
		int j = str2.length();
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				sb.append(str1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				sb.append(str1.charAt(i - 1));
				i--;
			} else {
				sb.append(str2.charAt(j - 1));
				j--;
			}
		}

		// add the remaining characters
		while (i > 0) {
			sb.append(str1.charAt(i - 1));
			i--;
		}
		while (j > 0) {
			sb.append(str2.charAt(j - 1));
			j--;
		}


		return sb.reverse().toString();
	}

}
