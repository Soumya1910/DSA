package com.dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GenericNextElement {
	/*
	* They are nearly identical except for:
1. Traversal direction (left→right vs right→left)
2. Comparison type (“greater” vs “smaller”).
3. Output order (reverse needed for right→left case).

`isGreater` → true means "next greater", false means "next smaller".
`isRight` → true means "search to the right", false means "search to the left".
The logic will adapt the comparison and traversal direction based on these flags.


How it works:
---------------------------------------------------------
Same stack logic for all cases.
isGreater changes the pop condition:
	==> Greater → pop until stack.peek() <= current
	==> Smaller → pop until stack.peek() >= current
isRight changes traversal & output reversal.

	*
	*
	*
	* */

	public static void main(String[] args) {
		List<Integer> elements = Arrays.asList(1, 3, 0, 0, 1, 2, 4);

		System.out.println("Next Greater to Left:   " + findNearestElement(elements, true, false));
		System.out.println("Next Greater to Right:  " + findNearestElement(elements, true, true));
		System.out.println("Next Smaller to Left:   " + findNearestElement(elements, false, false));
		System.out.println("Next Smaller to Right:  " + findNearestElement(elements, false, true));

	}

	private static List<Integer> findNearestElement(List<Integer> elements, boolean isGreater,
	                                         boolean isRight) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		// Decide traversal direction
		int start = isRight ? elements.size() - 1 : 0;
		int end = isRight ? -1 : elements.size();
		int step = isRight? -1 : 1;

		for (int i = start; i != end; i+=step) {
			int e = elements.get(i);
			// Pop until the stack's top satisfies the condition
			while(!stack.isEmpty() && (isGreater ? stack.peek() <= e : stack.peek() >= e)) {
				stack.pop();
			}

			// If stack empty, -1, else peek gives nearest
			result.add(stack.isEmpty()? -1 : stack.peek());
			// Push current element
			stack.push(e);
		}

		// If right direction, reverse results to match input order
		if (isRight) {
			Collections.reverse(result);
		}
		return result;
	}
}
