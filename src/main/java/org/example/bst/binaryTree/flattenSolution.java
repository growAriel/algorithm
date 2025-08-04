package org.example.bst.binaryTree;

import org.example.bst.twoSum.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.example.bst.binaryTree.invertBinaryTree.printTree;

public class flattenSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(5));
        System.out.println("Original Binary Tree:");
        printTree(root);
        flatten(root);
        System.out.println("\nFlattened Binary Tree:");
        printTree(root);
    }

    public static void flatten(TreeNode root) {
       List<TreeNode> list = new ArrayList<TreeNode>();
       preorderTraversal(root, list);
       for(int i = 0; i < list.size() - 1; i++) {
           TreeNode current = list.get(i);
           TreeNode next = list.get(i + 1);
           current.left = null; // Set left child to null
           current.right = next; // Set right child to the next node in the list
       }
    }

    public static void preorderTraversal(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }
}
