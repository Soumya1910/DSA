package com.dsa.binarySearch;

public class NumberOfRotationOfSortedArray_5 {
	public static void main(String[] args) {
		int[] arr = {11, 12, 13, 14, 5, 6, 7}; // observation: index of minimum element is number
		// of rotations
		System.out.println("Number of rotations: " + countRotations(arr));
	}

	private static int countRotations(int[] arr) {
		// In Binary Search, we find the index of any target element in a sorted array.
		// However, in this case, we need to find the position of any arbitrary element which is
		// the smallest element in the sorted array.
		// As it's a sorted array, we will try to apply Binary Search to find the minimum element.
		/*
		 * Approach: 1. If arr[start] <= arr[end] --> then smallest index = start
		 * 2. Find the middle element.
		 * 3. If the middle element is smaller than both the previous and next elements, then
		 * return the middle element as it is the smallest element.
		 * 4. If the middle element is greater than the arr[start], then continue the search in the
		 * right half of the array.
		 * 5. If the middle element is greater than the arr[end], then continue the search in
		 * the left half of the array.
		 * */
		int start = 0, end = arr.length - 1;
		int minIndex = 0;
		while (start <= end) {
			// If the subarray is already sorted, the smallest element is at start
			if (arr[start] <= arr[end]) {
				minIndex = start;
				break;
			}
			int mid = (start + end) / 2;
			int nextIndex = (mid + 1) % arr.length;
			int prevIndex = (mid + arr.length - 1) % arr.length;
			if (arr[mid] <= arr[nextIndex] && arr[mid] <= arr[prevIndex]) {
				minIndex = mid;
				break;
			} else if (arr[mid] >= arr[start]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return minIndex;
	}
}
