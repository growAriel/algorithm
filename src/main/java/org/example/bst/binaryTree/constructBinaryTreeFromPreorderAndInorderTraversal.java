package org.example.bst.binaryTree;

import org.example.bst.twoSum.TreeNode;

import static org.example.bst.binaryTree.invertBinaryTree.printTree;

public class constructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Constructed Binary Tree from Preorder and Inorder Traversal:");
        printTree(root);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null; // Base case: no elements to construct the tree
        }

        // The first element in preorder is the root
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root in inorder array
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // Calculate the number of nodes in the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
