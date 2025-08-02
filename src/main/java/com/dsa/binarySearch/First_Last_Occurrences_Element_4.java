package com.dsa.binarySearch;

public class First_Last_Occurrences_Element_4 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 7};
		int target = 5;
		int firstOccurrence = firstOccurrence(arr, target);
		int lastOccurrence = lastOccurrence(arr, target);
		System.out.println("First occurrence: " + firstOccurrence);
		System.out.println("Last occurrence: " + lastOccurrence);
	}

	/*
	* Use binary search to find the first occurrence of a target value in a sorted array.
If the middle element matches the target, record its index and continue searching to the left (by
*  updating end = mid - 1) to find any earlier occurrence.
If the middle element is less than the target, search the right half (start = mid + 1).
If the middle element is greater than or equal to the target, search the left half (end = mid - 1).
Return the index of the first occurrence found, or -1 if the target is not present.
	* */
	private static int firstOccurrence(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		int returnIndex = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				returnIndex = mid;
				end = mid - 1;
			}
			if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return returnIndex;
	}

	private static int lastOccurrence(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		int returnIndex = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				returnIndex = mid;
				start = mid + 1;
			}
			if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return returnIndex;
	}
}
