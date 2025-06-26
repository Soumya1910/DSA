package com.dsa.tree.bfs;

import com.dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseTraversal {
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

        // Performing level-wise traversal on the tree
        System.out.println("Level-wise traversal:");
        levelOrder(root);

        /*
        **********************************************
        Level-wise traversal:
        [1]
        [2, 3]
        [4, 5, 6, 7]
        **********************************************
         */
    }

    /**
     * Performs a level-wise (breadth-first) traversal of a binary tree and prints each level's nodes.
     *
     * @param root The root node of the binary tree. If the root is null, the method does nothing.
     */
    private static void levelOrder(TreeNode root) {
        // Check if the root is null. If it is, there is no tree to traverse, so return immediately.
        if(root == null ) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i =0; i< queueSize; i++) {
                TreeNode currentNode = queue.poll();
                int val = currentNode.value;
                level.add(val);

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            System.out.println(level);
        }
    }


    /*Notes
    *
Step-by-Step Approach:
1.Base Case: If the root is null, the method immediately returns, as there is no tree to traverse.
2.Queue Initialization: A Queue is used to facilitate the traversal. The queue helps in processing nodes level by level.
The root node is added to the queue as the starting point of the traversal.
3. Outer Loop: The outer while loop runs until the queue is empty, meaning all nodes in the tree have been processed.
4. Processing Each Level: At the start of each iteration of the outer loop:
    The size of the queue (queueSize) is determined. This represents the number of nodes at the current level.
    A LinkedList (level) is initialized to store the values of nodes at the current level.
5. Inner Loop:The inner for loop iterates over all nodes at the current level (determined by queueSize).
For each node:
    It is removed from the front of the queue using poll().
    Its value is added to the level list.
    If the node has a left child, the left child is added to the queue.
    If the node has a right child, the right child is added to the queue.
6. Print Current Level: After processing all nodes at the current level, the level list (containing the values of
nodes at that level) is printed.

*
Key Points:
Breadth-First Search (BFS): The method uses BFS to traverse the tree level by level.
Queue Usage: The queue ensures that nodes are processed in the correct order (FIFO - First In, First Out).
Level Separation: The size of the queue at the start of each iteration of the outer loop determines the number of nodes at the current level, allowing the method to separate levels during traversal.
Example Walkthrough:
For the given binary tree:
         1
       /   \
      2     3
     / \   / \
    4   5 6   7
Initial State:
Queue: [1]
Level 1:
Process node 1.
Add its children (2 and 3) to the queue.
Print: [1]
Queue: [2, 3]
Level 2:
Process nodes 2 and 3.
Add their children (4, 5, 6, 7) to the queue.
Print: [2, 3]
Queue: [4, 5, 6, 7]
Level 3:
Process nodes 4, 5, 6, 7.
No children to add to the queue.
Print: [4, 5, 6, 7]
Queue: []
Complexity Analysis:
1.
Time Complexity: O(n)
Each node is visited exactly once, where n is the total number of nodes in the tree.
2.
Space Complexity: O(w)
The maximum space required is proportional to the width of the tree (w), which is the maximum number of nodes at any level. This is due to the queue storing all nodes at a given level.
This approach ensures an efficient and clear traversal of the binary tree level by level.
Workspace indexing: Done

    * */
}
