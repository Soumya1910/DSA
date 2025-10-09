# DSA
This is a repository for Program and analysis on Data Structure and Algorithm

# STACK

## How to Identify?
In Brute-force method, if second loop variable(j) is directly dependent on the first loop variable(i).

## Problem Statements
1. Nearest Greater/ Next Largest element to Left 
2. Nearest Greater/ Next Largest element to Right [NextLargestElementToRight](./src/main/java/com/dsa/stack/NextLargestElementToRight.java)
3. Nearest Smaller Element to Left
4. Nearest Smaller Element to Right
5. Stock Span Problem
6. Maximum Area of Histogram
7. Max area of Rectangle in Binary Matrix
8. Rain Water Trapping


# Binary Search

## Problem Statements
1. [Binary Search](./src/main/java/com/dsa/binarySearch/Binary_Search_1.java)
2. [Binary Search on reverse sorted array](./src/main/java/com/dsa/binarySearch/BS_ReverseArray_2.java)
3. [Order agnostic/unknown binary search](./src/main/java/com/dsa/binarySearch/BS_Order_Unknown_3.java)
4. [1st and last occurrence of BS](./src/main/java/com/dsa/binarySearch/First_Last_Occurrences_Element_4.java)
5. [Count of an element in a sorted array](./src/main/java/com/dsa/binarySearch/First_Last_Occurrences_Element_4.java)
6. [Number of times a sorted array is rotated](./src/main/java/com/dsa/binarySearch/NumberOfRotationOfSortedArray_5.java)
7. [Find an element in rotated sorted array](./src/main/java/com/dsa/binarySearch/SearchInRotatedArray_6.java)
8. [Searching in a nearly sorted array](./src/main/java/com/dsa/binarySearch/SearchInNearlySortedArray_7.java)
9. [Find floor of an element in a Sorted array](./src/main/java/com/dsa/binarySearch/FloorElementInSortedArray_8.java) 
10. [Ceil of an element in a sorted array](./src/main/java/com/dsa/binarySearch/FloorElementInSortedArray_8.java) 
11. Next alphabetical element
    - Apply the logic of finding ceiling value
12. Find position of an element in an infinite sorted array
    - Start index = 0, endIndex = 1;
    - Now we need to choose the strategy for selecting the endIndex. SearchKey is always in between startIndex and 
      endIndex.
    - Will increase endIndex until arr[endIndex] >= searchKey.
    - while(arr[endIndex] >= searchKey) { endIndex = endIndex * 2 }
    - Then apply Binary Search operation with startIndex and endIndex.
13. [Find the index of 1st 1 in a Binary Sorted Array](./src/main/java/com/dsa/binarySearch/Index_Of_First_1_9.java)
14. Minimum difference element in a sorted array


# Dynamic Programming

- One recursive call never leads to DP.
- If two methods are called in recursion, then there is a possibility that it will be a DP Problem.
- You need to find Optimal value (like Minimum iteration, max profit, largest/greatest etc.)
- DP Problem = Recursion + Storage (Memoization or Top-Down Approach)

## Problem Statements
1. [0-1 knapsack](./src/main/java/com/dsa/dp/bounded_knapsack/DP_Problem_1.java)
    * [Subset Sum](./src/main/java/com/dsa/dp/bounded_knapsack/SubSet_Sum_Problem_2.java)
    * [Equal sum partition](./src/main/java/com/dsa/dp/bounded_knapsack/Equal_Sum_Partition_3.java)
    * [Count of subset sum](./src/main/java/com/dsa/dp/bounded_knapsack/Count_SubSet_Sum_4.java)
    * [Minimum subset sum difference](./src/main/java/com/dsa/dp/bounded_knapsack/Minimum_SubSet_Sum_Difference_5.java)
    * [Number of subset with given difference](./src/main/java/com/dsa/dp/bounded_knapsack/Count_Number_Subset_Given_Difference_6.java)
    * [Target sum](./src/main/java/com/dsa/dp/bounded_knapsack/Target_Sum_7.java)
   
2. Unbounded Knapsack
    * [Rod Cutting Problem](./src/main/java/com/dsa/dp/unbounded_knapsack/Rod_Cutting_Problem_1.java)
    * [Coin change problem - Maximum number of ways](./src/main/java/com/dsa/dp/unbounded_knapsack/Max_Way_Coin_Change_2.java)
    * [Coin change problem - Minimum number of coins used](./src/main/java/com/dsa/dp/unbounded_knapsack/Min_Number_Of_Coin_Change_3.java)

3. Fibonacci
4. LCS(Longest Common Subsequences)
   * Longest common subsequences
     * [Recursion Method](./src/main/java/com/dsa/dp/LCS/Longest_Common_Subsequence_Recursion_1.java)
     * [Memoization Technique](./src/main/java/com/dsa/dp/LCS/Longest_Common_Subsequence_Memoization_2.java)
     * [Top-Down DP Approach](./src/main/java/com/dsa/dp/LCS/Longest_Common_Subsequence_DP_Top_Down_3.java)
   * [Longest Common SubString](./src/main/java/com/dsa/dp/LCS/Longest_Common_Substring_4.java)
   * [Print LCS](./src/main/java/com/dsa/dp/LCS/Print_LCS_5.java)
   * [Shortest Common Supersequences (SCS)](./src/main/java/com/dsa/dp/LCS/Shortest_Common_SuperSequence_6.java)
   * [Print SCS](./src/main/java/com/dsa/dp/LCS/Shortest_Common_SuperSequence_6.java)
   * Minimum number of Insertion and Deletion (a->b)
   * Largest repeating subsequences
   * Length of largest subsequence of which 
   * Subsequence pattern matching
   * Count how many times a appears as subsequence in b
   * Longest palindromic subsequences
   * Longest palindromic substring
   * Count of palindromic substring
   * Minimum number of deletion in a string to make it Palindrome
   * Minimum number of insertion in a string to make it Palindrome
5. LIS
6. Kadane's Algorithm
7. Matrix Chain Multiplications
8. DP on Trees
9. DP on Grid
10. Others