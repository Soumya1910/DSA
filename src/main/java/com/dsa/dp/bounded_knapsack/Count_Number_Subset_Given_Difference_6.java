package com.dsa.dp.bounded_knapsack;

import static com.dsa.dp.bounded_knapsack.Minimum_SubSet_Sum_Difference_5.findSubSetSum;

public class Count_Number_Subset_Given_Difference_6 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
        int difference = 3;
        System.out.println("Count of subset whose sum is equal to " + difference + " is : " + countOfSubSetSumWithDifference(arr, difference));
	}

	private static int countOfSubSetSumWithDifference(int[] arr, int difference) {
		/*
		* S1 - S2 = diff
		* S1 + S2 = total_sum
		* ------------------------
		* (total_sum + diff) = 2*S1
		*
		* S1 = 1/2 * (total_sum + diff)
		*
		* */

		int total_sum = 0;
		for (int num : arr) {
            total_sum += num;
        }

		int subset_sum = (total_sum + difference) / 2;

		boolean[][] dp = findSubSetSum(arr, subset_sum);

		int total_count = 0;
		for(int i=1; i<dp.length; i++) {

                if(dp[i][dp[i].length - 1]) {
                    total_count += 1;
                }

		}

		return total_count;
	}
}
