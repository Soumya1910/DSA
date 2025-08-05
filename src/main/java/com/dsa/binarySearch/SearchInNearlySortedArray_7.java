package com.dsa.binarySearch;

public class SearchInNearlySortedArray_7 {
	public static void main(String[] args) {
		// Nearly sorted array means element after sorting will be present in arr[i], arr[i-1] or
		// arr[i+1] position
		int[] arr = {0, 1, 2, 4, 7, 6, 9, 10, 12, 14, 15};
		int target = 12;
		System.out.println("Element found at index: " + searchInNearlySortedArray(arr, target));
	}

	private static int searchInNearlySortedArray(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		while (start < end) {
			/*
			* // Both expressions calculate the middle index, but there is a subtle difference:
            // 1. int mid = (start + end) / 2;
            //    - Simple and works for most cases when start and end are small.
            //    - Can cause integer overflow if start and end are large (e.g., close to Integer
            * .MAX_VALUE).
            // 2. int mid = start + (end - start) / 2;
            //    - Prevents overflow by subtracting first, then dividing, then adding to start.
            //    - Preferred in production code, especially for very large arrays.
            In most DSA problems with small arrays, both are fine, but the second is safer for
            * large inputs.
			* */
			int mid = start + (end - start) / 2;
			int nextIndex = (mid + 1) % arr.length;
			int prevIndex = (mid + arr.length - 1) % arr.length;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[prevIndex] == target) {
				return prevIndex;
			}
			if (arr[nextIndex] == target) {
				return nextIndex;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
