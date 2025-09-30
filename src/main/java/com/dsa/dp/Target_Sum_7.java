package com.dsa.dp;

import static com.dsa.dp.Minimum_SubSet_Sum_Difference_5.findSubSetSum;

public class Target_Sum_7 {
	/*
	* Problem Statement: Given an array of integers. You need to assign +/- before each element
	* to achieve a target sum. Return the count of all possible subset combinations.
	* */
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3};
        int targetSum = 1;
        System.out.println("Count of subsets with target sum: " + countOfTargetSum(arr, targetSum));
		// Output1: {1,1,2} and {3}
		// Output2: {1,3} and {1,2}
	}

	/*
	* Approach: We have to divide into two subsets (S1 and S2) so that S1-S2 = targetSum.
	* Solution:
	* 1. Get the total sum of the array.
	* 2. (Total_Sum - targetSum) / 2 will be the sum of S2.
	* 3. Now the problem statement is like we have to find a subset whose sum is (Total_Sum -
	* Target_Sum) / 2.
	* 4. Get the count of such subsets.
	* 5. This is same problem statement as "Count of Number of Subset with Given difference"
	* */

	private static int countOfTargetSum(int[] arr, int targetSum) {
	    int n = arr.length;
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
		int targetSumForS2 = (totalSum - targetSum) / 2;
		boolean[][] dp = findSubSetSum(arr, targetSumForS2);
		int count = 0;
		for(int i=1; i<dp.length; i++) {
			if(dp[i][dp[i].length - 1]) {
				count++;
			}
		}
		return count;
	}
}
