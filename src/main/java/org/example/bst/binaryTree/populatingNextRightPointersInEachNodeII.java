package org.example.bst.binaryTree;

public class populatingNextRightPointersInEachNodeII {
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
        Node dummy = new Node();
        Node current = root;

        while (current != null) {
            dummy.next = null; // Reset dummy's next pointer for the new level
            Node nextLevel = dummy; // Pointer to build the next level
            while (current != null) {
                if (current.left != null) {
                    nextLevel.next = current.left; // Connect left child
                    nextLevel = nextLevel.next; // Move to the next position in the next level
                }
                if (current.right != null) {
                    nextLevel.next = current.right; // Connect right child
                    nextLevel = nextLevel.next; // Move to the next position in the next level
                }
                current = current.next; // Move to the next node in the current level){
            }
            current = dummy.next; // Move to the first node of the next level
        }
        return root; // Return the modified tree with next pointers set
    }
}
