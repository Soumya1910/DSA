package com.dsa.tree;

public class MaxHeightOfTree_1 {

    public static void main(String[] args) {
        // Creating a sample tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum height of the tree: " + findMaxHeight(root));
    }

    public static int findMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNodeHeight = findMaxHeight(root.left);
        int rightNodeHeight = findMaxHeight(root.right);
        return Math.max(leftNodeHeight, rightNodeHeight) + 1;
    }

    /*
    * ### Explanation of the Code

The code calculates the **maximum height (or depth)** of a binary tree using a **recursive approach**. The height of a binary tree is defined as the number of edges on the longest path from the root node to a leaf node. If the tree is empty, the height is `0`.

---

### Steps and Approach

1. **Base Case**:
   - If the `root` is `null` (i.e., the tree or subtree is empty), the height is `0`. This is the termination condition for the recursion.

2. **Recursive Case**:
   - Recursively calculate the height of the left subtree (`findMaxHeight(root.left)`).
   - Recursively calculate the height of the right subtree (`findMaxHeight(root.right)`).

3. **Combine Results**:
   - The height of the current node is the **maximum** of the heights of its left and right subtrees, plus `1` (to account for the current node).

4. **Return the Result**:
   - Return the calculated height for the current node.

---

### Dry Run with the Example Tree

The tree structure is as follows:

```
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
```

#### Step-by-Step Execution:

1. **Start at the Root (Node 1)**:
   - Call `findMaxHeight(root)` where `root = 1`.

2. **Recursive Call for Left Subtree (Node 2)**:
   - Call `findMaxHeight(root.left)` where `root.left = 2`.

3. **Recursive Call for Left Subtree of Node 2 (Node 4)**:
   - Call `findMaxHeight(root.left)` where `root.left = 4`.
   - Node 4 is a leaf node, so both `findMaxHeight(root.left)` and `findMaxHeight(root.right)` return `0`.
   - Height of Node 4 = `max(0, 0) + 1 = 1`.

4. **Recursive Call for Right Subtree of Node 2 (Node 5)**:
   - Call `findMaxHeight(root.right)` where `root.right = 5`.
   - Node 5 is a leaf node, so both `findMaxHeight(root.left)` and `findMaxHeight(root.right)` return `0`.
   - Height of Node 5 = `max(0, 0) + 1 = 1`.

5. **Combine Results for Node 2**:
   - Height of Node 2 = `max(1, 1) + 1 = 2`.

6. **Recursive Call for Right Subtree (Node 3)**:
   - Call `findMaxHeight(root.right)` where `root.right = 3`.

7. **Recursive Call for Left Subtree of Node 3 (Node 6)**:
   - Call `findMaxHeight(root.left)` where `root.left = 6`.
   - Node 6 is a leaf node, so both `findMaxHeight(root.left)` and `findMaxHeight(root.right)` return `0`.
   - Height of Node 6 = `max(0, 0) + 1 = 1`.

8. **Recursive Call for Right Subtree of Node 3 (Node 7)**:
   - Call `findMaxHeight(root.right)` where `root.right = 7`.
   - Node 7 is a leaf node, so both `findMaxHeight(root.left)` and `findMaxHeight(root.right)` return `0`.
   - Height of Node 7 = `max(0, 0) + 1 = 1`.

9. **Combine Results for Node 3**:
   - Height of Node 3 = `max(1, 1) + 1 = 2`.

10. **Combine Results for Root Node (Node 1)**:
    - Height of Node 1 = `max(2, 2) + 1 = 3`.

---

### Final Output

The maximum height of the tree is `3`.

---

### Dry Run Table

| Node | Left Subtree Height | Right Subtree Height | Height of Node |
|------|----------------------|-----------------------|----------------|
| 4    | 0                    | 0                     | 1              |
| 5    | 0                    | 0                     | 1              |
| 2    | 1                    | 1                     | 2              |
| 6    | 0                    | 0                     | 1              |
| 7    | 0                    | 0                     | 1              |
| 3    | 1                    | 1                     | 2              |
| 1    | 2                    | 2                     | 3              |

---

### Key Points

1. **Recursive Nature**:
   - The function works by breaking the problem into smaller subproblems (finding the height of left and right subtrees) and combining their results.

2. **Time Complexity**:
   - Each node is visited once, so the time complexity is **O(n)**, where `n` is the number of nodes in the tree.

3. **Space Complexity**:
   - The space complexity is **O(h)**, where `h` is the height of the tree, due to the recursive call stack.

This approach is efficient and works well for binary trees of any size.
    *
    * */
}
