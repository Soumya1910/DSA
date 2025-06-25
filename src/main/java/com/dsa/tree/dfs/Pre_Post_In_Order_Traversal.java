package com.dsa.tree.dfs;

import com.dsa.tree.TreeNode;

public class Pre_Post_In_Order_Traversal {
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

        // Performing preorder traversal on the tree
        System.out.println("Preorder traversal:");
        preOrder(root);

        // Performing postorder traversal on the tree
        System.out.println("\nPostorder traversal:");
        postOrder(root);

        // Performing inorder traversal on the tree
        System.out.println("\nInorder traversal:");
        inOrder(root);

        /*
        **********************************************
        Preorder traversal:
        1 2 4 5 3 6 7
        Postorder traversal:
        2 4 5 3 6 7 1
        Inorder traversal:
        2 4 5 1 3 6 7
        **********************************************
         */

    }

    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.value + " ");
    }

    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.value + " ");
        preOrder(root.right);
    }
}
