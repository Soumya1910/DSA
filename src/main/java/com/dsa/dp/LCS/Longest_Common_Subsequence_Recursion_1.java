package com.dsa.dp.LCS;

public class Longest_Common_Subsequence_Recursion_1 {
	public static void main(String[] args) {
		String str1 = "abcdfh";
		String str2 = "abegh";
		System.out.println("The length of longest common subsequence is : " + findLengthOfLongestCommonSubsequence(str1, str2, str1.length(), str2.length()));

		/*
		*        ┌───────────────────────────────┐
                 │ Compare last characters:      │
                 │ str1[length1-1], str2[length2-1] │
                 └───────────────────────────────┘
                     /                    \
        Characters match              Characters don't match
         (add 1 + both -1)              (take max of two choices)
          /       \                        /         \
LCS(length1-1, length2-1)        LCS(length1, length2-1)
                                 LCS(length1-1, length2)
		*
		* */
	}

	/*
	Complete Recursion Tree

LCS("abcdfh", "abegh")
│   h == h  ✅
├── 1 + LCS("abcdf", "abeg")
    │   f != g ❌
    ├── LCS("abcdf", "abe")            (drop last from s2)
    │   │   f != e ❌
    │   ├── LCS("abcdf", "ab")         (drop last from s2)
    │   │   │   f != b ❌
    │   │   ├── LCS("abcdf", "a")      (drop last from s2)
    │   │   │   │   f != a ❌
    │   │   │   ├── LCS("abcdf", "")   → 0  (BASE CASE)
    │   │   │   └── LCS("abcd", "a")   (drop last from s1)
    │   │   │       │   d != a ❌
    │   │   │       ├── LCS("abcd", "") → 0  (BASE CASE)
    │   │   │       └── LCS("abc", "a")
    │   │   │           │   c != a ❌
    │   │   │           ├── LCS("abc", "") → 0
    │   │   │           └── LCS("ab", "a")
    │   │   │               │   b != a ❌
    │   │   │               ├── LCS("ab", "") → 0
    │   │   │               └── LCS("a", "a")
    │   │   │                   │ a == a ✅
    │   │   │                   └── 1 + LCS("", "") → 1
    │   │   └── LCS("abcd", "ab") (drop last from s1)
    │   │       │   d != b ❌
    │   │       ├── LCS("abcd", "a")
    │   │       │   (similar expansion as above → yields 1)
    │   │       └── LCS("abc", "ab")
    │   │           │   c != b ❌
    │   │           ├── LCS("abc", "a") → (yields 1)
    │   │           └── LCS("ab", "ab")
    │   │               │   b == b ✅
    │   │               └── 1 + LCS("a", "a") → 1 + 1 = 2
    │   └── LCS("abcd", "abe")         (drop last from s1)
    │       │   d != e ❌
    │       ├── LCS("abcd", "ab") → (already expanded above)
    │       └── LCS("abc", "abe")
    │           │   c != e ❌
    │           ├── LCS("abc", "ab") → yields 2
    │           └── LCS("ab", "abe")
    │               │   b != e ❌
    │               ├── LCS("ab", "ab") → yields 2
    │               └── LCS("a", "abe")
    │                   │   a != e ❌
    │                   ├── LCS("a", "ab")
    │                   │   a != b ❌
    │                   │   ├── LCS("a", "a") → yields 1
    │                   │   └── LCS("", "ab") → 0
    │                   └── LCS("", "abe") → 0
    └── LCS("abcd", "abeg")            (drop last from s1)
        │   d != g ❌
        ├── LCS("abcd", "abe")         (drop last from s2)
        │   (already expanded above → yields 2)
        └── LCS("abc", "abeg")         (drop last from s1)
            │   c != g ❌
            ├── LCS("abc", "abe") → yields 2
            └── LCS("ab", "abeg")
                │   b != g ❌
                ├── LCS("ab", "abe")
                │   │   b != e ❌
                │   │   ├── LCS("ab", "ab") → yields 2
                │   │   └── LCS("a", "abe") → yields 1
                └── LCS("a", "abeg")
                    │   a != g ❌
                    ├── LCS("a", "abe") → yields 1
                    └── LCS("", "abeg") → 0
	*
	* */

	private static int findLengthOfLongestCommonSubsequence(String str1, String str2, int length1,
	                                                        int length2) {
		// first base condition
		if (length1 == 0 || length2 == 0) {
			return 0;
		}
		// Choice diagram
		if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) {
			/*
			* That means:
				This character is part of LCS.
				We add 1 to the count (because of the matching character).
				We then move one step back in both strings (since we’ve used those characters).
			*
			* */
			return 1 + findLengthOfLongestCommonSubsequence(str1, str2, length1 - 1, length2 - 1);
		} else {

			/*
			* That means:
				We have to either discard the last character from str1 or from str2 and try again.
				We take the maximum result from these two possibilities
			*
			* */
			return Math.max(
					findLengthOfLongestCommonSubsequence(str1, str2, length1, length2 - 1),
					findLengthOfLongestCommonSubsequence(str1, str2, length1 - 1, length2)
			);
		}
	}
}
