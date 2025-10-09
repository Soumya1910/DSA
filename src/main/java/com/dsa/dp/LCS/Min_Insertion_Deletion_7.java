package com.dsa.dp.LCS;

public class Min_Insertion_Deletion_7 {
	public static void main(String[] args) {
		String str1 = "kitten";
		String str2 = "sitting";
		int min_operations[] = minInsertionDeletion(str1, str2);
		System.out.println("Minimum number of operation required to make " + str1 + " --> " + str2 + ": \nDeletion: " + min_operations[0] + "\nInsertion: " + min_operations[1]);

	}

	private static int[] minInsertionDeletion(String str1, String str2) {
		int response[] = new int[2];
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];

		// Fill DP table in bottom-up manner
		for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

		// String1 ---(deletion)--> LCS --(Insertion)---> String2

        // Find minimum deletion and insertion operations
        response[0] = length1 - dp[length1][length2];
        response[1] = length2 - dp[length1][length2];

		return response;
	}
}
