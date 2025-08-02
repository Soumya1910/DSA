package com.dsa.binarySearch;

import static com.dsa.binarySearch.BS_ReverseArray_2.binarySearchDescending;
import static com.dsa.binarySearch.Binary_Search_1.binarySearchAscending;

public class BS_Order_Unknown_3 {
	public static void main(String[] args) {
		// Here we have an array which is sorted but don't know if it's sorted in ascending or descending order.
		int[] arr = { 12, 15, 18, 20, 25, 30, 35, 40, 45, 50, 55, 60 };
        int target = 35;
        int result = binarySearchOrderUnknown3(arr, target);
        System.out.println("Element found at index: " + result);
	}

	private static int binarySearchOrderUnknown3(int[] arr, int target) {
		// First we will compare the first and last elements of the array.
		// If first element is lesser than equal to last element, then the array is sorted in ascending order.
		// If first element is greater than last element, then the array is sorted in descending order.
        if (arr[0] <= arr[arr.length - 1]) {
            return binarySearchAscending(arr, target);
        } else {
            return binarySearchDescending(arr, target);
        }
	}
}
