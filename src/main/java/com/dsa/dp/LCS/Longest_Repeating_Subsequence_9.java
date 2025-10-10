package com.dsa.dp.LCS;

public class Longest_Repeating_Subsequence_9 {

	/*
	* Problem Statement: Find the Length of Longest Repeating Subsequence
	* Given a string `str`, find the **length of the longest subsequence** that appears
	* at least **twice** in the string, but the two occurrences must use **different character positions**.
	*
What is a “sequence of letters” here?
We are allowed to pick letters from the word while keeping their order but we can skip letters in between.
For example, from "aabebc":
"ab" could be picked from positions:
First 'a' (index 1) → First 'b' (index 3)
Second 'a' (index 2) → Second 'b' (index 5)
Notice: The letters don't have to be next to each other, as long as they’re in the same order.
*
*
What does “repeating” mean?
The same sequence can be formed at least twice from different positions in the original word.
For "aabebc":
	"a" appears:
		at index 1
		at index 2
	(So "a" repeats)
	"ab" appears:
		using positions (1,3)
		using positions (2,5)
	(So "ab" repeats)
	"beb" appears only once → not counted as “repeating” here.
	*
	*
Approach:
*
* Base Pattern: Longest Common Subsequence (LCS)
* Twist for LRS: Compare string with itself but disallow same index matches (i != j).
	* */


	public static void main(String[] args) {
		String str = "aabebc";
		int length = str.length();
		int[][] dp = new int[length + 1][length + 1];
		int max_length = findLongestRepeatingSubsequence(str, length, dp);
		System.out.println("Length of longest repeating subsequence: " + max_length);

	}


	/*
Row 1 (i=1, 'a'):
j=1 → i==j → dp=0
j=2 → 'a'=='a', i!=j → dp[1][2] = 1 + dp[0][1] = 1
j=3 → 'a'!='b' → dp = max(dp[0][3], dp[1][2]) = 1
j=4 → 'a'!='e' → dp = 1
j=5 → 'a'!='b' → dp = 1
j=6 → 'a'!='c' → dp = 1

Row 2 (i=2, 'a'):
j=1 → 'a'=='a', i!=j → dp = 1 + dp[1][0] = 1
j=2 → i==j → max(dp[1][2], dp[2][1]) = 1
j=3 → 'a'!='b' → max=1
j=4 → 'a'!='e' → max=1
j=5 → 'a'!='b' → max=1
j=6 → 'a'!='c' → max=1

Row 3 (i=3, 'b'):
j=1 → 'b'!='a' → max(dp[2][1], dp[3][0]) = 1
j=2 → 'b'!='a' → max=1
j=3 → i==j → max=1
j=4 → 'b'!='e' → max=1
j=5 → 'b'=='b', i!=j → dp = 1 + dp[2][4] = 1 + 1 = 2
j=6 → 'b'!='c' → max(dp[2][6], dp[3][5]) = max(1,2) = 2

Row 4 (i=4, 'e'):
j=1 → 'e'!='a' → max=1
j=2 → 'e'!='a' → max=1
j=3 → 'e'!='b' → max=1
j=4 → i==j → max=1
j=5 → 'e'!='b' → max=2
j=6 → 'e'!='c' → max=2

Row 5 (i=5, 'b'):
j=1 → 'b'!='a' → max=1
j=2 → 'b'!='a' → max=1
j=3 → 'b'=='b', i!=j → dp = 1 + dp[4][2] = 1 + 1 = 2
j=4 → 'b'!='e' → max(dp[4][4], dp[5][3]) = max(1,2) = 2
j=5 → i==j → max=2
j=6 → 'b'!='c' → max=2

Row 6 (i=6, 'c'):
j=1 → 'c'!='a' → max=1
j=2 → 'c'!='a' → max=1
j=3 → 'c'!='b' → max=2
j=4 → 'c'!='e' → max=2
j=5 → 'c'!='b' → max=2
j=6 → i==j → max=2

	*
	* */

	private static int findLongestRepeatingSubsequence(String str, int length, int[][] dp) {
		for(int i = 1; i <= length; i++) {
			for (int j = 1; j <= length; j++) {
				if (str.charAt(i-1) == str.charAt(j-1) && i!=j) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[length][length];
	}
}
