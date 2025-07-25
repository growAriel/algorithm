package org.example.bst.binaryTree;

import org.example.bst.twoSum.TreeNode;

public class isSymmetricSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println("Is the binary tree symmetric? " + new isSymmetricSolution().isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // Both nodes are null, symmetric
        }
        if (left == null || right == null) {
            return false; // One node is null, not symmetric
        }
        // Check if the values are equal and recursively check the subtrees
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);

    }
}
