package org.example.bst.binaryTree;
import java.util.ArrayList;
import java.util.List;

public class populatingNextRightPointersInEachNodeIIDFS {
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

    private static List<Node> list = new ArrayList<>();
    public static Node connect(Node root) {
        dfs(root, 0);
        return root;
    }
    public static void dfs(Node node, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(node);
        } else {
            list.get(level).next = node;
            list.set(level, node);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
