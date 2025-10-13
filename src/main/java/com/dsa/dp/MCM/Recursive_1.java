package com.dsa.dp.MCM;

public class Recursive_1 {

	/*
Problem Statement: You are given an array arr[] of dimensions representing a sequence of matrices
 such that the ith matrix has dimensions: (arr[i-1] x arr[i]).
 Your task is to find the minimum number of scalar multiplications required to multiply all the matrices together.
 Details:
	- Matrix multiplication is associative — meaning you can multiply in any order, e.g. (A×B)×C
	or A×(B×C) — but the number of scalar multiplications required can differ depending on how you place the parentheses.
	- The goal is to determine the optimal parenthesization (order of multiplication) that results
	 in the lowest multiplication cost.
 Input Format:
	- An integer array arr[] of length n
	- n-1 matrices in the chain.
	- The ith matrix has dimensions: arr[i-1] rows × arr[i] columns.
 Output Format:
	- A single integer representing the minimum scalar multiplication cost.
 Constraints:
	- 2 ≤ n ≤ 100 (i.e., at least one matrix multiplication is needed)
	- Dimensions are positive integers.
	- Matrix multiplication is valid (the number of columns in Matrix[i] == number of rows in
	Matrix[i+1]).

 Example:
     Input: arr = [40, 20, 30, 10, 30]
     Interpretation:
		M1: 40 × 20
		M2: 20 × 30
		M3: 30 × 10
		M4: 10 × 30
	Output: 2600
	Explanation: The optimal parenthesization is ( (M1 × M2) × (M3 × M4) ), which results in a total of 2600 scalar multiplications.
	* */



	public static void main(String[] args) {
		int[] arr = {40, 20, 30, 10, 30};
		System.out.println("Minimum cost is: " + minCost(arr, 1, arr.length - 1));
		/*
		* Why start from `i=1` and `j=arr.length-1`?
		* - `i` represents the first matrix, `j` represents the last matrix.
		* - i and j represent the range of matrices we want to multiply.
		* - We start from `i=1` because we have already multiplied the first matrix with the second matrix.
		* - We end at `j=arr.length-1` because we have already multiplied the last matrix with the second-to-last matrix.
		* - The minimum cost to multiply all the matrices together is the sum of the minimum cost to multiply each pair of adjacent matrices and the cost of multiplying the first matrix with the last matrix.
		 * */
	}

