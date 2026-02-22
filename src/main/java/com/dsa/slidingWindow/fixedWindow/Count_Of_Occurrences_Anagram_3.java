package com.dsa.slidingWindow.fixedWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Count Occurrences of Anagrams (Fixed Window)
 *
 * Given two strings:
 * - text (the larger string)
 * - pattern (the smaller string)
 *
 * Count how many substrings of text are anagrams (permutations) of pattern.
 * A substring is considered an anagram of pattern if it contains exactly the same
 * characters with the same frequencies, but possibly in a different order.
 *
 * Example:
 * text = "forxxorfxdofr"
 * pattern = "for"
 *
 * Substrings of length 3 (pattern length) that are anagrams of "for":
 * - "for"  (index 0..2)
 * - "orf"  (index 5..7)
 * - "ofr"  (index 10..12)
 *
 * Output:
 * 3
 *
 * Notes:
 * - This is a fixed-size sliding window problem where window size = pattern.length().
 * - Typical approach: frequency map/array + sliding window comparison.
 * - Time complexity: O(n) where n = text.length().
 */
public class Count_Of_Occurrences_Anagram_3 {
	public static void main(String[] args) {
		String text = "forxxorfxdofr";
		String pattern = "for";
		System.out.println("Count of occurrences: " + countAnagramOccurrences(text, pattern));
	}

	private static int countAnagramOccurrences(String text, String pattern) {
		// Guard clause: invalid inputs or pattern longer than text => no anagrams possible
		if (text == null || pattern == null || pattern.isEmpty() || text.length() < pattern.length()) {
			return 0;
		}
		int anagramCount = 0;
		Map<Character, Integer> patternMap = new HashMap<>();
		// Step 1: Build the pattern window [0 .. windowSize-1]
		for (char c : pattern.toCharArray()) {
			patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
		}
		int windowSize = pattern.length();
		Map<Character, Integer> windowMap = new HashMap<>();
		// Step 2: build the first window
		for (int i = 0; i < windowSize; i++) {
			char c = text.charAt(i);
			windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
		}
		// If the first window has the exact same char frequencies as the pattern, count it
		if (patternMap.equals(windowMap)) {
			anagramCount++;
		}

		// Slide the window over the text
		for (int i = 1; i <= text.length() - windowSize; i++) {
			char leftChar = text.charAt(i - 1);
			char rightChar = text.charAt(i + windowSize - 1);
			// remove the left character from the window map
			if (windowMap.get(leftChar) > 1) {
				windowMap.put(leftChar, windowMap.get(leftChar) - 1);
			} else {
				windowMap.remove(leftChar);
			}

			// Add the right character to the window map
			windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

			// check if the current window is an anagram of the pattern
			if (patternMap.equals(windowMap)) {
				anagramCount++;
			}
		}
		return anagramCount;
	}
}
