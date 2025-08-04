package org.example.bst.binaryTree;

import org.example.bst.twoSum.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class pathSumII {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4, null, new TreeNode(5));

        int targetSum = 22;
        List<List<Integer>> paths = pathSum(root, targetSum);
        System.out.println(paths);
    }

    public static List<List<Integer>> paths  = new LinkedList<List<Integer>>();
    public static List<Integer> path = new LinkedList<Integer>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path(root, targetSum);
        return paths;
    }

    public static void path(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum){
            paths.add(new LinkedList<>(path));
        }

        path(root.left, targetSum - root.val);
        path(root.right, targetSum - root.val);
        path.removeLast();
    }
}
