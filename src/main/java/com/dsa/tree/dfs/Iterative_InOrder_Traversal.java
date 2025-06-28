package com.dsa.tree.dfs;

import com.dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative_InOrder_Traversal {

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

        System.out.println("In-Order Traversal without recursion");
        inOrderTraversal(root);
    }

    /**
     * Performs a pre-order traversal of a binary tree without using recursion.
     * The traversal visits nodes in the order: root, left subtree, right subtree.
     *
     * @param root the root node of the binary tree to traverse. If the tree is empty, the method does nothing.
     */

    /* Approach:
      Step 1: Push current node in Stack and Traverse to the leftmost node
      Step 2: Process the node at the top of the stack
      Step 3: Move to the right subtree
    * */

    /*Steps:
1. Initialization:
        Create an empty stack to store nodes.
        Start with the root node as the current node.
2. Traverse to the Leftmost Node:
        Push the current node onto the stack.
        Move to the left child of the current node.
        Repeat this until the current node becomes null.
3. Process the Node:
        Pop the top node from the stack.
        Process the node (e.g., add its value to the result list).
4. Move to the Right Subtree:
        Set the current node to the right child of the popped node.
5. Repeat:
        Continue steps 2–4 until both the stack is empty and the current node is null.
* */


    public static void inOrderTraversal(TreeNode root ) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.empty()) {
            // Step 1: Push current node in Stack and Traverse to the leftmost node
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            // Step 2: Process the node at the top of the stack
            currentNode = stack.pop();
            list.add(currentNode.value);

            // Step 3: Move to the right subtree
            currentNode = currentNode.right;
        }
        System.out.println(list);
    }
}
