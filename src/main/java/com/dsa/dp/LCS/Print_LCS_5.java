package com.dsa.dp.LCS;

public class Print_LCS_5 {
	public static void main(String[] args) {
		String str1 = "abcdfh";
		String str2 = "abegh";
		int[][] dp = findLCSDPTable(str1, str2);
		printDPTableWithHeaders(dp, str1, str2);
		printLCS(str1, str2, dp);
	}

	/*
	* Backtrack over the DP table to find the actual LCS string.
	* Step 1 — Start at bottom-right cell: We start from dp[m][n] because it contains the LCS
	* length for the entire strings.
	* Step 2 — Backtracking loop:
	          * Case 1: If characters match → they are part of LCS → append to result string and
	          * move diagonally (i--, j--).
	          * Case 2: If no match → move in the direction of the larger value in DP table:
						Up (i--) → ignoring a char from str1.
						Left (j--) → ignoring a char from str2.
	* Step 3 — Reverse the built string and return the LCS string.
	* */
	private static void printLCS(String str1, String str2, int[][] dp) {
		StringBuilder stringBuilder = new StringBuilder();
		int i = str1.length();
		int j = str2.length();
		// I will start from the end of the table and if both the characters are same, then we
		// will consider that character in LCS and append it to the result string
		// else we will move to the cell in the previous row or previous column based on which
		// one is maximum.

		// LCS backtracking should be done with a single `while` loop that moves either up, left,
		// or diagonally.
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				stringBuilder.append(str1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println("LCS: " + stringBuilder.reverse().
				toString());
	}

	/*
	* Build the Dynamic Programming table for LCS lengths between str1 and str2.
	  This is a bottom-up approach.
	* */
	private static int[][] findLCSDPTable(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];

		/*
		Backtracking path:
			h == h → add h, move to (5,4)
			f != g → go left to (5,3)
			f != e → go left to (5,2)
			f != b → go up to (4,2)
			d != b → go up to (3,2)
			c != b → go up to (2,2)
			b == b → add b, move to (1,1)
			a == a → add a, move to (0,0) → stop.
		Reverse "hba" → "abh"
		* */

		// base condition: if either of the strings is empty, then the longest common subsequence
		// is 0

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		// if both the characters are same, then we are moving to i++ and j++ else we are moving
		// to i++ or j++
		return dp;
	}

	private static void printDPTableWithHeaders(int[][] dp, String str1, String str2) {
		// print column headers
		System.out.print("    "); // spacing for row header
		System.out.print("''  "); // header for empty string
		for (int ch = 0; ch < str2.length(); ch++) {
			System.out.print(str2.charAt(ch) + "   ");
		}
		System.out.println();

		// print table rows
		for (int i = 0; i <= str1.length(); i++) {
			if (i == 0) {
				System.out.print("''  "); // header for empty row
			} else {
				System.out.print(str1.charAt(i - 1) + "   ");
			}

			for (int j = 0; j <= str2.length(); j++) {
				System.out.print(dp[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
