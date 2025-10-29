package com.dsa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Problem Statement:
* the span should represent the number of consecutive previous days (including current day) the price was less than or equal to the current day's price.
* */

public class StockSpanProblem {
	public static void main(String[] args) {
		List<Integer> stockPrices = List.of(100, 80, 60, 70, 60, 75, 85);
        List<Integer> span = calculateSpan(stockPrices);
        System.out.println("Stock Prices: " + stockPrices);
        System.out.println("Span: " + span);
	}

	private static List<Integer> calculateSpan(List<Integer> stockPrices) {
		return findNextElement(stockPrices, true, false);
	}

	private static List<Integer> findNextElement(List<Integer> element, boolean isGreater,
	                                             boolean isRight) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		// Decide start and end
		int start = isRight ? element.size() - 1 : 0;
		int end = isRight ? -1 : element.size();
		int step = isRight? -1 : 1;

		for(int i = start; i!= end; i+=step) {
			int index = i;
			int e = element.get(i);
			while((!stack.isEmpty()) && (isGreater ? element.get(stack.peek()) <= e :
					element.get(stack.peek()) >= e)) {
				stack.pop();
			}
			result.add(stack.isEmpty() ? (index + 1) : index - stack.peek()); // all previous
			// days, including today when stack is empty.
			stack.push(index);
		}

		return result;
	}

}
