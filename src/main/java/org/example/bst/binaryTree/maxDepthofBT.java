package org.example.bst.binaryTree;

import org.example.bst.twoSum.TreeNode;

public class maxDepthofBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println("Max Depth of Binary Tree: " + maxDepth(root)); // Output: 3
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if the node is null, depth is 0
        }
        // Recursively find the max depth of left and right subtrees and add 1 for the current node
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
