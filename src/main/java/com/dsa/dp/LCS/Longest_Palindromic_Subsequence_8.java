package com.dsa.dp.LCS;

public class Longest_Palindromic_Subsequence_8 {

	/*
	* Find the length (and optionally the sequence) of the longest subsequence of S that is also a
	*  palindrome.
	* S = "bbbab"
	* Possible palindromic subsequences:
		"bbbb" (length 4)
		"bab" (length 3)
		"bbb" (length 3)
	*
	* */

	/*
	* Minimum number of deletion in a string to make it Palindrome:
	* S = "agbdba" (Length = 6)
	* Reverse(S) = "abdbga"
	* Longest palindromic string is : "abdba" --> (Length = 5)
	* Minimum number of deletion = Length(S) - Length(LCS) = 6 - 5 = 1
	* */

	/*
	* Minimum number of insertion in a string to make it Palindrome:
	* S = "abcaa"
		Reverse S = "aacba"
		LCS(S, Reverse S) = "aca"
		Length of LPS = 3

		Minimum Insertions = 5 - 3 = 2
	*
	* One possible palindrome after 2 insertions:
		"aabcaa" (insert 'a' at beginning)
		"aacbaa" (insert 'a' before final 'a')
	* */

	public static void main(String[] args) {
		String str = "agbdba";
		// Find the LCS(longest common subsequence) between S and reverse(S).
		String reverseString = (new StringBuffer(str)).reverse().toString();

		int[][] dp = new int[str.length() + 1][reverseString.length() + 1];
		int length_LCS = findLengthOfLCS(str, reverseString, dp);
		System.out.println("Length of longest palindromic subsequence: " + length_LCS);
		System.out.println("Longest palindromic string is : " + findLongestPalindromicString(str, reverseString, dp));
	}

	private static int findLengthOfLCS(String str1, String str2, int[][] dp) {
		int row = str1.length();
		int col = str2.length();
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else if (dp[i - 1][j] > dp[i][j - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[row][col];
	}

	private static String findLongestPalindromicString(String str1, String str2, int[][] dp) {
		StringBuilder sb = new StringBuilder();
		int i = str1.length();
		int j = str2.length();
		while(i>0 && j>0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
		}
		return sb.reverse().toString();
	}

}
