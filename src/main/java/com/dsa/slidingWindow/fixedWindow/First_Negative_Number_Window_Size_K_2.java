package com.dsa.slidingWindow.fixedWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem: First Negative Number in Every Window of Size K (Fixed Window)
 *
 * Given an integer array arr and an integer K, for each contiguous subarray (window)
 * of size K, find the FIRST negative number in that window.
 *
 * If a window does not contain any negative number, output 0 for that window.
 *
 * Example:
 * arr = [12, -1, -7, 8, -15, 30, 16, 28], K = 3
 *
 * Windows of size 3:
 * [12, -1, -7]  -> first negative = -1
 * [-1, -7, 8]   -> first negative = -1
 * [-7, 8, -15]  -> first negative = -7
 * [8, -15, 30]  -> first negative = -15
 * [-15, 30, 16] -> first negative = -15
 * [30, 16, 28]  -> no negative -> 0
 *
 * Output:
 * [-1, -1, -7, -15, -15, 0]
 *
 * Notes:
 * - This is a fixed-size sliding window problem.
 * - Typical approach uses a queue/deque to store indices (or values) of negative numbers in the current window.
 * - Time complexity: O(n), Space complexity: O(k) in worst case.
 */
public class First_Negative_Number_Window_Size_K_2 {
	public static void main(String[] args) {
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int k =3;
		List<Integer> result = firstNegativeInWindow(arr, k);
		for (int num : result) {
            System.out.print(num + " ");
        }
	}

	private static List<Integer> firstNegativeInWindow(int[] arr, int k) {
		if (arr == null || k <= 0 || k > arr.length) {
			throw new IllegalArgumentException("Invalid input: k must be in range 1..arr.length");
		}
		List<Integer> result = new ArrayList<>();
		/*
		* ArrayList is not used as remove(0) is O(n) because it shifts the rest of the elements by one.
		* */
		Deque<Integer> negativeIndex = new LinkedList<>(); // stores indices of negatives in current window
		// Build first window
		for(int i=0; i<k; i++) {
			if(arr[i] < 0) {
				negativeIndex.addLast(i);
			}
		}
		result.add(negativeIndex.isEmpty() ? 0 : arr[negativeIndex.peekFirst()]);

		// Slide window
		for(int i =1; i<= arr.length - k; i++) {
			if(negativeIndex.getFirst() == i-1) {
				negativeIndex.removeFirst();
			}
			if(arr[i+k-1] < 0) {
                negativeIndex.addLast(i+k-1);
            }
			result.add(negativeIndex.isEmpty()? 0 : arr[negativeIndex.peekFirst()]);
		}
		return result;
	}
}
