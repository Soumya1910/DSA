package com.dsa.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/*
* Problem Statement:
*
* Approach: The key to solving the "Maximum Area of Histogram" efficiently is to realize that for
*  each bar, you need to determine how far you can extend the rectangle to the left and right
* without encountering a bar shorter than the current one.

  To do this quickly, you compute:
  1. **Nearest Smaller to Left (NSL)** – For each bar at index `i`, find the closest index to the
  *  left with a height less than `heights[i]`.
  2. **Nearest Smaller to Right (NSR)** – For each bar at index `i`, find the closest index to
  * the right with a height less than `heights[i]`.

  Both NSL and NSR can be found in **O(n)** time using a **stack**:
  - **For NSL**: Traverse from left to right, popping elements from the stack until you find a
  * smaller height, and store its index.
  - **For NSR**: Traverse from right to left using the same approach.

  **Area calculation**:
  Once you have NSL and NSR for each bar:
  - The width for each bar is `(NSR[i] - NSL[i] - 1)`.
  - The area for each bar is `width * heights[i]`.
  - The maximum of all such areas is the answer.
*
* */
public class MaxAreaHistogram {
	public static void main(String[] args) {
		List<Integer> heights = List.of(6, 2, 5, 4, 5, 1, 6);
		System.out.println("Maximum area of histogram is: " + maxArea(heights));
	}

	private static int maxArea(List<Integer> heights) {
		List<Integer> nearestSmallerToLeft = findNearestElement(heights, false, false);
		System.out.println("NSL: " + nearestSmallerToLeft);
		List<Integer> nearestSmallerToRight = findNearestElement(heights, false, true);
		System.out.println("NSR: " + nearestSmallerToRight);
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < heights.size(); i++) {
			int width = nearestSmallerToRight.get(i) - nearestSmallerToLeft.get(i) - 1;
			int area = width * heights.get(i);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	/*
	*   For NSL, if none found → -1
		For NSR, if none found → n (heights.size())
	* */

	private static List<Integer> findNearestElement(List<Integer> heights, boolean isGreater,
	                                                boolean isRight) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		// Decide start and end
		int start = isRight ? heights.size() - 1 : 0;
		int end = isRight ? -1 : heights.size();
		int step = isRight ? -1 : 1;

		for (int i = start; i != end; i += step) {
			int element = heights.get(i);
			int position = i;

			// Pop until the stack's top satisfies the condition
			while ((!stack.isEmpty()) && (isGreater ? element >= heights.get(stack.peek()) :
					element <= heights.get(stack.peek()))) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result.add(isRight ? heights.size() : -1); // ✅ corrected bound handling
			} else {
				result.add(stack.peek());
			}
			stack.push(position);
		}
		if(isRight) {
			Collections.reverse(result);
		}
		return result;
	}
}
