package com.dsa.binarySearch;

public class Binary_Search_ReverseArray_2 {
	public static void main(String[] args) {
		int[] arr = { 15, 13, 11, 9, 7, 5, 3, 1 };
        int target = 11;
        int result = binarySearch(arr, target);
        System.out.println("Element found at index: " + result);
	}

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
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return returnIndex;
	}
}
