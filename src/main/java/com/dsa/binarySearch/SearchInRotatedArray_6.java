package com.dsa.binarySearch;

public class SearchInRotatedArray_6 {
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 0, 1, 2};
		int target = 5;
		System.out.println("Target found at index: " + searchFromRotatedArray(arr, target));
	}

	private static int searchFromRotatedArray(int[] arr, int target) {
		/*
		 * Approach: 1. First find the pivot/smallest element in the array using binary search.
		 * 2. If the target is equal to the pivot, return the pivot index.
		 * 3. If the target is greater than the pivot and greater than the arr[end], search in the
		 *  left half of the array.
		 * 4. If the target is greater than the pivot and less than or equal to the arr[end],
		 * search in the right half of the array.
		 * */
		int pivotIndex = findPivotElementIndex(arr);
		if (pivotIndex == 0 && arr[pivotIndex] == target) {
			return pivotIndex;
		} else if (arr[pivotIndex] < target && arr[arr.length - 1] > target) {
			return searchInPartialArray(arr, pivotIndex + 1, arr.length - 1, target);
		} else {
			return searchInPartialArray(arr, 0, pivotIndex - 1, target);
		}
	}

	private static int searchInPartialArray(int[] arr, int start, int end, int target) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private static int findPivotElementIndex(int[] arr) {
		int start = 0, end = arr.length - 1;
		int pivotIndex = 0;
		while (start <= end) {
			if (arr[start] <= arr[end]) {
				pivotIndex = start;
				break;
			}
			int mid = (start + end) / 2;
			int nextIndex = (mid + 1) % arr.length;
			int prevIndex = (mid + arr.length - 1) % arr.length;
			if (arr[mid] <= arr[prevIndex] && arr[mid] <= arr[nextIndex]) {
				pivotIndex = mid;
				break;
			} else if (arr[mid] >= arr[start]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return pivotIndex;
	}
}
