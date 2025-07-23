package org.example.bst.binaryTree;

import org.example.bst.twoSum.TreeNode;

public class isSameTreeSolution {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }
        // If one of the nodes is null, they are not the same
        if (p == null || q == null) {
            return false;
        }
        // Check if the current nodes' values are the same and recursively check left and right subtrees
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
