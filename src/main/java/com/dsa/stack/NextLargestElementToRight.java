package com.dsa.stack;

import java.util.*;

import static com.dsa.stack.Utility.displayStack;

/*
* Logic: 1. We should traverse the array from right to left.
*        2. If stack is empty then return -1
*        3. If current array element is greater than the top of the stack element then pop the element till the
* element from stack is greater than the array element OR stack is empty. Insert the array element into the stack.
*        4. If current array element is lesser than the top of the stack element then return the top of the stack
* element and insert the element into stack.
* */

public class NextLargestElementToRight {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 3, 0, 0, 1, 2, 4); // Output: [3, 4, 1, 1, 2, 4, -1]
        // List<Integer> elements = Arrays.asList(1, 3, 2, 4); // [3, 4, 4, -1]
        List<Integer> output = findNextGreaterElement(elements);
        Collections.reverse(output);
        System.out.println(output);
    }

    private static List<Integer> findNextGreaterElement(List<Integer> element) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = element.size() - 1; i >= 0; i--) {
            int e = element.get(i);
            //System.out.println("Element is: " + e + "\tList: " + list);
            // displayStack(stack);
            if (stack.empty()) {
                list.add(-1);
                stack.push(e);
            } else if (e >= stack.peek()) {
                while (e >= stack.peek() && !stack.empty()) {
                    stack.pop();
                }
                list.add(stack.pop());
                stack.push(e);
            } else {
                list.add(stack.peek());
                stack.push(e);
            }
        }
        return list;
    }


}
