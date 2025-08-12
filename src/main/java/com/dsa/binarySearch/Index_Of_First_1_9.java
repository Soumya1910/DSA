package com.dsa.binarySearch;

public class Index_Of_First_1_9 {
	public static void main(String[] args) {
		int[] arr = new int[]{0,0,0,0,1,1,1,1,1,1,1,1};
		System.out.println("Index of First one is " + findIndexOfFirstOne(arr));

	}

	public static int findIndexOfFirstOne(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			int nextIndex = (mid+1) %arr.length;
			int prevIndex = (mid + arr.length - 1) % arr.length;
			if(arr[mid] == 1) {
				if (arr[prevIndex] == 1) {
					end = mid - 1;
				} else {
					return mid;
				}
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}
}
