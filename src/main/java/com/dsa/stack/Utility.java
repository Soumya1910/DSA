package com.dsa.stack;

import lombok.experimental.UtilityClass;

import java.util.Stack;

@UtilityClass
public class Utility {

	public static void displayStack(Stack<Integer> stack) {
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.println(stack.get(i));
		}
	}
}
