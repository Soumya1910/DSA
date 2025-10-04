package com.dsa.dp.LCS;

public class Longest_Common_Substring_4 {
	/*
	* In LCS, continuity doesn't matter.
	* However, in substring, continuity matters.
	* 
	* */
	public static void main(String[] args) {
		String str1 = "abcdxyz";
        String str2 = "xyzabcd";
        
        System.out.println("Length of longest common substring is : " + longestCommonSubstring(str1, str2));	
	}


	/*
	* How to Extract the Substring
		While finding maxLength, we also store:
		The ending index (endPos) in str1 of the longest common substring so far.
		Once we finish filling the dp table:
		The substring in str1 from (endPos - maxLength) to endPos is the actual longest common
		* substring.
	* */
	private static int longestCommonSubstring(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];

		// base condition is same
		// for length1 = 0, we don't have any substring
		// for length2 = 0, we don't have any substring

		int maxLength = Integer.MIN_VALUE;
		int endPos = 0;


		for (int i = 1; i <= length1; i++) {
			for (int j=1; j<=length2; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					if (dp[i][j] > maxLength) {
						maxLength = dp[i][j];
                        endPos = i; // update the end position of longest common substring
					}
				} else {
					dp[i][j] = 0; // reset because substring must be continuous
				}
			}
		}

		printDP(dp);

		String longestSubString = str1.substring(endPos-maxLength, endPos);
		System.out.println("Longest Common Substring is: " + longestSubString);

		return maxLength;
	}

	private static void printDP(int[][] dp) {
		for (int[] row : dp) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
	}
}
