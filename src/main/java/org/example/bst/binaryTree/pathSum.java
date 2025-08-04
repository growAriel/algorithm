package org.example.bst.binaryTree;

public class pathSum {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11, new Node(7), new Node(2));
        root.right.left = new Node(13);
        root.right.right = new Node(4, null, new Node(1));

        int targetSum = 22;
        boolean result = hasPathSum(root, targetSum);
        System.out.println("Has path sum " + targetSum + ": " + result);

    }
    public static boolean hasPathSum(Node root, int targetSum) {
        if (root == null) {
            return false;
        }
        // If we reach a leaf node, check if the remaining sum equals the node's value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        // Subtract the current node's value from the target sum and check both subtrees
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
