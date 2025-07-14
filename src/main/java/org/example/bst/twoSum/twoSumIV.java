package org.example.bst.twoSum;

public class twoSumIV {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;
        findTargetSolution result = new findTargetSolution(root, k);
        boolean isFound = result.findTargetHelper(root, k);
        System.out.println("Is there a pair that sums to " + k + "? " + isFound);


        boolean isFound2 = result.findTargetHelper(root, 28);
        System.out.println("Is there a pair that sums to 28? " + isFound2);
    }
}

