package com.dsa.tree.dfs;

import com.dsa.tree.TreeNode;

import java.util.Stack;

public class Iterative_PreOrder_Traversal {

    public static void main(String[] args) {
        // Creating a complex tree:
        //                1
        //             /     \
        //           2         3
        //         /   \     /   \
        //        4     5   6     7
        //       / \   /       \
        //      8   9 10        11

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);

        System.out.println("Pre-Order Traversal without recursion");
        preOrderTraversal(root);
    }

    /**
     * Performs a pre-order traversal of a binary tree without using recursion.
     * The traversal visits nodes in the order: root, left subtree, right subtree.
     *
     * @param root the root node of the binary tree to traverse. If the tree is empty, the method does nothing.
     */
    public static void preOrderTraversal(TreeNode root ) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.value + " ");

            // Process the right child first (since it's added to the stack first) and then the left child
            if(currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if(currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    /*
    * Summary of the Approach:
The preOrderTraversal method performs an iterative pre-order traversal of a binary tree using a stack. Pre-order traversal visits nodes in the following order:
1.
Root
2.
Left Subtree
3.
Right Subtree
Since recursion is not used, a stack is employed to simulate the function call stack that would be used in a recursive approach. The stack helps keep track of nodes to be visited in the correct order.
Step-by-Step Approach:
1.
Base Case:
If the root is null, the method returns immediately, as there is no tree to traverse.
2.
Stack Initialization:
A Stack is created to hold nodes during traversal.
The root node is pushed onto the stack as the starting point.
3.
Traversal Loop:
The loop continues until the stack is empty, meaning all nodes have been visited.
At each iteration:
The top node is popped from the stack and its value is printed.
If the node has a right child, the right child is pushed onto the stack.
If the node has a left child, the left child is pushed onto the stack.
Note: The right child is pushed before the left child to ensure that the left child is processed first (since the stack is LIFO - Last In, First Out).
4.
End of Traversal:
Once the stack is empty, the traversal is complete, and all nodes have been visited in pre-order.
Dry Run:
For the given binary tree:
                1
             /     \
           2         3
         /   \     /   \
        4     5   6     7
       / \   /       \
      8   9 10        11
Initial State:
Stack: [1]
Output: []
Iteration 1:
Pop 1 from the stack.
Print 1.
Push 3 (right child) and 2 (left child) onto the stack.
Stack: [3, 2]
Output: [1]
Iteration 2:
Pop 2 from the stack.
Print 2.
Push 5 (right child) and 4 (left child) onto the stack.
Stack: [3, 5, 4]
Output: [1, 2]
Iteration 3:
Pop 4 from the stack.
Print 4.
Push 9 (right child) and 8 (left child) onto the stack.
Stack: [3, 5, 9, 8]
Output: [1, 2, 4]
Iteration 4:
Pop 8 from the stack.
Print 8.
Stack: [3, 5, 9]
Output: [1, 2, 4, 8]
Iteration 5:
Pop 9 from the stack.
Print 9.
Stack: [3, 5]
Output: [1, 2, 4, 8, 9]
Iteration 6:
Pop 5 from the stack.
Print 5.
Push 10 (left child) onto the stack.
Stack: [3, 10]
Output: [1, 2, 4, 8, 9, 5]
Iteration 7:
Pop 10 from the stack.
Print 10.
Stack: [3]
Output: [1, 2, 4, 8, 9, 5, 10]
Iteration 8:
Pop 3 from the stack.
Print 3.
Push 7 (right child) and 6 (left child) onto the stack.
Stack: [7, 6]
Output: [1, 2, 4, 8, 9, 5, 10, 3]
Iteration 9:
Pop 6 from the stack.
Print 6.
Push 11 (right child) onto the stack.
Stack: [7, 11]
Output: [1, 2, 4, 8, 9, 5, 10, 3, 6]
Iteration 10:
Pop 11 from the stack.
Print 11.
Stack: [7]
Output: [1, 2, 4, 8, 9, 5, 10, 3, 6, 11]
Iteration 11:
Pop 7 from the stack.
Print 7.
Stack: []
Output: [1, 2, 4, 8, 9, 5, 10, 3, 6, 11, 7]

    *
    * */
}
