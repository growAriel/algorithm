package org.example.bst.binaryTree;

import org.example.bst.twoSum.TreeNode;

public class invertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3));
        printTree(root);
        System.out.println("\nInverted Binary Tree:");
        printTree(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root){
        if(root ==null){
            return null; // Base case: if the node is null, return null
        }

        TreeNode temp = root.left; // Store the left subtree
        root.left = invertTree(root.right); // Recursively invert the right subtree and assign it to the left
        root.right = invertTree(temp); // Recursively invert the left subtree and assign it to the right

        return root; // Return the root of the inverted tree

    }
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print( node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
