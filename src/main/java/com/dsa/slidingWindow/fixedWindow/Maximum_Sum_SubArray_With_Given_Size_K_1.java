package com.dsa.slidingWindow.fixedWindow;

/*
 * Problem: Maximum Sum Subarray of Size K (Fixed Window)
 *
 * Given an integer array arr and an integer K, find the maximum sum of any
 * contiguous subarray (window) of size exactly K.
 *
 * Example:
 * arr = [2, 5, 1, 8, 2, 9, 1], K = 3
 *
 * All subarrays of size 3 and their sums:
 * - [2, 5, 1] -> 8
 * - [5, 1, 8] -> 14
 * - [1, 8, 2] -> 11
 * - [8, 2, 9] -> 19   (maximum)
 * - [2, 9, 1] -> 12
 *
 * Output:
 * Maximum sum = 19  (from subarray [8, 2, 9])
 *
 * Notes:
 * - This is a fixed-size sliding window problem.
 * - Time complexity: O(n), Space complexity: O(1).
 */
public class Maximum_Sum_SubArray_With_Given_Size_K_1 {
	public static void main(String[] args) {
		int[] arr = {2, 5, 1, 8, 2, 9, 1};
		int K = 3;
		System.out.println("Maximum sum of subarray of size " + K + ": " + maxSubarraySum(arr, K));
	}

	private static int maxSubarraySum(int[] arr, int k) {
		// Guard clauses: invalid window size or null array
		if (arr == null || k <= 0 || k > arr.length) {
			throw new IllegalArgumentException("Invalid input: k must be in range 1..arr.length");
		}
		// Step 1: Compute sum of the first window of size k
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		// Initialize maxSum with the first window sum (important especially if negatives exist)
		int maxSum = sum;

		// Step 2: Slide the window one element at a time
		// i = start index of the current window is [i ... i + k - 1]
		for (int i = 1; i <= arr.length - k; i++) {
			// Remove element going out of the window (arr[i - 1])
			// Add element coming into the window (arr[i + k - 1])
			sum = sum - arr[i - 1] + arr[i + k - 1];
			// Track the maximum window sum seen so far
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
}
