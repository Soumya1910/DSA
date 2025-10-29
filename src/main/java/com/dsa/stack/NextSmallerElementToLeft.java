package com.dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
* Approach:
-------------------------------------------------------------
Steps
1. If stack empty → No left element → result = -1, push current element.
2. If the top of stack is smaller → It’s the nearest smaller → add stack.peek(), push current
element.
3. If the top of stack is greater/equal → Pop until stack has a smaller element or becomes empty.
	If empty → -1
	Else → stack.peek() is nearest smaller.
	Push current element afterward.
* */

/*
Visual Table
| Step | e   | Action                                                         | Stack            | Result                  |
|------|-----|-----------------------------------------------------------------|------------------|-------------------------|
| 1    | 1   | stack empty → -1, push 1                                        | [1]              | [-1]                    |
| 2    | 3   | 3 > 1 → add 1, push 3                                           | [1, 3]           | [-1, 1]                 |
| 3    | 0   | pop 3, pop 1, empty → -1, push 0                                | [0]              | [-1, 1, -1]             |
| 4    | 0   | pop 0, empty → -1, push 0                                       | [0]              | [-1, 1, -1, -1]         |
| 5    | 1   | 1 > 0 → add 0, push 1                                           | [0, 1]           | [-1, 1, -1, -1, 0]      |
| 6    | 2   | 2 > 1 → add 1, push 2                                           | [0, 1, 2]        | [-1, 1, -1, -1, 0, 1]   |
| 7    | 4   | 4 > 2 → add 2, push 4                                           | [0, 1, 2, 4]     | [-1, 1, -1, -1, 0, 1, 2]|

* */

public class NextSmallerElementToLeft {
	public static void main(String[] args) {
		// List<Integer> elements = Arrays.asList(1, 3, 2, 4, 5); // Output: [-1, 1, 1, 2, 4]
		List<Integer> elements = Arrays.asList(1, 3, 0, 0, 1, 2, 4);
		List<Integer> output = findNextSmallerElementToLeft(elements);
		System.out.println(output);
	}

	private static List<Integer> findNextSmallerElementToLeft(List<Integer> elements) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < elements.size(); i++) {
			int e = elements.get(i);
			if (stack.isEmpty()) {
				result.add(-1);
				stack.push(e);
			} else if (e > stack.peek()) {
				result.add(stack.peek());
				stack.push(e);
			} else {
				while (!stack.isEmpty() && e <= stack.peek()) {
					stack.pop();
				}
				result.add(stack.isEmpty() ? -1 : stack.peek());
				stack.push(e);
			}
		}
		return result;
	}
}
