package com.dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
* It's exactly same as FindNextGreaterElementToRight with a small change.
* Change: 1) We have to find the next greater element in the left array for any given element.
* Hence, we have to traverse from left to right.
* 2) We don't need to reverse the output.
* */

public class NextLargestElementToLeft {
	public static void main(String[] args) {
		List<Integer> elements = Arrays.asList(1, 3, 0, 0, 1, 2, 4); // Output: [-1,-1,3,3,3,3,-1]
		//List<Integer> elements = Arrays.asList(1, 3, 2, 4); // [-1, -1, 3, -1]
		List<Integer> output = findNextGreaterElementToLeft(elements);
		System.out.println(output);
	}

	private static List<Integer> findNextGreaterElementToLeft(List<Integer> elements) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<elements.size(); i++) {
			int e = elements.get(i);
			if(stack.isEmpty()) {
				result.add(-1);
                stack.push(e);
			} else if (e >= stack.peek()) {
				while(!stack.isEmpty() && e >= stack.peek()) {
					stack.pop();
				}
				result.add(stack.isEmpty() ? -1: stack.peek());
				stack.push(e);
			} else {
				result.add(stack.peek());
				stack.push(e);
			}
		}
		return result;
	}
}
