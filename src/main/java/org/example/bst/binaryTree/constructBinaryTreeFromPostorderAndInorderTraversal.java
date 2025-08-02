package org.example.bst.binaryTree;

import org.example.bst.twoSum.TreeNode;

import static org.example.bst.binaryTree.invertBinaryTree.printTree;

public class constructBinaryTreeFromPostorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);
        printTree(root);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null; // Base case: no elements to construct the tree
        }

        // The last element in postorder is the root
        int rootValue = postorder[postEnd];
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
        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