	private static int minCost(int[] arr, int i, int j) {
		if (i >= j) {
			// If there is only one matrix, it doesn't require any multiplication.
			// i == j → single matrix.
			// i > j → invalid range (happens in recursion).
			return 0;
		}
		int min = Integer.MAX_VALUE;
		// Try to multiply each pair of adjacent matrices and keep track of the minimum cost.
		// Recursion loop — trying all split points: Try splitting the chain at every possible position k.
		//                  Left side: matrices i to k.
		//                  Right side: matrices k+1 to j.
		/*
			Why k starts from i
				We must always have at least one matrix on the left side, so the first split happens after matrix i.
				For example:
					If i = 1 and j = 4 (M1 to M4),
					possible first splits:
						Split after M1         → Left = M1, Right = M2..M4
						Split after M2         → Left = M1..M2, Right = M3..M4
						Split after M3         → Left = M1..M3, Right = M4
				If we started k < i, the left chain would be empty — meaningless in matrix multiplication.

			Why k ends at j - 1
				We must have at least one matrix on the right side.
				Stopping at k = j - 1 ensures Right chain contains at least one matrix.
				Example:
					If i = 1 and j = 4:
					Last split: k = 3
					Left = M1..M3
					Right = M4
				If we allowed k = j, Right chain would be empty → meaningless.

		* */
		for (int k = i; k <= j - 1; k++) {
			int temp = minCost(arr, i, k) + minCost(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			if (temp < min) {
				min = temp;
			}
		}

		return min;
	}
}



/*
arr = {40, 20, 30, 10, 30}
We have 4 matrices:
M1: 40 × 20
M2: 20 × 30
M3: 30 × 10
M4: 10 × 30
We call: minCost(1, 4)
And now I’ll annotate the recursion tree with actual costs.
Step 1 — Base cases
Any minCost(x, x) = 0 because it’s a single matrix.
Cost formula for a split:
cost = minCost(i, k) + minCost(k+1, j) + arr[i-1] * arr[k] * arr[j]
Step 2 — Annotated Recursion Tree
minCost(1,4)
├── k=1:
│    Left: minCost(1,1) = 0
│    Right: minCost(2,4)
│    │
│    │   minCost(2,4)
│    │   ├── k=2:
│    │   │     Left: minCost(2,2) = 0
│    │   │     Right: minCost(3,4)
│    │   │     │
│    │   │     │   minCost(3,4)
│    │   │     │   └── k=3:
│    │   │     │         Left: minCost(3,3) = 0
│    │   │     │         Right: minCost(4,4) = 0
│    │   │     │         Join cost = arr[2]*arr[3]*arr[4] = 30*10*30 = 9000
│    │   │     │         Total cost = 0+0+9000 = **9000**
│    │   │
│    │   │     Join cost (M2 × result_of(3,4)) = arr[1]*arr[2]*arr[4] = 20*30*30 = 18000
│    │   │     Total cost = 0+9000+18000 = **27000**
│    │   │
│    │   └── k=3:
│    │         Left: minCost(2,3)
│    │         │   └── k=2:
│    │         │         Left: minCost(2,2)=0
│    │         │         Right: minCost(3,3)=0
│    │         │         Join cost = arr[1]*arr[2]*arr[3] = 20*30*10 = 6000
│    │         │         Total = **6000**
│    │         Right: minCost(4,4) = 0
│    │         Join cost (result_of(2,3) × M4) = arr[1]*arr[3]*arr[4] = 20*10*30 = 6000
│    │         Total cost = 6000+0+6000 = **12000**
│    │
│    │ Total min for minCost(2,4) = min(27000, 12000) = **12000**
│
│    Join cost (M1 × result_of(2,4)) = arr[0]*arr[1]*arr[4] = 40*20*30 = 24000
│    Total cost = 0+12000+24000 = **36000**
│
├── k=2:
│    Left: minCost(1,2)
│    │   └── k=1:
│    │         Left: minCost(1,1)=0
│    │         Right: minCost(2,2)=0
│    │         Join cost = arr[0]*arr[1]*arr[2] = 40*20*30 = 24000
│    │         Total = **24000**
│    Right: minCost(3,4)
│        (from above) = **9000**
│    Join cost (result_of(1,2) × result_of(3,4)) = arr[0]*arr[2]*arr[4] = 40*30*30 = 36000
│    Total cost = 24000+9000+36000 = **69000**
│
├── k=3:
│    Left: minCost(1,3)
│    │   ├── k=1:
│    │   │     Left: minCost(1,1)=0
│    │   │     Right: minCost(2,3)
│    │   │     │   └── k=2:
│    │   │     │         Left: minCost(2,2)=0
│    │   │     │         Right: minCost(3,3)=0
│    │   │     │         Join cost = arr[1]*arr[2]*arr[3] = 20*30*10 = 6000
│    │   │     │         Total = **6000**
│    │   │     Join cost (M1 × result_of(2,3)) = arr[0]*arr[1]*arr[3] = 40*20*10 = 8000
│    │   │     Total cost = 0+6000+8000 = **14000**
│    │   └── k=2:
│    │         Left: minCost(1,2) = **24000**
│    │         Right: minCost(3,3) = 0
│    │         Join cost = arr[0]*arr[2]*arr[3] = 40*30*10 = 12000
│    │         Total cost = 24000+0+12000 = **36000**
│    │
│    │ Total min for minCost(1,3) = min(14000, 36000) = **14000**
│    Right: minCost(4,4) = 0
│    Join cost = arr[0]*arr[3]*arr[4] = 40*10*30 = 12000
│    Total cost = 14000+0+12000 = **26000**
│
└── Final result:
    minCost(1,4) = min( **36000**, **69000**, **26000** ) = **26000**
Final Answer
✅ Optimal cost = 26000 scalar multiplications
🔹 Achieved with k = 3 → split (M1, M2, M3) and (M4).

* */
