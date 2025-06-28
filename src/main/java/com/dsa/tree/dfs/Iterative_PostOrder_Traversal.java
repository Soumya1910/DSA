package com.dsa.tree.dfs;

import com.dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative_PostOrder_Traversal {
    public static void main(String[] args) {
        // Creating a sample tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        //       / \   /
        //      8   9 10
        //         /
        //        11
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        root.left.right.right.left = new TreeNode(11);

        // Expected output: [4, 8, 11, 9, 5, 2, 6, 10, 7, 3, 1]
        System.out.println("Post-Order Traversal without recursion:");
        postOrderTraversal(root);
    }

    /*
    * Steps:
    * 1. Initialization:
    *   Create two stacks, stack1 and stack2.
    *   Push the root node onto stack1.
    *
    * 2. Traversal the Tree:
    *   While stack1 is not empty:
    *       Pop a node from stack1 and push into stack2.
    *       If the node has left and right children, push the left and right children onto stack1.
    *
    * 3. Pop nodes from stack2 and print them
    * */

    private static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack1.push(root);

        while(!stack1.isEmpty()) {
            TreeNode currentNode = stack1.pop();
            System.out.println("Current node: " + currentNode.value + " Pushed to stack2 for post-order traversal.");
            stack2.push(currentNode);
            if(currentNode.left!= null) {
                stack1.push(currentNode.left);
            }
            if(currentNode.right!= null) {
                stack1.push(currentNode.right);
            }
        }

        // At this point, stack2 contains the nodes in post-order

        while(!stack2.isEmpty()) {
            result.add(stack2.pop().value);
        }

        // Print the result
        System.out.println(result);
    }
}
