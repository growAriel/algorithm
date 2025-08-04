package org.example.bst.binaryTree;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next; // For linked list representation, if needed;
    public Node() {}
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
