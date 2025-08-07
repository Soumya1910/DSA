package com.dsa.binarySearch;

public class FloorElementInSortedArray_8 {
	public static void main(String[] args) {
		int arr[] = {1, 2, 8, 10, 15, 17, 20};
        int x = 9;

        System.out.println("Floor of " + x + " is: " + findFloor(arr, x));
		System.out.println("Ceiling of " + x + " is: " + findCeiling(arr, x));
	}

	/*
	 * Approach Description:
	 *
	 * This implementation finds the floor of a given element x in a sorted array using a modified binary search.
	 * The "floor" of x is defined as the greatest element in the array that is less than or equal to x.
	 *
	 * Key Steps:
	 * 1. If x is greater than the largest element in the array, the largest element is immediately returned as the floor.
	 * 2. The algorithm performs a binary search:
	 *    - If arr[mid] == x, x itself is the floor.
	 *    - If arr[mid] < x and arr[nextIndex] > x, arr[mid] is the floor (the largest value less than x).
	 *    - If arr[mid] > x and arr[prevIndex] < x, arr[prevIndex] is the floor.
	 *    - The search space is adjusted by moving the start or end pointers based on the comparison between arr[mid] and x.
	 * 3. If no floor is found (i.e., x is smaller than the smallest element), -1 is returned.
	 *
	 * This approach ensures O(log n) time complexity by leveraging the properties of binary search on a sorted array.
	 */
	private static int findFloor(int[] arr, int x) {
		int start = 0, end = arr.length - 1;
		if (x > arr[end]) {
			return arr[end];
		}
		while(start <= end) {
			int mid = start + (end - start) / 2;
			int prevIndex = (mid + arr.length - 1) % arr.length;
			int nextIndex = (mid + 1) % arr.length;
			if(arr[mid] == x) {
                return arr[mid];
            }
			if (arr[mid] < x && arr[nextIndex] > x) {
				return arr[mid];
			}
			if (arr[mid] > x && arr[prevIndex] < x) {
				return arr[prevIndex];
			}
			if (arr[mid] > x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return Integer.MIN_VALUE;
	}


	private static int findCeiling(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		if (target < arr[start]) {
			return arr[start];
		}
		while (start <= end) {
			int mid = start + (end - start) / 2;
            int prevIndex = (mid + arr.length - 1) % arr.length;
            int nextIndex = (mid + 1) % arr.length;

            if (arr[mid] == target) {
                return arr[mid];
            }

            if (arr[mid] < target && arr[nextIndex] > target) {
                return arr[nextIndex];
            }

            if (arr[mid] > target && arr[prevIndex] < target) {
                return arr[mid];
            }

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
		}

		return Integer.MAX_VALUE;
	}





}
