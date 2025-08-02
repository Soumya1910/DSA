package com.dsa.binarySearch;

public class Binary_Search_1 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15 };
        int target = 11;
        int result = binarySearch(arr, target);
        System.out.println("Element found at index: " + result);
	}

	/*
	* The loop continues as long as start is less than or equal to end.
		The middle index mid is calculated as the average of start and end.
		If the element at mid equals the target, the index is stored in returnIndex, and the loop breaks.
		If the element at mid is greater than the target, the search continues in the left half by updating end to mid - 1.
		If the element at mid is less than the target, the search continues in the right half by updating start to mid + 1.
	* */

	public static int binarySearch(int[] arr, int target) {
		int returnIndex = -1;
		int start = 0, end = arr.length-1;
		while(start <= end) {
			int mid = (start + end)/2;
			if (arr[mid] == target) {
				returnIndex = mid;
				break;
			}
			if(arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return returnIndex;
	}
}
