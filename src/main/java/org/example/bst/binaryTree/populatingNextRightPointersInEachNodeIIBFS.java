package org.example.bst.binaryTree;
import java.util.ArrayList;
import java.util.List;

public class populatingNextRightPointersInEachNodeIIBFS {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        connect(root);

        // Print the next pointers for verification
        System.out.println("Node 1 next: " + (root.next == null ? "null" : root.next.val));
        System.out.println("Node 2 next: " + (root.left.next == null ? "null" : root.left.next.val));
        System.out.println("Node 3 next: " + (root.right.next == null ? "null" : root.right.next.val));
        System.out.println("Node 4 next: " + (root.left.left.next == null ? "null" : root.left.left.next.val));
        System.out.println("Node 5 next: " + (root.left.right.next == null ? "null" : root.left.right.next.val));
        System.out.println("Node 7 next: " + (root.right.right.next == null ? "null" : root.right.right.next.val));
    }


    public static Node connect(Node root) {
        if (root == null) {
            return null; // If the tree is empty, return null
        }

        List<Node> list = List.of(root); // Initialize the list with the root node
        while (!list.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>(); // Prepare a list for the next level
            Node prev = null; // Previous node in the current level

            for (Node node : list) {
                if (prev != null) {
                     prev.next = node; // Set the next pointer of the previous node
                }
                prev = node; // Update the previous node to the current one

                // Add child nodes to the next level list
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }

            list = nextLevel; // Move to the next level
        }


        return root; // Return the modified tree with next pointers set

    }

}
